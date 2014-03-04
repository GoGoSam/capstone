
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


int crackDetection(
	char * input_directory,
	string filename,
	char * output_directory
	)
{

	/// Get Timestamp
	string time_stamp;
	time_stamp = get_timestamp();


	/// Put together some filenames
	string inp_filename = string(input_directory) + "/" + filename + ".jpg";
	string det_filename = string(output_directory) + "/IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = string(output_directory) + "/CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = string(output_directory) + "/PRM/" + filename + "." + time_stamp + ".det.prm.csv";

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


int rustDetection(
	char * input_directory,
	string filename,
	char * output_directory
	)
{

	/// Get Timestamp
	string time_stamp;
	time_stamp = get_timestamp();


	/// Put together some filenames
	string inp_filename = string(input_directory) + "/" + filename + ".jpg";
	string det_filename = string(output_directory) + "/IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = string(output_directory) + "/CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = string(output_directory) + "/PRM/" + filename + "." + time_stamp + ".det.prm.csv";

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


int hangerStraightDetection(
	char * input_directory,
	vector<string> file_list,
	char * output_directory
	)
{

	/// Get Timestamp
	string time_stamp;
	time_stamp = get_timestamp();


	/// Put together some filenames
	string inp_filename1 = string(input_directory) + "/" + file_list[0] + ".jpg";
	string inp_filename2 = string(input_directory) + "/" + file_list[1] + ".jpg";
	string det_filename = string(output_directory) + "/IMG/" + file_list[0] + "_" + file_list[1] + "." + time_stamp + ".det.jpg";
	string log_filename = string(output_directory) + "/CSV/" + file_list[0] + "_" + file_list[1] + "." + time_stamp + ".det.csv";
	string prm_filename = string(output_directory) + "/PRM/" + file_list[0] + "_" + file_list[1] + "." + time_stamp + ".det.prm.csv";
	
	const char* inp_filename_ptr1 = inp_filename1.data();
	const char* inp_filename_ptr2 = inp_filename2.data();
	const char* det_filename_ptr = det_filename.data();

	// Load the images
	cout << "Loading image 1" << filename << "...";
	Mat image_raw1 = loadImageMat(inp_filename_ptr1, 1);
	cout << "Done!" << endl;

	//longestHoughLine();

	cout << "Loading image 2" << filename << "...";
	Mat image_raw2 = loadImageMat(inp_filename_ptr2, 1);
	cout << "Done!" << endl;



	waitKey(0);
	return 0;
}



int hangerCenterDetection(
	char * input_directory,
	string filename,
	char * output_directory
	)
{

	/// Get Timestamp
	string time_stamp;
	time_stamp = get_timestamp();


	/// Put together some filenames
	string inp_filename = string(input_directory) + "/" + filename + ".jpg";
	string det_filename = string(output_directory) + "/IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = string(output_directory) + "/CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = string(output_directory) + "/PRM/" + filename + "." + time_stamp + ".det.prm.csv";

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

int crackDifferenceDetection(
	char * input_directory,
	vector<string> file_list,
	char * output_directory
	)
{

	/// Get Timestamp
	string time_stamp;
	time_stamp = get_timestamp();


	/// Put together some filenames
	string inp_filename = string(input_directory) + "/" + file_list[0] + ".jpg";
	string det_filename = string(output_directory) + "/IMG/" + filename + "." + time_stamp + ".det.jpg";
	string log_filename = string(output_directory) + "/CSV/" + filename + "." + time_stamp + ".det.csv";
	string prm_filename = string(output_directory) + "/PRM/" + filename + "." + time_stamp + ".det.prm.csv";

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


int main( int argc, char* argv )
//int main()
{	
    if (argc < 9) { // Check the value of argc. If not enough parameters have been passed, inform user and exit.
        std::cout << "Usage is  ./image_detector.exe --indir <input directory> --outdir <output directory> --type <test type> --infil <input file>\n"; // Inform the user of how to use the program
        std::cin.get();
        exit(0);
    } else { // if we got enough parameters...   
		char* input_directory;
		char* output_directory;
		int type;
		vector<string> input_file_list;
        std::cout << argv[0];
        for (int i = 1; i < argc; i++) { /* We will iterate over argv[] to get the parameters stored inside.
                                          * Note that we're starting on 1 because we don't need to know the 
                                          * path of the program, which is stored in argv[0] */
            if (i + 1 != argc) // Check that we haven't finished parsing already
                if (string(&argv[i]) == "--indir") {
                    // We know the next argument *should* be the filename:
                    input_directory = &argv[i + 1];
                } else if (string(&argv[i]) == "--outdir") {
                    output_directory = &argv[i + 1];
                } else if (string(&argv[i]) == "--type") {
					if (string(&argv[i]) == "crack") {
						type = 1;
					} else if (string(&argv[i]) == "rust") {
						type = 2;
					} else if (string(&argv[i]) == "hangerStraight") {
						type = 3;
					} else if (string(&argv[i]) == "hangerCenter") {
						type = 4;
					} else if (string(&argv[i]) == "crackDifference") {
						type = 5;
					}
                } else if (string(&argv[i]) == "--infil") {
					input_file_list.push_back(string(&argv[i+1]));
                } else {
                    std::cout << "Not enough or invalid arguments, please try again.\n";
                    exit(0);
            }
            std::cout << argv[i] << " ";
        }

		// Load detection parameters
		systemConfig();
		

		if (type == 1) { // Crack Detection
			for (int f = 0; f < input_file_list.size(); f++) {
				crackDetection(input_directory, input_file_list[f], output_directory);
			}
		} else if (type == 2) { // Rust Detection
			for (int f = 0; f < input_file_list.size(); f++) {
				rustDetection(input_directory, input_file_list[f], output_directory);
			}
		} else if (type == 3) { // Hanger Straight Detection
			hangerStraightDetection(input_directory, input_file_list, output_directory);
		} else if (type == 4) { // Hanger Center Detection
			hangerCenterDetection(input_directory, input_file_list[1], output_directory);
		} else if (type == 5) { // Crack Difference Detection
			crackDifferenceDetection(input_directory, input_file_list, output_directory);
		} else {
			std::cout << "No or invalid test type, please try again.\n";
            exit(0);
        }


        //... some more code
        std::cin.get();
        return 0;
    }
}