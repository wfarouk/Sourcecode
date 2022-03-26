#include <jni.h>
#include <string>
#include <string.h>
#include <jni.h>
#include <time.h>
#include <sys/stat.h>
#include <stdio.h>
#include "android/log.h"
#include <errno.h>
#include <unistd.h>
#include <sys/syscall.h>
#include <sstream>
#include <fstream>

#include <sys/system_properties.h>
#define ANDROID_OS_BUILD_TAGS                "ro.build.tags"


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string result = "";
    // FILE* pipe = popen("su -c ls /data", "r");
    FILE* pipe = popen("su -c id", "r");

    //if (!pipe) return NULL;
    char buffer[128];
    std::string resultCmd = "";
    while(!feof(pipe)) {
        if(fgets(buffer, 128, pipe) != NULL)
            resultCmd += buffer;
    }
    pclose(pipe);
    return env->NewStringUTF(resultCmd.c_str());
}


// native2  test-keys
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI2(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";


    int len;
    char build_tags[PROP_VALUE_MAX]; // PROP_VALUE_MAX from <sys/system_properties.h>.
    std::string result1 = "";
    len = __system_property_get(ANDROID_OS_BUILD_TAGS, build_tags); // On return, len will equal (int)strlen(model_id).
    if(len >0 && strstr(build_tags,"test-keys") != NULL){
        //ANDROID_LOGV( "Device has test keys\n", build_tags);

        result1 = "yes";
    }

    //return result;
    return env->NewStringUTF(result1.c_str());
}



// // read aceess of data folder

#include <cstdlib>

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI3(
        JNIEnv *env,
        jobject /* this */) {

    std::string result = "";

    FILE* pipe = popen("su -c ls /data", "r");

    //if (!pipe) return NULL;
    char buffer[128];
    std::string resultCmd = "";
    while(!feof(pipe)) {
        if(fgets(buffer, 128, pipe) != NULL)
            resultCmd += buffer;
    }
    pclose(pipe);
    return env->NewStringUTF(resultCmd.c_str());

    const char *cstr = resultCmd.c_str();
    //int result = -1;

    if(cstr == NULL || (strlen(cstr) == 0)){
        result = "";
        return env->NewStringUTF(resultCmd.c_str());
        //ANDROID_LOGV( "Result of Which command is Null");
    }else{
        //result = 0;
        result = "yes"; //resultCmd;
        //ANDROID_LOGV( "Result of Which command %s\n", cstr);
    }

    return env->NewStringUTF(result.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI26(
        JNIEnv *env,
        jobject /* this */) {

    std::string result = "";

    FILE* pipe = popen("su -c ls /data", "r");

    //if (!pipe) return NULL;
    char buffer[128];
    std::string resultCmd = "";
    while(!feof(pipe)) {
        if(fgets(buffer, 128, pipe) != NULL)
            resultCmd += buffer;
    }
    pclose(pipe);
    return env->NewStringUTF(resultCmd.c_str());

    const char *cstr = resultCmd.c_str();
    //int result = -1;

    if(cstr == NULL || (strlen(cstr) == 0) || strstr( "system", cstr)){
        result = "yes";

        //ANDROID_LOGV( "Result of Which command is Null");
    }else{
        //result = 0;
        result = ""; //resultCmd;
        return env->NewStringUTF(resultCmd.c_str());
        //ANDROID_LOGV( "Result of Which command %s\n", cstr);
    }

    return env->NewStringUTF(result.c_str());

}
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI27(
        JNIEnv *env,
        jobject /* this */) {

    std::string result = "";

    FILE* pipe = popen("su -c ls /config", "r");

    //if (!pipe) return NULL;
    char buffer[128];
    std::string resultCmd = "";
    while(!feof(pipe)) {
        if(fgets(buffer, 128, pipe) != NULL)
            resultCmd += buffer;
    }
    pclose(pipe);
    return env->NewStringUTF(resultCmd.c_str());

    const char *cstr = resultCmd.c_str();
    //int result = -1;

    if(cstr == NULL || (strlen(cstr) == 0) || strstr( "system", cstr)){
        result = "yes";

        //ANDROID_LOGV( "Result of Which command is Null");
    }else{
        //result = 0;
        result = ""; //resultCmd;
        return env->NewStringUTF(resultCmd.c_str());
        //ANDROID_LOGV( "Result of Which command %s\n", cstr);
    }

    return env->NewStringUTF(result.c_str());

}

// existance of kingoapp.apk file
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI3a(
        JNIEnv *env,
        jobject /* this */) {

//    int intResult = access("/system/app/Superuser.apk",F_OK);

    //int intResult = Infield("/sdcard/download/xxx.apk",F_OK);
// If the requested access is permitted, access() succeeds and shall return 0; otherwise, -1 shall be returned and errno shall be set to indicate the error.

    // is file exist
    struct stat buf;
    // int intResult = stat("/data/app/com.kingoapp.apk-1.apk", &buf);
    char *directory = "/data";
    int intResult = chdir(directory);
// function stat() is to check if file exist return 0
    std::string result = "";
    if(intResult == 0){
        result = "yes";
        return env->NewStringUTF(result.c_str());
        //ANDROID_LOGV( "Result of Which command is Null");
    }else{
        //result = 0;
        result = "";
        //ANDROID_LOGV( "Result of Which command %s\n", cstr);
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    //you can also do this
    std::string output;
    //stm >> output;  //throw whats in the string stream into the string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


// check if su exist in /system/bin
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI3b(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0 -- it is working properly
    //struct stat buf;
    //int intResult = stat("/system/bin/su", &buf);
    const char *filename = "/data";
    int intResult = access(filename, R_OK);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}

// check if otacerts.zip file exists - for legal os image

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI4(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/etc/security/otacerts.zip", &buf);

    std::string result = "";
    if(intResult == -1){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}

// get list of apps - used for feature from 5 till 13

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI5(
        JNIEnv *env,
        jobject /* this */) {

    std::string result = "";

    // FILE* pipe = popen("su -c ls /data", "r");
    FILE* pipe = popen("pm list packages", "r");

    //if (!pipe) return NULL;
    char buffer[128];
    std::string resultCmd = "";
    while(!feof(pipe)) {
        if(fgets(buffer, 128, pipe) != NULL)
            resultCmd += buffer;
    }
    pclose(pipe);
    return env->NewStringUTF(resultCmd.c_str());

}





// check if su is in certain folders
/*
 *
 *
 15	/bin/su	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
16	/system/bin/su	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
17	/system/xbin/su	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
18	/sbin/su	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
19	/system/su	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
20	/system/bin/.ext/.su	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
21	/system/usr/we-need-root/su-backup	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
22	/system/xbin/mu	Su Binaries. The following list of Su binaries are often looked for on rooted devices.
23	SU-systemSDxbin	check if su exist /system/sd/xbin
24	SU-systemBinFailsafe	check if su exist /system/bin/failsafe
25	SU-dataLocal	check if su exist /data/local





/system/su
/system/bin/.ext/.su
/system/usr/we-need-root/su-backup
/system/xbin/mu
        check if su exist /system/sd/xbin
        check if su exist /system/bin/failsafe
        check if su exist /data/local
        SU-systemSDxbin
        SU-systemBinFailsafe
        SU-dataLocal
*/

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU15(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/bin/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU16(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/bin/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU17(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/xbin/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU18(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/sbin/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU19(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU20(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/bin/ext/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU21(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/usr/we-need-root/su-backup", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU22(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/xbin/mu", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU23(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/sd/xbin", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU24(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/system/bin/failsafe", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNISU25(
        JNIEnv *env,
        jobject /* this */) {

    // is file exist function stat() is to check if file exist return 0
    struct stat buf;
    int intResult = stat("/data/local/su", &buf);

    std::string result = "";
    if(intResult == 0){
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());
    }else{
        //result = 0;
        result = "";
    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<intResult;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}



// is writable folders from 28 to 41

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI28notworking(
        JNIEnv *env,
        jobject /* this */) {

    mode_t process_mask = umask(0);
    int result_code = mkdir("/data/newfolder28", S_IRWXU | S_IRWXG | S_IRWXO);
    umask(process_mask);

    if (result_code == 0) {
        std::string xxx= "yes";
        return  env->NewStringUTF(xxx.c_str());
    }else {
        std::string yyy= "no";
        return  env->NewStringUTF(yyy.c_str());
        }

// this is not working
//    struct stat buf;
//    std::string newFolder;
//    newFolder = "/data/newfolder28";
//    mkdir(newFolder.c_str(), 0770);
//
//    int intResult = stat("/data/newfolder28", &buf);
//
//    std::string result = "";
//    if(intResult == 0){
//        result = "yes"; // means yes file is there!
//        return env->NewStringUTF(result.c_str());
//    }else{
//        //result = 0;
//        result = "";
//    }
//
//    std::stringstream  stm;
//    stm << result.c_str();
//    stm <<intResult;
//
//    std::string output;  //define output string
//    output = stm.str();
//
//    return env->NewStringUTF(output.c_str());

}


// is writable folders from 28 to 41
#include <fcntl.h>

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI28(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI29(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/system/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI30(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/system/bin/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI31(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/system/sbin/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI32(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/system/xbin/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI33(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/vendor/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI34(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/sys/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI35(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/sbin/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI36(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/etc/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI37(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/proc/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI38(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/dev/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI39(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/init/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI40(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/lib/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}


extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI41(
        JNIEnv *env,
        jobject /* this */) {


    int fd;
    mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

    char *filename = "/acct/xfile";

    fd = open(filename, O_WRONLY | O_CREAT | O_TRUNC,
              S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH) ; // creat(filename, mode);

    std::string result = "";
    if(fd == -1){
        result = "";
    }else{
        result = "yes"; // means yes file is there!
        return env->NewStringUTF(result.c_str());//result = 0;

    }

    std::stringstream  stm;
    stm << result.c_str();
    stm <<fd;

    std::string output;  //define output string
    output = stm.str();

    return env->NewStringUTF(output.c_str());

}
////
// check busybox df is running or not
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI42(
        JNIEnv *env,
        jobject /* this */) {
    //  std::string hello = "Hello from C++";

    // which is a command of busybox  return either null or location of su
//
    std::string result = "";

    // FILE* pipe = popen("su -c ls /data", "r");
    FILE* pipe = popen("busybox df", "r");

    //if (!pipe) return NULL;
    char buffer[128];
    std::string resultCmd = "";
    while(!feof(pipe)) {
        if(fgets(buffer, 128, pipe) != NULL)
            resultCmd += buffer;
    }
    pclose(pipe);
    return env->NewStringUTF(resultCmd.c_str());

    const char *cstr = resultCmd.c_str();
    //int result = -1;

    if(cstr == NULL || (strlen(cstr) == 0)){
        result = "";
        return env->NewStringUTF(resultCmd.c_str());
        //ANDROID_LOGV( "Result of Which command is Null");
    }else{
        //result = 0;
        result = "yes"; //resultCmd;
        //ANDROID_LOGV( "Result of Which command %s\n", cstr);
    }

    return env->NewStringUTF(result.c_str());

}



// Towelroot native code CVE-2015-3153 check if the system is vulnerable to it or not

#define FUTEX_CMP_REQUEUE_PI    12
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI45(
        JNIEnv *env,
        jobject /* this */) {

    //  errno = 0;
    int errCode =  syscall( __NR_futex, 0xc0008000, FUTEX_CMP_REQUEUE_PI, 1, NULL, 0xc0008000, 0 );
    std::string resultcode = "";
    switch(errCode)
    {
        case 22:
            //printf( "looks like kernel is fixed\n" );
            resultcode = "Fixed";
            break;
        case 14:
            resultcode = "NotFixed";
            //printf( "looks like kernel is NOT fixed\n" );
            break;
        default:
            //printf( "Oops, the test doesn\'t work on this kernel\nerrno: %d \"%s\"\n", errno, strerror( errno ) );
            resultcode = "notworking";
            break;
    }

    return env->NewStringUTF(resultcode.c_str());

}

// pingpong CVE-2015-3636 ****************************************

/*
#include <unistd.h>
#include <sys/socket.h>
#include <errno.h>
#include <linux/netlink.h>
#include <linux/if.h>
#include <linux/filter.h>
#include <linux/if_pppox.h>

#include <linux/inet_diag.h>
#include <linux/unix_diag.h>
#include <string.h>
*/

#include <sys/socket.h>
//#include <linux/sock_diag.h>

#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include <iostream>
#include <netinet/in.h>
#include <sys/mman.h>
#include <linux/netfilter.h>


#define MMAP_BASE 0x200000
#define LIST_POISON 0x200200
#define MMAP_SIZE 0x200000

/*
int checkIsVulnerable()
{
    void * magic = mmap((void *) MMAP_BASE, MMAP_SIZE,
                        PROT_READ | PROT_WRITE, MAP_SHARED | MAP_FIXED | MAP_ANONYMOUS,
                        -1, 0);
    memset(magic, 0, MMAP_SIZE);
    *((long *)(LIST_POISON)) = 0xfefefefe;
    int sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_ICMP);
    struct sockaddr_in sa;
    memset(&sa, 0, sizeof(sa));
    sa.sin_family = AF_INET;
    connect(sock, (const struct sockaddr *) &sa, sizeof(sa));
    sa.sin_family = AF_UNSPEC;
    connect(sock, (const struct sockaddr *) &sa, sizeof(sa));
    close(sock);
    if (*((long *)(LIST_POISON)) != 0xfefefefe){
        //printf("Device is vulnerable\n");
        return 1;
    }else{
        // printf("Device is not vulnerable\n");
        return 0;
    }
}
*/
//

extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI46(
        JNIEnv *env,
        jobject /* this */) {

    //  errno = 0;

    void * magic = mmap((void *) MMAP_BASE, MMAP_SIZE,
                        PROT_READ | PROT_WRITE, MAP_SHARED | MAP_FIXED | MAP_ANONYMOUS,
                        -1, 0);
    memset(magic, 0, MMAP_SIZE);
    *((long *)(LIST_POISON)) = 0xfefefefe;
    int sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_ICMP);
    struct sockaddr_in sa;
    memset(&sa, 0, sizeof(sa));
    sa.sin_family = AF_INET;
    connect(sock, (const struct sockaddr *) &sa, sizeof(sa));
    sa.sin_family = AF_UNSPEC;
    connect(sock, (const struct sockaddr *) &sa, sizeof(sa));
    close(sock);

    int returncode;
    // returncode =  checkIsVulnerable();
    if (*((long *)(LIST_POISON)) != 0xfefefefe){
        //printf("Device is vulnerable\n");
        returncode = 1;
    }else{
        // printf("Device is not vulnerable\n");
        returncode = 0;
    }

    std::string resultcode = "";
    switch(returncode)
    {
        case 0:
            //printf( "looks like kernel is fixed\n" );
            resultcode = "Fixed";
            break;
        case 1:
            resultcode = "NotFixed";
            //printf( "looks like kernel is NOT fixed\n" );
            break;
        default:
            //printf( "Oops, the test doesn\'t work on this kernel\nerrno: %d \"%s\"\n", errno, strerror( errno ) );
            resultcode = "notworking";
            break;
    }

    return env->NewStringUTF(resultcode.c_str());

}

// CVE-2012-0056 ---This vulnerability is caused by the unauthorized access to /proc/pid/mem
#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>

#include "asroot.h"

#define BIN "wunderbar"
#define BIN_PATH "/data/data/com.tikzon.rootdetector/files/" BIN

int checkIsVulnerable()
{
    FILE *fp;
    int result;
    int i, pid, ret, status = -1;

    umask(007);

    fp = fopen(BIN_PATH, "wb");
    if (!fp) {
        // patched|failed to open file
        result = 0;
        goto done;
    }
    for (i = 0; i < sizeof(asroot) / sizeof(uint32_t); ++i) {
        fwrite(&asroot[i], sizeof(uint32_t), 1, fp);
    }
    fclose(fp);

    ret = chmod(BIN_PATH, 0750);
    if (ret == -1) {
        // patched|failed to chmod file
        result = 0;
        goto unlink;
    }

    pid = fork();
    if (pid == -1) {
        // patched|failed to fork
        result = 0;
        goto unlink;
    }

    if (pid == 0) {
        ret = execl(BIN_PATH, BIN, NULL);
        if (ret == -1) {
            // patched|failed to exec
            result = 0;
            goto kill;
        }
        exit(1);
    }

    sleep(1);

    ret = waitpid(pid, &status, WNOHANG);
    if (ret == -1) {
        // patched|failed to waitpid
        result = 0;
        goto kill;
    }

    if (WIFEXITED(status)) {
        // patched|bin exited normally
        result = 0;
        goto kill;
    }

    if (WIFSIGNALED(status)) {
        // patched|bin was killed
        result = 0;
        goto kill;
    }

    // vulnerable|bin wasn't terminated
    result = 1;

    kill:
    kill(pid, SIGKILL);

    unlink:
    unlink(BIN_PATH);

    done:
    return result;
}

// not used
extern "C"
jstring
Java_com_tikzon_rootdetector_MainActivity_stringFromJNI142(
        JNIEnv *env,
        jobject /* this */) {


    int returncode = checkIsVulnerable();
    // returncode =  checkIsVulnerable();

    std::string resultcode = "";
    switch(returncode)
    {
        case 0:
            //printf( "looks like kernel is fixed\n" );
            resultcode = "Fixed";
            break;
        case 1:
            resultcode = "NotFixed";
            //printf( "looks like kernel is NOT fixed\n" );
            break;
        default:
            //printf( "Oops, the test doesn\'t work on this kernel\nerrno: %d \"%s\"\n", errno, strerror( errno ) );
            resultcode = "notworking";
            break;
    }

    return env->NewStringUTF(resultcode.c_str());

}



