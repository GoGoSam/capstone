
#include <fstream>
#include <iostream>
#include <sstream>
#include <iomanip>
#include <cstdlib>
#include <config_params.h>
#include <det_utils.h>
#include <glcm.h>


using namespace cv;
using namespace std;



int crack_det(
	string filename
	)
{

	/// Get Timestamp
	string time_stamp;
	time_stamp = get_timestamp();


	/// Put together some filenames
	string inp_filename = cd_inp_folder + filename + ".jpg";
	string det_filename = cd_det_folder + "IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = cd_det_folder + "CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = cd_det_folder + "PRM/" + filename + "." + time_stamp + ".det.prm.csv";

	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();

	
	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image_raw = loadImageMat(inp_filename_ptr, 0);
	cout << "Done!" << endl;


	/// Crack detection algorithm
	cout << "Calculating line response...";
	Mat image_line_response;
	fujitaCrackDet(image_raw, image_line_response);
	cout << "Done!" << endl;
	

	/// Binary Threshold and Morph
	cout << "Binary threshold and processing...";
	Mat image_binary;
	binaryMorph(image_line_response,image_binary); 
	cout << "Done!" << endl;


	/// Find Regions
	vector<vector<Point> > region_all, region_pass;
	vector<Vec4i> hierarchy;
	findContours(image_binary, region_all, hierarchy, CV_RETR_TREE, CV_CHAIN_APPROX_SIMPLE, Point(0, 0) );
	region_pass = region_all;


	/// Remove small regions
	double region_perimeter,region_area,region_circularity;

	double PI4 = atan(1.0)*16; // Precalculate FOR SPEED
	int j = 0;
	RotatedRect rectange_minimum_fit;
	
	// Save to det log file
	ofstream LogFile;
	if (cd_save_det_log) {
		LogFile.open (log_filename, ios::out | ios::trunc) ;
		LogFile << "Crack #"
			<< ',' << "Perimeter"
			<< ',' << "Area"
			<< ',' << "Circularity"
			<< ',' << "Height"
			<< ',' << "Width" 
			<< ',' << "Angle"
			<< ',' << "X Location"
			<< ',' << "Y Location" << endl;
	}

	// Print to terminal
	if (cd_disp_terminal) {
		cout << '|' << setw(10) << "Crack #"
			<< '|' << setw(10) << "Perim"
			<< '|' << setw(10) << "Area"
			<< '|' << setw(10) << "Circ"
			<< '|' << setw(10) << "Asp Ratio"
			<< '|' << setw(10) << "Height"
			<< '|' << setw(10) << "Width"
			<< '|' << setw(10) << "Angle"
			<< '|' << setw(10) << "X Loc"
			<< '|' << setw(10) << "Y Loc"<< '|' << endl;
	}

	bool cc;
	bool cp;

	/// Filter binary regions for crack like properties
	cout << "Finding regions";
	for( int i = 0; i < region_all.size(); i++ ) {
		cout << ".";
		// get min area rectangle
		rectange_minimum_fit = minAreaRect( Mat(region_all[i]) );

		// Calculate region characteristics
		region_perimeter = arcLength ( Mat ( region_all[i] ), true );
		region_area = contourArea (Mat ( region_all[i] ));
		region_circularity = (PI4 * region_area / (region_perimeter * region_perimeter));

		// Does it pass?
		cc = region_circularity < cd_circularity_threshold;
		cp = region_perimeter > cd_perimeter_threshold;

		// If it passes the thresholds, add it to the passing list
		if ( (cp && cc) && (region_area != 0)) {
			region_pass[j] = region_all[i];
			j++;
			
			// Save to det log file
			if (cd_save_det_log) {
				LogFile << i
					<< ',' << region_perimeter
					<< ',' << region_area
					<< ',' << region_circularity
					<< ',' << rectange_minimum_fit.size.height
					<< ',' << rectange_minimum_fit.size.width
					<< ',' << rectange_minimum_fit.angle
					<< ',' << rectange_minimum_fit.center.x
					<< ',' << rectange_minimum_fit.center.y << endl;
			}

			// Print to terminal
			if (cd_disp_terminal) {
				cout << '|' << setw(10) << i
					<< '|' << setw(10) << region_perimeter
					<< '|' << setw(10) << region_area
					<< '|' << setw(10) << region_circularity
					<< '|' << setw(10) << rectange_minimum_fit.size.height
					<< '|' << setw(10) << rectange_minimum_fit.size.width 
					<< '|' << setw(10) << rectange_minimum_fit.angle 
					<< '|' << setw(10) << rectange_minimum_fit.center.x 
					<< '|' << setw(10) << rectange_minimum_fit.center.y
					<< '|' << endl;
			}
		}
	}
	region_pass.resize(j);
	if (cd_save_det_log) {
		LogFile.close();
	}
	cout << "Done!" << endl;

	Mat image_highlighted = drawContourList(region_pass, hierarchy, image_raw);

	///// Display images
	if (cd_disp_images) {
		imshow( "image: original", image_raw);
		imshow( "image: line response", image_line_response );
		imshow( "image: highlighted", image_highlighted );
	}
	/// Display image histograms
	if (cd_disp_histograms) {
		showHistogram(image_raw, "hist: original");
		showHistogram(image_line_response, "hist: f(x,y)");
	}

	// Save the highlighted image
	if (cd_save_det_image) {
		vector<int> compression_params;
		compression_params.push_back(CV_IMWRITE_JPEG_QUALITY );
		compression_params.push_back(100);
		imwrite(det_filename_ptr, image_highlighted, compression_params);
	}

	// Save the parameters used
	if (cd_save_det_log || cd_save_det_image) {
		LogFile.open (prm_filename, ios::out | ios::trunc) ;
		LogFile << "cd_msmooth_n," << cd_msmooth_n << endl;
		LogFile << "cd_msmooth_av," << cd_msmooth_av << endl;
		LogFile << "cd_dilate_x1," << cd_dilate_x1 << endl;
		LogFile << "cd_dilate_x2," << cd_dilate_x2 << endl;
		LogFile << "cd_dilate_beta," << cd_dilate_beta << endl;
		LogFile << "cd_dilate_gamma," << cd_dilate_gamma << endl;
		LogFile << "cd_gsmooth_n," << cd_gsmooth_n << endl;
		LogFile << "cd_binary_threshold," << cd_binary_threshold << endl;
		LogFile << "cd_circularity_threshold," << cd_circularity_threshold << endl;
		LogFile << "cd_perimeter_threshold," << cd_perimeter_threshold << endl;
		LogFile << "cd_aspect_ratio_threshold," << cd_aspect_ratio_threshold << endl;
		LogFile.close();
	}



    waitKey(0);
	if (cd_disp_terminal || cd_disp_images || cd_disp_histograms) {
		std::cin.ignore();
	}
	return 0;
	}


int texture_disp(
	string filename
	) {
	
	string time_stamp;
	time_stamp = get_timestamp();

	string inp_filename = rd_inp_folder + filename + ".jpg";
	string det_filename = rd_det_folder + "IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = rd_det_folder + "CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = rd_det_folder + "PRM/" + filename + "." + time_stamp + ".det.prm.csv";

	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();

	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image_raw= loadImageMat(inp_filename_ptr, 1);
	cout << "Done!" << endl;
	
	
	
	
	int num_roi;
	int patch_radius = 7;
	int patch_size = 2*patch_radius + 1;
	// image size  should be integer multiple of patch size

	//resize image
	int ix = patch_size * (image_raw.rows / patch_size);
	int iy = patch_size * (image_raw.cols / patch_size);
	image_raw = image_raw(Range(0,0), Range(ix, iy));

	// Reduce color depth of image
	int bits = 6;
	Mat image_rd(image_raw.size(), image_raw.type());
	reduceDepth(image_raw, image_rd, bits);
	
	Mat image_texture(ix, iy, CV_8UC1);
	for (int i = 0; i < image_raw.rows; i += patch_size) {
		for (int j = 0; j < image_raw.cols; j += patch_size) {
		
			// Get patch
			Mat patch = image_rd(Range(i,
									   j),
								 Range(i+patch_size,
									   j+patch_size));
									
			// Calculate GLCM of patch
			Mat glcm_c;
			glcm(patch, glcm_c, 6);
			
			// Calculate GLCM energy of patch
			int energy = glcmUniformity(glcm_c);
			cout << "" << energy << endl;
		
			for (int it = i; it < i + patch_size; it++) {
				for (int jt = j; jt < j + patch_size; jt++) {
					image_texture.at<uchar>(it,jt) = energy;
				}
			}
		}
	}
	
	imshow("original image", image_raw);
	imshow("image reduced", image_rd);
	imshow("texture energy", image_texture);
	waitKey(0);
	return 0;
}


int rust_det(
	string filename
	) {
	
	string time_stamp;
	time_stamp = get_timestamp();

	string inp_filename = rd_inp_folder + filename + ".jpg";
	string det_filename = rd_det_folder + "IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = rd_det_folder + "CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = rd_det_folder + "PRM/" + filename + "." + time_stamp + ".det.prm.csv";

	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();

	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image_raw = loadImageMat(inp_filename_ptr, 1);
	cout << "Done!" << endl;
	Mat image_ds;
	//showHistogram(image,"ori");
	reduceDepth(image_raw, image_ds, 3);
	showHistogram(image_ds,"rd");
	imshow( "image: original", image_raw );
	imshow("image: down sampled", image_ds);
	waitKey(0);
	return 0;
}

int obj_det(
	string filename
	) {
	
	string time_stamp;
	time_stamp = get_timestamp();

	string inp_filename = od_inp_folder + filename + ".jpg";
	string det_filename = od_det_folder + "IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = od_det_folder + "CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = od_det_folder + "PRM/" + filename + "." + time_stamp + ".det.prm.csv";
	cout << od_inp_folder << endl;
	cout << od_det_folder << endl;
	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();

	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image_raw = loadImageMat(inp_filename_ptr, 0);
	cout << "Done!" << endl;
	Mat image_ch;
	cornerHarris(image_raw, image_ch, 21, 3, 0.5, BORDER_REPLICATE);

	double minVal, maxVal;
	minMaxLoc(image_ch, &minVal, &maxVal); //find minimum and maximum intensities
	Mat draw;
	image_ch.convertTo(draw, CV_8U, 255.0/(maxVal - minVal), -minVal * 255.0/(maxVal - minVal));
	cout << "min: " << minVal << endl << "max: " << maxVal << endl;
	imshow( "image: original", image_raw );
	imshow( "image: differential", draw);
    waitKey(0);
	return 0;
}


//int main( int argc, char** argv )
int main()
{
	systemConfig();
    //if( argc != 2)
    //{
    // cout <<" Usage: display_image ImageToLoadAndDisplay" << endl;
    // return -1;
    //}

	if (1) {
		const char *args[] = {"cracks1", "cracks2", "cracks3", "cracks4", "cracks5", "paper1"};
		vector<string> inp_fname(args, end(args));

		for (int i = 0; i < inp_fname.size(); i++) {
			crack_det(inp_fname[i]);
		}
	}
	if (0) {
		const char *args[] = {"rust1", "rust2", "rust3", "rust4", "rust5", "rust1"};
		vector<string> inp_fname(args, end(args));

		for (int i = 0; i < inp_fname.size(); i++) {
			texture_disp(inp_fname[i]);
			//rust_det(inp_fname[i]);
		}
	}
	if (0) {
		const char *args[] = {"anchor1", "anchor2", "anchor3", "anchor4", "anchor5", "anchor6"};
		vector<string> inp_fname(args, end(args));

		//for (int i = 0; i < inp_fname.size(); i++) {
			obj_det(inp_fname[3]);
		//}
	}
}