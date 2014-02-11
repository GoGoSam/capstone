#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <iostream>
#include <fstream>

#include <config_params.h>

using namespace std;
using namespace cv;



void binaryBridge(Mat &src, Mat &dst) {
	Mat tmp(src.size(), src.type());
	for (int i = 1; i < (src.rows-1); i++) {
		for (int j = 1; j < (src.cols-1); j++) {
			if (src.at<uchar>(i,j)==0) {
				if ((src.at<uchar>(i-1,j)>0) &
					(src.at<uchar>(i+1,j)>0) ) { 
					tmp.at<uchar>(i,j) = 255;}
				else if ((src.at<uchar>(i,j-1)>0) &
						 (src.at<uchar>(i,j+1)>0)) {
					tmp.at<uchar>(i,j) = 255;}
				else { tmp.at<uchar>(i,j) = 0;}}
			else { tmp.at<uchar>(i,j) = 255;}
		}
	}
	dst = tmp;
}


void binarySpurClean(Mat &src, Mat &dst) {
	Mat tmp(src.size(), src.type());
	for (int i = 1; i < (src.rows-1); i++) {
		for (int j = 1; j < (src.cols-1); j++) {
			if ((src.at<uchar>(i,j)>0)) {
				if ((src.at<uchar>(i-1,j)>0) |
					(src.at<uchar>(i+1,j)>0) |
					(src.at<uchar>(i,j-1)>0) |
					(src.at<uchar>(i,j+1)>0)) { tmp.at<uchar>(i,j) = 255;}
				else { tmp.at<uchar>(i,j) = 0;}}
			else { tmp.at<uchar>(i,j) = 0;}
		}
	}
	dst = tmp;
}



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
	Mat drawing = Mat::zeros( image.size(), image.type() );
	for( int i = 0; i< contours.size(); i++ )
	//for( int i = 0; i< 1; i++ )
    {
		Scalar color = Scalar( rng.uniform(0, 255), rng.uniform(0,255), rng.uniform(0,255) );
		drawContours( drawing, contours, i, 255, 1, 4, hierarchy, 0, Point() );
		circle( drawing, mc[i], 4, 255, -1, 4, 0 );
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

void calcHessian(
	Mat src,
	Mat l1,
	Mat l2,
	int scale,
	int delta,
	int ddepth,
	int gsmooth_n,
	double gsigma
	) {
	//int scale = 1;
	//int delta = 0;
	//int ddepth = CV_16S;
	/// Generate grad_x and grad_y
	Mat grad_x, grad_y, grad_xy, gsmooth;
	Mat m1, m2;
	Mat det, trace;
	Mat abs_grad_x, abs_grad_y, abs_grad_xy;
	Mat grad;

	/// G
	GaussianBlur(src, gsmooth, Size(gsmooth_n,gsmooth_n), gsigma, gsigma, BORDER_DEFAULT );	
	/// Gx
	Sobel( gsmooth, grad_x, ddepth, 1, 0, 3, scale, delta, BORDER_DEFAULT );
	//convertScaleAbs( grad_x, abs_grad_x );

	/// Gxx
	Sobel( grad_x, grad_x, ddepth, 1, 0, 3, scale, delta, BORDER_DEFAULT );
	//convertScaleAbs( grad_x, abs_grad_x );

	/// Gy
	Sobel( gsmooth, grad_y, ddepth, 0, 1, 3, scale, delta, BORDER_DEFAULT );
	//convertScaleAbs( grad_y, abs_grad_y );

	/// Gyy
	Sobel( grad_y, grad_y, ddepth, 0, 1, 3, scale, delta, BORDER_DEFAULT );
	//convertScaleAbs( grad_y, abs_grad_y );


	/// Ixy
	Sobel( grad_x, grad_xy, ddepth, 0, 1, 3, scale, delta, BORDER_DEFAULT );
	//convertScaleAbs( grad_xy, abs_grad_xy );


	/// Det
	//multiply(grad_x, grad_y, m1);
	//multiply(grad_xy, grad_xy, m2);
	//subtract(m1, m2, det);

	/// Trace
	//add(grad_x, grad_y, trace);

	
	// Eigen Values
	Mat eigResults;
	Mat L1(src.size(), CV_32FC1);
	Mat L2(src.size(), CV_32FC1);
	for (int i = 0; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			float ldata[] = {grad_y.at<uchar>(i,j), grad_xy.at<uchar>(i,j), grad_xy.at<uchar>(i,j), grad_x.at<uchar>(i,j)};
			Mat L = Mat(2,2,CV_32F,ldata).clone();
			eigen(L, eigResults);
			if (eigResults.at<uchar>(1) > eigResults.at<uchar>(2)){
				L1.at<uchar>(i,j) = eigResults.at<uchar>(1);
				L2.at<uchar>(i,j) = eigResults.at<uchar>(2);
			}
			else {
				L1.at<uchar>(i,j) = eigResults.at<uchar>(2);
				L2.at<uchar>(i,j) = eigResults.at<uchar>(1);
			}
		}
	}
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

	
		//showHistogram(image, "hist: original");
		//showHistogram(image_s, "hist: s(x,y)");
		//showHistogram(image_f, "hist: f(x,y)");
		//waitKey(0);

	return image_f;
}


void fujitaCrackDet(Mat &src, Mat &dst) {
	Mat imageMedian, imageShadow;
	// Median image
	medianBlur(src, imageMedian, cd_medianHsize);
	// Shadow image
	subtract(imageMedian, src, imageShadow);
	
	Mat lineResponseImage = Mat::zeros(src.size(), CV_32FC1);
	double lineResponse;
	for (int m = 0; m < cd_gausSteps; m++) {
		Mat l1, l2;
		double sigmaI = cd_gausSigma*pow(cd_gausScale,m);
		calcHessian(imageShadow, l1, l2, 1, 0, CV_16S, cd_gausHsize, sigmaI);
		
		for (int i = 1; i < (src.rows-1); i++) {
			for (int j = 1; j < (src.cols-1); j++) {
				if ((l2.at<uchar>(i,j)<l1.at<uchar>(i,j))&&(l1.at<uchar>(i,j)<0))
					lineResponse = abs(l1.at<uchar>(i,j)+l2.at<uchar>(i,j));
				else if ((l2.at<uchar>(i,j) < 0)&&
						 (0 < l1.at<uchar>(i,j))&&
						 (l1.at<uchar>(i,j) < abs(l2.at<uchar>(i,j)/cd_eigAlpha)))
					lineResponse = abs(l2.at<uchar>(i,j))+cd_eigAlpha*l1.at<uchar>(i,j);
				else
					lineResponse = 0;
				if (lineResponse > lineResponseImage.at<uchar>(i,j))
					lineResponseImage.at<uchar>(i,j) = lineResponse;
			}
		} 
	}
	dst = lineResponseImage;
}

void binaryMorph(Mat &src, Mat &dst) {
	Mat image_t(src.size(), src.type());
	
	// Binary Threshold
	threshold(src, image_t, cd_binary_threshold, 255, THRESH_BINARY);

	
	int dilation_size = 1;
	int erosion_size = 1;

	//Erode image
	int erosion_type = MORPH_ELLIPSE;
	Mat element = getStructuringElement( erosion_type,
                                   Size( 2*erosion_size + 1, 2*erosion_size+1 ),
                                   Point( erosion_size, erosion_size ) );
	erode( image_t, image_t, element );

	//Dilate image
	int dilation_type = MORPH_ELLIPSE;
	 element = getStructuringElement( dilation_type,
                                       Size( 2*dilation_size + 1, 2*dilation_size+1 ),
                                       Point( dilation_size, dilation_size ) );
	dilate( image_t, image_t, element );
	
	// Bridge
	binaryBridge(image_t, image_t);

	//Spur & clean
	binarySpurClean(image_t, image_t);

	dst = image_t;
}
