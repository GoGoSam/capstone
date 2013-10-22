// include guard
#ifndef __CONFIG_PARAMS_H_INCLUDED__
#define __CONFIG_PARAMS_H_INCLUDED__

#include <string>



using namespace std;

///////////////////////////////////////
/// System Configuration Parameters ///
///////////////////////////////////////
extern string	config_folder;
extern string	cd_det_folder;
extern string	cd_inp_folder;
extern bool	cd_disp_terminal;
extern bool	cd_disp_images;
extern bool	cd_disp_histograms;
extern bool	cd_save_det_image;
extern bool	cd_save_det_log;

///////////////////////////////////////////////
/// Crack Detector Configuration Parameters ///
///////////////////////////////////////////////
extern int cd_msmooth_n;
extern int cd_msmooth_av;
extern int cd_dilate_x1;
extern int cd_dilate_x2;
extern int cd_dilate_beta;
extern int cd_dilate_gamma;
extern int cd_gsmooth_n;
extern int cd_binary_threshold;
extern double cd_circularity_threshold;
extern int cd_perimeter_threshold;
extern int cd_aspect_ratio_threshold;


//////////////////////////////////////////////
/// Rust Detector Configuration Parameters ///
//////////////////////////////////////////////
extern string rd_inp_folder;
extern string rd_det_folder;


////////////////////////////////////////////////
/// Object Detector Configuration Parameters ///
////////////////////////////////////////////////
extern string od_inp_folder;
extern string od_det_folder;


/////////////////
/// Functions ///
/////////////////

void store_line(
	string key,
	string value_in
	);

void systemConfig();

void get_timestamp(
	char * outstr
	);

#endif