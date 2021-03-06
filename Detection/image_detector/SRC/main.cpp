#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

using namespace cv;
using namespace std;

///////////////////////////////////////
/// System Configuration Parameters ///
///////////////////////////////////////
String	config_folder = "C:/capstone/SYS/CONFIG";
String	cd_det_folder;
String	cd_inp_folder;
bool	cd_disp_terminal;
bool	cd_disp_images;
bool	cd_disp_histograms;
bool	cd_save_det_image;
bool	cd_save_det_log;

///////////////////////////////////////////////
/// Crack Detector Configuration Parameters ///
///////////////////////////////////////////////
int cd_msmooth_n;
int cd_msmooth_av;
int cd_dilate_x1;
int cd_dilate_x2;
int cd_dilate_beta;
int cd_dilate_gamma;
int cd_gsmooth_n;
int cd_binary_threshold;
double cd_circularity_threshold;
int cd_perimeter_threshold;
int cd_aspect_ratio_threshold;


//////////////////////////////////////////////
/// Rust Detector Configuration Parameters ///
//////////////////////////////////////////////
int rd_inp_folder

void showHistogram(
	Mat& img,
	string disp_name
	)
{
	int bins = 256;             // number of bins
	int nc = img.channels();    // number of channels

	vector<Mat> hist(nc);       // histogram arrays

	// Initalize histogram arrays
	for (int i = 0; i < hist.size(); i++)
		hist[i] = Mat::zeros(1, bins, CV_32SC1);

	// Calculate the histogram of the image
	for (int i = 0; i < img.rows; i++)
	{
		for (int j = 0; j < img.cols; j++)
		{
			for (int k = 0; k < nc; k++)
			{
				uchar val = nc == 1 ? img.at<uchar>(i,j) : img.at<Vec3b>(i,j)[k];
				hist[k].at<int>(val) += 1;
			}
		}
	}

	// For each histogram arrays, obtain the maximum (peak) value
	// Needed to normalize the display later
	int hmax[3] = {0,0,0};
	for (int i = 0; i < nc; i++)
	{
		for (int j = 0; j < bins-1; j++)
			hmax[i] = hist[i].at<int>(j) > hmax[i] ? hist[i].at<int>(j) : hmax[i];
	}

	const char* wname[3] = { "blue", "green", "red" };
	Scalar colors[3] = { Scalar(255,0,0), Scalar(0,255,0), Scalar(0,0,255) };

	vector<Mat> canvas(nc);

	// Display each histogram in a canvas
	for (int i = 0; i < nc; i++)
	{
		canvas[i] = Mat::ones(125, bins, CV_8UC3);

		for (int j = 0, rows = canvas[i].rows; j < bins-1; j++)
		{
			line(
				canvas[i], 
				Point(j, rows), 
				Point(j, rows - (hist[i].at<int>(j) * rows/hmax[i])), 
				nc == 1 ? Scalar(200,200,200) : colors[i], 
				1, 8, 0
			);
		}

		imshow(nc == 1 ? disp_name : wname[i], canvas[i]);
	}
}


Mat drawContourList(
	vector<vector<Point> > contours,
	vector<Vec4i> hierarchy,
	Mat image
	) {
	/// Get moments
	vector<Moments> mu(contours.size() );
	for( int i = 0; i < contours.size(); i++ )
		{ mu[i] = moments( contours[i], false ); }

	/// Get mass centers
	vector<Point2f> mc( contours.size() );
	for( int i = 0; i < contours.size(); i++ )
		{ mc[i] = Point2f( mu[i].m10/mu[i].m00 , mu[i].m01/mu[i].m00 ); }

	  /// Draw contours
	RNG rng(12345);
	Mat drawing = image;//Mat::zeros( drawing_size, CV_8UC3 );
	for( int i = 0; i< contours.size(); i++ )
	//for( int i = 0; i< 1; i++ )
    {
		//Scalar color = Scalar( rng.uniform(0, 255), rng.uniform(0,255), rng.uniform(0,255) );
		drawContours( drawing, contours, i, 0/*color*/, 2, 4, hierarchy, 0, Point() );
		circle( drawing, mc[i], 4, 0/*color*/, -1, 4, 0 );
    }
	return drawing;
}


Mat gradientXY(
	Mat image,
	int scale,
	int delta,
	int ddepth
	) {
	//int scale = 1;
	//int delta = 0;
	//int ddepth = CV_16S;
	/// Generate grad_x and grad_y
	Mat grad_x, grad_y;
	Mat abs_grad_x, abs_grad_y;
	Mat grad;

	/// Gradient X
	Sobel( image, grad_x, ddepth, 1, 0, 3, scale, delta, BORDER_DEFAULT );
	convertScaleAbs( grad_x, abs_grad_x );

	/// Gradient Y
	Sobel( image, grad_y, ddepth, 0, 1, 3, scale, delta, BORDER_DEFAULT );
	convertScaleAbs( grad_y, abs_grad_y );

	/// Total Gradient (approximate)
	addWeighted( abs_grad_x, 0.5, abs_grad_y, 0.5, 0, grad );
	
	return grad;
}


Mat invertImage(
	Mat image
	) {
	/// Invert image
	Mat image_i(image.rows,image.cols,CV_8U, cv::Scalar::all(0) );
	for (int i = 0; i < image.rows; i++) {
		for (int j = 0; j < image.cols; j++) {
			image_i.at<uchar>(i,j) = 255 - image.at<uchar>(i,j);
		}
	}
	return image_i;
}


Mat loadImageMat(
	const char* filename,
	bool colored
	) {
	//Mat image;
    //image = imread(argv[1], CV_LOAD_IMAGE_COLOR);   // Read the file
	//image = imread("C:\c.png",CV_LOAD_IMAGE_GRAYSCALE); // Read the file

		IplImage *img=cvLoadImage(filename,colored);

	if(! img )                              // Check for invalid input
    {
        cout <<  "Could not open or find the image" << std::endl;
		std::cin.ignore();
		Mat n;
        return n;
    }

	/// Convert from iplimage to mat
	Mat mat(img);
	Mat image;
	image = img;

	return image;
}


Mat difImage(
	Mat image,
	int n,
	int av
	) {
	Mat image_s(image.rows,image.cols,CV_8U, cv::Scalar::all(0) );
	medianBlur(image, image_s, n);
	Scalar gray_average = av;
	Mat image_f = image - image_s + gray_average - mean(image - image_s);
	return image_f;
}

char get_timestamp() {
	time_t rawtime;
	struct tm * timeptr;
	time (&rawtime);
	timeptr = gmtime (&rawtime);
	static char datestr[14];
	sprintf(datestr, "%.4d%.2d%.2d%.2d%.2d%.2d",
		timeptr->tm_year + 1990,
		timeptr->tm_mon + 1,
		timeptr->tm_mday, 
		timeptr->tm_hour,
		timeptr->tm_min,
		timeptr->tm_sec);
	return datestr;
}

int crack_det(
	String filename
	) {
	
	char datestr = get_timestamp();

	String inp_filename = cd_inp_folder + filename + ".jpg";
	String det_filename = cd_det_folder + "IMG/" + filename + "." + datestr + ".det.jpg";
	String log_filename = cd_det_folder + "CSV/" + filename + "." + datestr + ".det.csv";
	String prm_filename = cd_det_folder + "PRM/" + filename + "." + datestr + ".det.prm.csv";

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
	String filename
	) {
	
	datestr = get_timestamp();

	String inp_filename = rd_inp_folder + filename + ".jpg";
	String det_filename = rd_det_folder + "IMG/" + filename + "." + datestr + ".det.jpg";
	String log_filename = rd_det_folder + "CSV/" + filename + "." + datestr + ".det.csv";
	String prm_filename = rd_det_folder + "PRM/" + filename + "." + datestr + ".det.prm.csv";

	const char* inp_filename_ptr = inp_filename.data();
	const char* det_filename_ptr = det_filename.data();

	// Load the image
	cout << "Loading image " << filename << "...";
	Mat image = loadImageMat(inp_filename_ptr, 1);
	cout << "Done!" << endl;

	imshow( "image: original", image );
}



void store_line(
	String key,
	String value_in
	) {
	cout << key << "= " << value_in << endl;
	//const char*  key = key_in.c_str();
	const char*  value = value_in.c_str();
		/// System Parameters
	if ( "cd_disp_terminal" == key) {cd_disp_terminal = atoi(value);}
	else if ( "cd_disp_images" == key) {cd_disp_images = atoi(value);}
	else if ( "cd_disp_histograms" == key) {cd_disp_histograms = atoi(value);}
	else if ( "cd_save_det_image" == key) {cd_save_det_image = atoi(value);}
	else if ( "cd_save_det_log" == key) {cd_save_det_log = atoi(value);}
	else if ( "cd_det_folder" == key) {cd_det_folder = value;}
	else if ( "cd_inp_folder" == key) {cd_inp_folder = value;}
	/// Crack Detector Parameters
	else if ( "cd_msmooth_n" == key) {cd_msmooth_n = atoi(value);}
	else if ( "cd_msmooth_av" == key) {cd_msmooth_av = atoi(value);}
	else if ( "cd_dilate_x1" == key) {cd_dilate_x1 = atoi(value);}
	else if ( "cd_dilate_x2" == key) {cd_dilate_x2 = atoi(value);}
	else if ( "cd_dilate_beta" == key) {cd_dilate_beta = atoi(value);}
	else if ( "cd_dilate_gamma" == key) {cd_dilate_gamma = atoi(value);}
	else if ( "cd_gsmooth_n" == key) {cd_gsmooth_n = atoi(value);}
	else if ( "cd_binary_threshold" == key) {cd_binary_threshold = atoi(value);}
	else if ( "cd_circularity_threshold" == key) {cd_circularity_threshold = atof(value);}
	else if ( "cd_perimeter_threshold" == key) {cd_perimeter_threshold = atoi(value);}
	else if ( "cd_aspect_ratio_threshold" == key) {cd_aspect_ratio_threshold = atoi(value);}
		/// Object Detector Parameters
	
}

void systemConfig(){
	ifstream is_file;
	is_file.open("C:/capstone/image_detector/CONFIG/sys.cfg");

	std::string line;
	while( std::getline(is_file, line) )
	{
	  std::istringstream is_line(line);
	  std::string key;
	  if( std::getline(is_line, key, '=') )
	  {
		std::string value;
		if( std::getline(is_line, value) )
		  store_line(key, value);
	  }
	}
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

	if (0) {
		const char *args[] = {"cracks1", "cracks2", "cracks3", "cracks4", "cracks5", "paper1"};
		vector<String> inp_fname(args, end(args));

		for (int i = 0; i < inp_fname.size(); i++) {
			crack_det(inp_fname[i]);
		}
	}
	if (1) {
		const char *args[] = {"rust1", "rust2", "rust3", "rust4", "rust5", "rust1"};
		vector<String> inp_fname(args, end(args));

		for (int i = 0; i < inp_fname.size(); i++) {
			rust_det(inp_fname[i]);
		}
	}
}