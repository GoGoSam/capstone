
#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>

#include <glcm.h>

using namespace std;
using namespace cv;


void reduceDepth(Mat &src, Mat &dst, int bits) {
	Mat image_ds = src.clone();//(src.rows,src.cols,src.type(), cv::Scalar::all(0) );
	int bit_shift = 8-bits;
	if (src.channels()==1)
		for(int i=0; i<src.rows; i++)
			for(int j=0; j<image_ds.cols; j++)
				image_ds.at<uchar>(i,j) = src.at<uchar>(i,j) & (0xff<<(bit_shift));
	else if (src.channels()==3)
		for(int i=0; i<src.rows; i++)
			for(int j=0; j<image_ds.cols; j++) {
				Vec3b intensity = src.at<Vec3b>(i,j);
				intensity.val[0] = intensity.val[0]	& (0xff<<bit_shift);
				intensity.val[1] = intensity.val[1]	& (0xff<<bit_shift);
				intensity.val[2] = intensity.val[2]	& (0xff<<bit_shift);
				image_ds.at<Vec3b>(i,j) = intensity;
			}
	dst = image_ds;
}


void glcm(Mat &src, Mat &dst, int bits) {
	int vals = 2^bits;
	Mat glcm_mat(vals, vals, src.type());
	for (int i = 0; i < (src.rows-1); i++) {
		for (int j = 0; j < (src.cols-1); j++) {
			glcm_mat.at<uchar>(src.at<uchar>(i,j), src.at<uchar>(i+1,j+1)) +=1;
		}
	}
	
	for (int i = 0; i < vals; i++) {
		for (int j = 0; j < vals; j++) {
			glcm_mat.at<uchar>(i,j) /= vals^2;
		}
	}
	
	dst = glcm_mat;
}


float glcmUniformity(Mat &src) {
// small when all elements in C are equal
	float energy = 0;
	for (int i = 0; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			energy += src.at<uchar>(i,j)^2;
		}
	}

	return energy;
}

float glcmContrast(Mat &src) {

	float contrast = 0;
	for (int i = 0; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			contrast += (i-j)^2*src.at<uchar>(i,j);
		}
	}
	
	return contrast;
}


float glcmEntropy(Mat &src) {
// measure of randomness. high return value if elements in C are equal. Low if a checker board
	float entropy = 0;
	for (int i = 0; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			entropy -= (static_cast<float>(src.at<uchar>(i,j)))*log(static_cast<float>(src.at<uchar>(i,j)));
		}
	}
	
	return entropy;
}

float glcmHomogeneity(Mat &src) {
// large if big values are along diagonal of C
	float hom = 0;
	for (int i = 0; i < src.rows; i++) {
		for (int j = 0; j < src.cols; j++) {
			hom += src.at<uchar>(i,j)/(1+abs(i-j));
		}
	}
	
	return hom;
}


