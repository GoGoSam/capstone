#include<config_params.h>
#include<fstream>
#include<string>
#include<iostream>
#include <sstream>
#include <ctime>

using namespace std;

///////////////////////////////////////
/// System Configuration Parameters ///
///////////////////////////////////////
string	config_folder = "C:/capstone/SYS/CONFIG";
string	cd_det_folder;
string	cd_inp_folder;
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
string rd_inp_folder;
string rd_det_folder;

////////////////////////////////////////////////
/// Object Detector Configuration Parameters ///
////////////////////////////////////////////////
string od_inp_folder;
string od_det_folder;

/////////////////
/// Functions ///
/////////////////

void store_line(
	string key,
	string value_in
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

	/// Rust Detector Parameters
	else if ( "rd_det_folder" == key) {rd_det_folder = value;}
	else if ( "rd_inp_folder" == key) {rd_inp_folder = value;}

	/// Object Detector Parameters
	else if ( "od_det_folder" == key) {od_det_folder = value;}
	else if ( "od_inp_folder" == key) {od_inp_folder = value;}
	
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

void get_timestamp(
	char * outstr
	) {
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
	for (int i = 0; i < 14; i++) {
		outstr[i] = datestr[i];
	}
}