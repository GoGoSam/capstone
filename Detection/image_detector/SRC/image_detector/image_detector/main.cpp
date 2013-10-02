
#include <fstream>
#include <iostream>
#include <sstream>
#include <iomanip>
#include <cstdlib>

#include <config_params.h>
#include <det_utils.h>

using namespace cv;
using namespace std;

int crack_det(
	string filename
	) {
	
	char datestr[14];
	get_timestamp(datestr);

	string inp_filename = cd_inp_folder + filename + ".jpg";
	string det_filename = cd_det_folder + "IMG/" + filename + "." + datestr + ".det.jpg";
	string log_filename = cd_det_folder + "CSV/" + filename + "." + datestr + ".det.csv";
	string prm_filename = cd_det_folder + "PRM/" + filename + "." + datestr + ".det.prm.csv";

	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();


	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image = loadImageMat(inp_filename_ptr, 0);
	cout << "Done!" << endl;

	/// Create a smoothed image and find the difference image
	cout << "Calculating differential image... ";
	Mat image_f = difImage(image, cd_msmooth_n, cd_msmooth_av);
	cout << "Done!" << endl;

	/// Dilate cracks
	cout << "Calculating dilated image... ";
	/// Get g(x,y)
	Mat image_g(image.rows,image.cols,CV_8U, cv::Scalar::all(0) );
	for (int i = 0; i < image.rows; i++) {
		for (int j = 0; j < image.cols; j++) {
			if (image_f.at<uchar>(i,j) < cd_dilate_x1 ) { image_g.at<uchar>(i,j) = 1;}
			else if (image_f.at<uchar>(i,j) > cd_dilate_x2) {image_g.at<uchar>(i,j) = 254;}
			else { image_g.at<uchar>(i,j) = cd_dilate_gamma + cd_dilate_beta * image.at<uchar>(i,j);}
		}
	}
	cout << "Done!" << endl;

	/// Gaussian blur filter
	cout << "Bluring image... ";
	GaussianBlur( image_g, image_g, Size(cd_gsmooth_n,cd_gsmooth_n), 0, 0, BORDER_DEFAULT );
	cout << "Done!" << endl;

	/// Get G(x,y)
	cout << "Thresholding image...";
	Mat image_G(image.rows,image.cols,CV_8U, cv::Scalar::all(0) );
	for (int i = 0; i < image.rows; i++) {
		for (int j = 0; j < image.cols; j++) {
			image_G.at<uchar>(i,j) = min(255, (255 - image_g.at<uchar>(i,j)) * (255 - image_g.at<uchar>(i,j)) / image_g.at<uchar>(i,j));
		}
	}

	/// Binary Threshold
	Mat image_F = image_G > cd_binary_threshold;
	cout << "Done!" << endl;


	/// Find contours
	vector<vector<Point> > all_contours, contours;
	vector<Vec4i> hierarchy;
	findContours(image_F, all_contours, hierarchy, CV_RETR_TREE, CV_CHAIN_APPROX_SIMPLE, Point(0, 0) );
	contours = all_contours;
	//contours.reserve(all_contours.size());

	/// Remove small contours


	double crack_perimeter;
	double crack_area;
	double crack_aspect_ratio;
	double crack_circularity;

	double pi4 = atan(1.0)*16;
	int j = 0;
	RotatedRect min_rect;
	
	ofstream LogFile;
	if (cd_save_det_log) {
		//LogFile.open (log_filename, ios::out | ios::app | ios::binary | ios::trunc) ;
		LogFile.open (log_filename, ios::out | ios::trunc) ;
		LogFile << "Crack #"
			<< ',' << "Perimeter"
			<< ',' << "Area"
			<< ',' << "Circularity"
			<< ',' << "Aspect Ratio"
			<< ',' << "Height"
			<< ',' << "Width" 
			<< ',' << "Angle"
			<< ',' << "X Location"
			<< ',' << "Y Location" << endl;
	}

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
	bool ca;
	bool cp;
	cout << "Finding contours";
	for( int i = 0; i < all_contours.size(); i++ ) {
		cout << ".";
		// get min area rectangle
		min_rect = minAreaRect( Mat(all_contours[i]) );

		crack_perimeter = arcLength ( Mat ( all_contours[i] ), true );
		crack_area = contourArea (Mat ( all_contours[i] ));
		crack_circularity = (pi4 * crack_area / (crack_perimeter * crack_perimeter));
		crack_aspect_ratio = max((min_rect.size.width / min_rect.size.height) , (min_rect.size.height/min_rect.size.width));

		cc = crack_circularity < cd_circularity_threshold;
		cp = crack_perimeter > cd_perimeter_threshold;
		ca = crack_aspect_ratio > cd_aspect_ratio_threshold;

		if ( ((cp && cc) || (cc && ca) || (cp && ca)) && (crack_area != 0)) {
			contours[j] = all_contours[i];
			j++;
			
			if (cd_save_det_log) {
				LogFile << i
					<< ',' << crack_perimeter
					<< ',' << crack_area
					<< ',' << crack_circularity
					<< ',' << crack_aspect_ratio
					<< ',' << min_rect.size.height
					<< ',' << min_rect.size.width
					<< ',' << min_rect.angle
					<< ',' << min_rect.center.x
					<< ',' << min_rect.center.y << endl;
			}
			if (cd_disp_terminal) {
				cout << '|' << setw(10) << i
					<< '|' << setw(10) << crack_perimeter
					<< '|' << setw(10) << crack_area
					<< '|' << setw(10) << crack_circularity
					<< '|' << setw(10) << crack_aspect_ratio
					<< '|' << setw(10) << min_rect.size.height
					<< '|' << setw(10) << min_rect.size.width 
					<< '|' << setw(10) << min_rect.angle 
					<< '|' << setw(10) << min_rect.center.x 
					<< '|' << setw(10) << min_rect.center.y
					<< '|' << endl;
			}
		}
	}
	contours.resize(j);
	if (cd_save_det_log) {
		LogFile.close();
	}
	cout << "Done!" << endl;

	Mat image_contour = drawContourList(contours, hierarchy, image_f);//_F.size());

	///// Display images and histograms
	if (cd_disp_images) {
		imshow( "image: original", image );
		imshow( "image: f(x,y)", image_f );
		imshow( "image: g(x,y)", image_g );
		imshow( "image: G(x,y)", image_G );
		imshow( "image: F(x,y)", image_F );
		imshow( "Contours", image_contour );
	}
	if (cd_disp_histograms) {
		showHistogram(image, "hist: original");
		showHistogram(image_f, "hist: f(x,y)");
		showHistogram(image_g, "hist: g(x,y)");
		showHistogram(image_G, "hist: G(x,y)");
		showHistogram(image_F, "hist: F(x,y)");
	}

	if (cd_save_det_image) {
		vector<int> compression_params;
		compression_params.push_back(CV_IMWRITE_JPEG_QUALITY );
		compression_params.push_back(100);
		imwrite(det_filename_ptr, image_contour, compression_params);
	}

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


int rust_det(
	string filename
	) {
	
	char datestr[14];
	get_timestamp(datestr);

	string inp_filename = rd_inp_folder + filename + ".jpg";
	string det_filename = rd_det_folder + "IMG/" + filename + "." + datestr + ".det.jpg";
	string log_filename = rd_det_folder + "CSV/" + filename + "." + datestr + ".det.csv";
	string prm_filename = rd_det_folder + "PRM/" + filename + "." + datestr + ".det.prm.csv";

	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();

	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image = loadImageMat(inp_filename_ptr, 1);
	cout << "Done!" << endl;

	return 0;

	imshow( "image: original", image );
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
			rust_det(inp_fname[i]);
		}
	}
}