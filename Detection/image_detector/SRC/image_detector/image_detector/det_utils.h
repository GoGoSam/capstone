// include guard
#ifndef __DET_UTILS_H_INCLUDED__
#define __DET_UTILS_H_INCLUDED__

#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <string>

using namespace std;
using namespace cv;

void showHistogram(
	Mat& img,
	string disp_name
	);


Mat drawContourList(
	vector<vector<Point> > contours,
	vector<Vec4i> hierarchy,
	Mat image
	);


Mat gradientXY(
	Mat image,
	int scale,
	int delta,
	int ddepth
	);

Mat hessian(
	Mat image,
	int scale,
	int delta,
	int ddepth,
	int gsmooth_n
	);

Mat invertImage(
	Mat image
	);


Mat loadImageMat(
	const char* filename,
	bool colored
	);


Mat difImage(
	Mat image,
	int n,
	int av
	);


#endif