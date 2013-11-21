// include guard
#ifndef __GLCM_H_INCLUDED__
#define __GLCM_H_INCLUDED__


#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>


using namespace std;
using namespace cv;


void reduceDepth(
	Mat&,
	Mat&,
	int
	);

	
void glcm(
	Mat,
	Mat,
	int
	);
	
	
float glcmUniformity(
	Mat
	);
	
	
float glcmContrast(
	Mat
	);
	
	
float glcmEntropy(
	Mat
	);
	
	
float glcmHomogeneity(
	Mat
	);


#endif