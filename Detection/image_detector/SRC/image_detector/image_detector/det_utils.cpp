#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <iostream>
#include <fstream>

#include <config_params.h>

using namespace std;
using namespace cv;

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


