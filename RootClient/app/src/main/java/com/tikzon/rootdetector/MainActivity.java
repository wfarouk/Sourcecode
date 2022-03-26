package com.tikzon.rootdetector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private static final String TAG = "ROOTECTOR";
    private DeviceInfo devInfo;

    TextView idView;
    TextView displayResult;
    TextView displayNativeResult;
    Boolean orgLabel;

    boolean f1 = false;
    boolean f2 = false;
    boolean f3 = false;
    boolean f4 = false;
    boolean f5 = false;
    boolean f6 = false;
    boolean f7 = false;
    boolean f8 = false;
    boolean f9 = false;
    boolean f10 = false;
    boolean f11 = false;
    boolean f12 = false;
    boolean f13 = false;
    boolean f14 = false;
    boolean f15 = false;
    boolean f16 = false;
    boolean f17 = false;
    boolean f18 = false;
    boolean f19 = false;
    boolean f20 = false;
    boolean f21 = false;
    boolean f22 = false;
    boolean f23 = false;
    boolean f24 = false;
    boolean f25 = false;
    boolean f26 = false;
    boolean f27 = false;
    boolean f28 = false;
    boolean f29 = false;
    boolean f30 = false;
    boolean f31 = false;
    boolean f32 = false;
    boolean f33 = false;
    boolean f34 = false;
    boolean f35 = false;
    boolean f36 = false;
    boolean f37 = false;
    boolean f38 = false;
    boolean f39 = false;
    boolean f40 = false;
    boolean f41 = false;
    boolean f42 = false;
    boolean f43 = false;
    boolean f44 = false;
    boolean f45 = false;
    boolean f46 = false;
    boolean f47 = false;
    boolean f48 = false;

    boolean fn1 = false;
    boolean fn2 = false;
    boolean fn3 = false;
    boolean fn4 = false;
    boolean fn5 = false;
    boolean fn6 = false;
    boolean fn7 = false;
    boolean fn8 = false;
    boolean fn9 = false;
    boolean fn10 = false;
    boolean fn11 = false;
    boolean fn12 = false;
    boolean fn13 = false;
    boolean fn14 = false;
    boolean fn15 = false;
    boolean fn16 = false;
    boolean fn17 = false;
    boolean fn18 = false;
    boolean fn19 = false;
    boolean fn20 = false;
    boolean fn21 = false;
    boolean fn22 = false;
    boolean fn23 = false;
    boolean fn24 = false;
    boolean fn25 = false;
    boolean fn26 = false;
    boolean fn27 = false;
    boolean fn28 = false;
    boolean fn29 = false;
    boolean fn30 = false;
    boolean fn31 = false;
    boolean fn32 = false;
    boolean fn33 = false;
    boolean fn34 = false;
    boolean fn35 = false;
    boolean fn36 = false;
    boolean fn37 = false;
    boolean fn38 = false;
    boolean fn39 = false;
    boolean fn40 = false;
    boolean fn41 = false;
    boolean fn42 = false;
    boolean fn43 = false;
    boolean fn44 = false;
    boolean fn45 = false;
    boolean fn46 = false;
    boolean fn47 = false;
    boolean fn48 = false;
    String appsList;

    String BuildFingerPrint = null;
    String BuildID = null;
    String KernelVersion = null;
    String BuildBrand = null;
    String BuildManuf = null;
    String BuildModel = null;
    String BuildRelease = null;
    String BuildSDK = null;
    String BuildABIList =null;
    String imeistring = null;
    String imsistring = null;
    String serialnum = null;
    String serialnum2 = null;
    String androidId = null;
    String curModel = null;
    String curProduct = null;
    String  curMan= null;
    String curBrand = null;
    String curDevice = null;
    String curVer = null;

    HashMap<String, String> deviceInfo = new HashMap<String, String>();
    HashMap<String, String> params = new HashMap<String, String>();

    TextView welcometextViewEn;
    TextView welcometextViewAr;
    TextView displayResultTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        idView = (TextView) findViewById(R.id.TextView10);



        welcometextViewEn = (TextView) findViewById(R.id.welcometextViewEn);
        welcometextViewAr = (TextView) findViewById(R.id.welcometextViewAr);

        displayResultTextview = (TextView) findViewById(R.id.resultTextView);


        displayResult = (TextView) findViewById(R.id.TextView11);
        displayNativeResult = (TextView) findViewById(R.id.TextView12);
        final Button button0 = (Button) findViewById(R.id.yesRootedButton);
        final Button button00 = (Button) findViewById(R.id.notRootedButton);
        serialnum2 = null;
        androidId = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        idView.append("AndroidID : " + androidId + "\n");

        int intBuildSDK = Build.VERSION.SDK_INT;
        //idView.append("BuildSDK : " + intBuildSDK + "\n");
        BuildSDK = String.valueOf(intBuildSDK);
        curModel = Build.MODEL;
        idView.append("Model : " + curModel + "\n");
        // The name of the overall product.
        curProduct = Build.PRODUCT;
        idView.append("Product : " + curProduct + "\n");
        // The manufacturer of the product/hardware.
        curMan = Build.MANUFACTURER;
        idView.append("Manufacturer : " + curMan + "\n");
        // The brand (e.g., carrier) the software is customized for, if
        // any.
        curBrand = Build.BRAND;
        idView.append("Brand : " + curBrand + "\n");
        // The name of the industrial design.
        curDevice = Build.DEVICE;
        idView.append("Device : " + curDevice + "\n");
        curVer = Build.VERSION.RELEASE;



        f1 = RootCheckTools.SUid0();
        f2 = RootCheckTools.TestKeysCheck();
        f3 = RootCheckTools.ReadableDataFolder();
        f4 = RootCheckTools.isOTAZIP();

        // group2 from fn5 to f13
        String Alltext = RootCheckTools.getInstalledPackages();
        f5 = Alltext.contains("superuser");
        f6 = Alltext.contains("temproot");
        f7 = Alltext.contains("kingouser");
        f8 = Alltext.contains("supersu");
        f9 = Alltext.contains("com.noshufou.android.su");
        f10 = Alltext.contains("com.thirdparty.superuser");
        f11 = Alltext.contains("eu.chainfire.supersu");
        f12 = Alltext.contains("com.zachspong.temprootremovejb");
        f13 = Alltext.contains("com.ramdroid.appquarantine ");


        
        // f14
//        Application app = com.android.internal.util.Predicate;
        Context cont1 = this;
        try {
        cont1 = createPackageContext("com.android.settings", CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String listOfActivities = RootCheckTools.getAllActivities(cont1);
        //idView.append("activities : " + listOfActivities + "\n");

        f14 = listOfActivities.contains("cyanogenmod.superuser");

        //  group 3 from 15 to 25
        f15 = new File("/bin/su").exists();
        f16 = new File("/system/bin/su").exists();
        f17 = new File("/system/xbin/su").exists();
        f18 = new File("/sbin/su").exists();
        f19 = new File("/system/su").exists();
        f20 = new File("/system/bin/ext/su").exists();
        f21 = new File("/system/usr/we-need-root/su-backup/su").exists();
        f22 = new File("/system/xbin/mu/su").exists();
        f23 = new File("/system/sd/xbin").exists();
        f24 = new File("/system/bin/failsafe/su").exists();
        f25 = new File("/data/local/su").exists();

        // is data folder readable
        //f26 = RootCheckTools.ReadableFolder("/data").contains("system");
        f26 = !RootCheckTools.ReadableFolder("/data").equals("error");
        f27 = !RootCheckTools.ReadableFolder("/config").equals("error");

        // group 4 from 28 - 41

        f28 = !RootCheckTools.runCommand1("/foldername").contains("error");

        //f28 = new File("/").canWrite();
//        File folder =  new File ("/" + "theFolder");
//        if (folder.exists())
//            f28 = true;
        f29 = !RootCheckTools.runCommand1("/system/foldername").contains("error");
        f30 = !RootCheckTools.runCommand1("/system/bin/foldername").contains("error");
        f31 = !RootCheckTools.runCommand1("/system/sbin/foldername").contains("error");
        f32 = !RootCheckTools.runCommand1("/system/xbin/foldername").contains("error");
        f33 = !RootCheckTools.runCommand1("/vendor/foldername").contains("error");
        f34 = !RootCheckTools.runCommand1("/sys/foldername").contains("error");
        f35 = !RootCheckTools.runCommand1("/sbin/foldername").contains("error");
        f36 = !RootCheckTools.runCommand1("/etc/foldername").contains("error");
        f37 = !RootCheckTools.runCommand1("/proc/foldername").contains("error");
        f38 = !RootCheckTools.runCommand1("/dev/foldername").contains("error");
        f39 = !RootCheckTools.runCommand1("/init/foldername").contains("error");
        f40 = !RootCheckTools.runCommand1("/lib/foldername").contains("error");
        f41 = !RootCheckTools.runCommand1("/acct/foldername").contains("error");

        f42 = RootCheckTools.RunBusyBox();

        f43 = Alltext.contains("rootcloak");
        f44 = RootCheckTools.openPort(8888); // to be devloped

//        f29 = new File("/system").canWrite();
//        f30 = new File("/system/bin").canWrite();
//        f31 = new File("/system/sbin").canWrite();
//        f32 = new File("/system/xbin").canWrite();
//        f33 = new File("/vendor").canWrite();
//        f34 = new File("/sys").canWrite();
//        f35 = new File("/sbin").canWrite();
//        f36 = new File("/etc").canWrite();
//        f37 = new File("/proc").canWrite();
//        f38 = new File("/dev").canWrite();
//        f39 = new File("/init").canWrite();
//        f40 = new File("/lib").canWrite();
//        f41 = new File("/acct").canWrite();
        

        displayResult.append("f1 : " + f1 + "\n");
        displayResult.append("f2 : " + f2 + "\n");
        displayResult.append("f3 : " + f3 + "\n");
        displayResult.append("f4 : " + f4 + "\n");
        displayResult.append("f5 : " + f5 + "\n");
        displayResult.append("f6 : " + f6 + "\n");
        displayResult.append("f7: " + f7 + "\n");
        displayResult.append("f8 : " + f8 + "\n");
        displayResult.append("f9 : " + f9 + "\n");
        displayResult.append("f10 : " + f10 + "\n");
        displayResult.append("f11: " + f11 + "\n");
        displayResult.append("f12: " + f12 + "\n");
        displayResult.append("f13: " + f13 + "\n");
        displayResult.append("f14: " + f14 + "\n");
        displayResult.append("f15: " + f15 + "\n");
        displayResult.append("f16: " + f16 + "\n");
        displayResult.append("f17: " + f17 + "\n");
        displayResult.append("f18: " + f18 + "\n");
        displayResult.append("f19: " + f19 + "\n");
        displayResult.append("f20: " + f20 + "\n");
        displayResult.append("f21: " + f21 + "\n");
        displayResult.append("f22: " + f22 + "\n");
        displayResult.append("f23: " + f23 + "\n");
        displayResult.append("f24: " + f24 + "\n");
        displayResult.append("f25: " + f25 + "\n");
        displayResult.append("f26: " + f26 + "\n");

        //27
        displayResult.append("f27 : " + f27 + "\n");
        displayResult.append("f28 : " + f28 + "\n");
        displayResult.append("f29 : " + f29 + "\n");
        displayResult.append("f30 : " + f30 + "\n");
        displayResult.append("f31 : " + f31 + "\n");
        displayResult.append("f32 : " + f32 + "\n");
        displayResult.append("f33 : " + f33 + "\n");
        displayResult.append("f34 : " + f34 + "\n");
        displayResult.append("f35 : " + f35 + "\n");
        displayResult.append("f36 : " + f36 + "\n");
        displayResult.append("f37 : " + f37 + "\n");
        displayResult.append("f38 : " + f38 + "\n");
        displayResult.append("f39 : " + f39 + "\n");
        displayResult.append("f40 : " + f40 + "\n");
        displayResult.append("f41 : " + f41 + "\n");

        displayResult.append("f42 : " + f42 + "\n");
        displayResult.append("f43 : " + f43 + "\n");
        displayResult.append("f44 : " + f43 + "\n");

        fn1 = stringFromJNI().contains("uid=0");
        fn2 = stringFromJNI2().equals("yes");
        fn3 = stringFromJNI3().equals("yes");
        fn4 = stringFromJNI4().equals("yes");

        // group 2
        String listOfAppNative = stringFromJNI5();
        fn5 = listOfAppNative.contains("superuser");
        fn6 = listOfAppNative.contains("temproot");
        fn7 = listOfAppNative.contains("kingouser");
        fn8 = listOfAppNative.contains("supersu");
        fn9 = listOfAppNative.contains("com.noshufou.android.su");
        fn10 = listOfAppNative.contains("com.thirdparty.superuser");
        fn11 = listOfAppNative.contains("eu.chainfire.supersu");
        fn12 = listOfAppNative.contains("com.zachspong.temprootremovejb");
        fn13 = listOfAppNative.contains("com.ramdroid.appquarantine ");

        //group 3
        fn15 = stringFromJNISU15().equals("yes");
        fn16 = stringFromJNISU16().equals("yes");
        fn17 = stringFromJNISU17().equals("yes");
        fn18 = stringFromJNISU18().equals("yes");
        fn19 = stringFromJNISU19().equals("yes");
        fn20 = stringFromJNISU20().equals("yes");
        fn21 = stringFromJNISU21().equals("yes");
        fn22 = stringFromJNISU22().equals("yes");
        fn23 = stringFromJNISU23().equals("yes");
        fn24 = stringFromJNISU24().equals("yes");
        fn25 = stringFromJNISU25().equals("yes");


        // to be developed
        fn26 = false ;

        // id data folder readable

        fn27 = stringFromJNI27().equals("yes");

        // group 4
        // String.valueOf(

        fn28 = stringFromJNI28().equals("yes");

        fn29 = stringFromJNI29().equals("yes");
        fn30 = stringFromJNI30().equals("yes");
        fn31 = stringFromJNI31().equals("yes");
        fn32 = stringFromJNI32().equals("yes");
        fn33 = stringFromJNI33().equals("yes");
        fn34 = stringFromJNI34().equals("yes");
        fn35 = stringFromJNI35().equals("yes");
        fn36 = stringFromJNI36().equals("yes");
        fn37 = stringFromJNI37().equals("yes");
        fn38 = stringFromJNI38().equals("yes");
        fn39 = stringFromJNI39().equals("yes");
        fn40 = stringFromJNI40().equals("yes");
        fn41 = stringFromJNI41().equals("yes");


        // 42 busybox df

        fn42 = stringFromJNI42().contains("system");

        //43  - evasions app installed
        
        fn43 = listOfAppNative.contains("rootcloak");

        //44 is openserver port 81

        fn44 = RootCheckTools.openPort(81); // to be devloped

        //45 TowelRoot Exploit fixed - notfixed or check not working.

        fn45 = stringFromJNI45().equals("NotFixed");

        // 46 pingpong Exploit fixed - notfixed or check not working.

        if (intBuildSDK>15) fn46 = stringFromJNI46().equals("NotFixed");

        final Button initialResultbutton = (Button) findViewById(R.id.intialResultButton);
        if (f1 || f3 || f7 || f28 ) {
            displayResultTextview.setText("THIS DEVICE IS ROOTED");

            initialResultbutton.setBackgroundResource(R.drawable.checkmark);
                  orgLabel = true;

            }

            else { displayResultTextview.setText("NOT ROOTED");
            //displayResultTextview.setTextColor("#CC0000"));
            orgLabel = false;
            initialResultbutton.setBackgroundResource(R.drawable.xmark);
        }

        // display Native results

        displayNativeResult.append("fn1 : " + fn1 + "\n");

        displayNativeResult.append("fn2 : " + fn2 + "\n");
        displayNativeResult.append("fn3 : " + fn3 + "\n");
        displayNativeResult.append("fn4 : " + fn4 + "\n");
        displayNativeResult.append("fn5 : " + fn5 + "\n");
        displayNativeResult.append("fn6 : " + fn6 + "\n");
        displayNativeResult.append("fn7: " + fn7 + "\n");
        displayNativeResult.append("fn8 : " + fn8 + "\n");
        displayNativeResult.append("fn9 : " + fn9 + "\n");
        displayNativeResult.append("fn10 : " + fn10 + "\n");
        displayNativeResult.append("fn11: " + fn11 + "\n");
        displayNativeResult.append("fn12: " + fn12 + "\n");
        displayNativeResult.append("fn13: " + fn13 + "\n");
        displayNativeResult.append("fn14: " + fn14 + "\n");
        displayNativeResult.append("fn15: " + fn15 + "\n");
        displayNativeResult.append("fn16: " + fn16+ "\n");
        displayNativeResult.append("fn17: " + fn17+ "\n");
        displayNativeResult.append("fn18: " + fn18 + "\n");
        displayNativeResult.append("fn19: " + fn19 + "\n");
        displayNativeResult.append("fn20: " + fn20 + "\n");
        displayNativeResult.append("fn21: " + fn21 + "\n");
        displayNativeResult.append("fn22: " + fn22 + "\n");
        displayNativeResult.append("fn23: " + fn23 + "\n");
        displayNativeResult.append("fn24: " + fn24 + "\n");
        displayNativeResult.append("fn25: " + fn25 + "\n");
        displayNativeResult.append("fn26: " + fn26 + "\n");

        //27
        displayNativeResult.append("fn27 : " + fn27 + "\n");
        displayNativeResult.append("fn28 : " + fn28 + "\n");
        displayNativeResult.append("fn29 : " + fn29 + "\n");
        displayNativeResult.append("fn30 : " + fn30 + "\n");
        displayNativeResult.append("fn31 : " + fn31 + "\n");
        displayNativeResult.append("fn32 : " + fn32 + "\n");
        displayNativeResult.append("fn33 : " + fn33 + "\n");
        displayNativeResult.append("fn34 : " + fn34 + "\n");
        displayNativeResult.append("fn35 : " + fn35 + "\n");
        displayNativeResult.append("fn36 : " + fn36 + "\n");
        displayNativeResult.append("fn37 : " + fn37 + "\n");
        displayNativeResult.append("fn38 : " + fn38 + "\n");
        displayNativeResult.append("fn39 : " + fn39 + "\n");
        displayNativeResult.append("fn40 : " + fn40 + "\n");
        displayNativeResult.append("fn41 : " + fn41 + "\n");

        displayNativeResult.append("fn42 : " + fn42 + "\n");
        displayNativeResult.append("fn43 : " + fn43 + "\n");
        displayNativeResult.append("fn44 : " + fn43 + "\n");


        displayNativeResult.append("fn45 : " + fn45 + "\n");
        displayNativeResult.append("fn46 : " + fn46 + "\n");


        final String url3 = "http://www.tikzon.com/root/updateorglabel.php";
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> userLabel = new HashMap<String, String>();

                userLabel.put( "deviceID", androidId ) ;
                userLabel.put( "orgLabel", "true" ) ;


                HttpUtility.newRequest(url3, HttpUtility.METHOD_POST, userLabel, new HttpUtility.Callback() {
                    @Override
                    public void OnSuccess(String response) {
                        Log.e("async", "HTTP POST Successful: Yes Rooted orgLabel ");
                    }

                    @Override
                    public void OnError(int status_code, String message) {
                        Log.d("async", "in AsyncTask; Error: Yes Rooted orgLabel ");
                    }
                });

                RootCheckTools.thankYouMessage(MainActivity.this);
            }

        });
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> userLabel1 = new HashMap<String, String>();
                userLabel1.put( "deviceID", androidId ) ;
                userLabel1.put( "orgLabel", "false" ) ;

                HttpUtility.newRequest(url3, HttpUtility.METHOD_POST, userLabel1, new HttpUtility.Callback() {
                    @Override
                    public void OnSuccess(String response) {
                        Log.e("async", "HTTP POST Successful: Not Rooted orgLabel ");
                    }

                    @Override
                    public void OnError(int status_code, String message) {
                        Log.d("async", "in AsyncTask; Error: Not Rooted orgLabel ");
                    }
                });

                RootCheckTools.thankYouMessage(MainActivity.this);
            }

        });
                //String url1 = "http://192.168.1.178:8080/rootector/devices.jsp";
                String url1 = "http://www.tikzon.com/root/devices.php";
                String url2 = "http://www.tikzon.com/root/features.php";

                // String url2 = "http://192.168.1.178:8080/rootector/features.jsp";

                //try {


                deviceInfo.put("projectprojectID", "10");
                deviceInfo.put("useruserID", "10");
                deviceInfo.put("BuildFingerPrint", BuildFingerPrint);
                deviceInfo.put("BuildID", BuildID);
                deviceInfo.put("KernelVersion", KernelVersion);
                deviceInfo.put("BuildBrand", BuildBrand);
                deviceInfo.put("BuildManuf", BuildManuf);
                deviceInfo.put("BuildModel", BuildModel);
                deviceInfo.put("BuildRelease", BuildRelease);
                deviceInfo.put("BuildSDK", BuildSDK);
                deviceInfo.put("BuildABIList", BuildABIList);
                deviceInfo.put("imeistring", imeistring);
                deviceInfo.put("imsistring", imsistring);
                deviceInfo.put("serialnum", serialnum);
                deviceInfo.put("serialnum2", serialnum2);
                deviceInfo.put("curModel", curModel);
                deviceInfo.put("curProduct", curProduct);
                deviceInfo.put("curMan", curMan);
                deviceInfo.put("curBrand", curBrand);
                deviceInfo.put("curDevice", curDevice);
                deviceInfo.put("curVer", curVer);
                deviceInfo.put("androidId", androidId);


                //   new GetData_AsyncTask(getBaseContext(), params).execute();  // working perfectly

                HttpUtility.newRequest(url1, HttpUtility.METHOD_POST, deviceInfo, new HttpUtility.Callback() {
                    @Override
                    public void OnSuccess(String response) {
                        Log.e("async", "HTTP POST Successful: deviceinfo ");
                    }

                    @Override
                    public void OnError(int status_code, String message) {
                        Log.d("async", "in AsyncTask; Error: deviceinfo ");
                    }
                });


                params.put("deviceID", androidId);
                params.put("projectprojectID", "10");
                params.put("useruserID", "10");
                params.put("f1", String.valueOf(f1));
                params.put("f2", String.valueOf(f2));
                params.put("f3", String.valueOf(f3));
                params.put("f4", String.valueOf(f4));
                params.put("f5", String.valueOf(f5));
                params.put("f6", String.valueOf(f6));
                params.put("f7: ", String.valueOf(f7));
                params.put("f8", String.valueOf(f8));
                params.put("f9", String.valueOf(f9));
                params.put("f10", String.valueOf(f10));
                params.put("f11: ", String.valueOf(f11));
                params.put("f12: ", String.valueOf(f12));
                params.put("f13: ", String.valueOf(f13));
                params.put("f14: ", String.valueOf(f14));
                params.put("f15: ", String.valueOf(f15));
                params.put("f16: ", String.valueOf(f16));
                params.put("f17: ", String.valueOf(f17));
                params.put("f18: ", String.valueOf(f18));
                params.put("f19: ", String.valueOf(f19));
                params.put("f20: ", String.valueOf(f20));
                params.put("f21: ", String.valueOf(f21));
                params.put("f22: ", String.valueOf(f22));
                params.put("f23: ", String.valueOf(f23));
                params.put("f24: ", String.valueOf(f24));
                params.put("f25: ", String.valueOf(f25));
                params.put("f26: ", String.valueOf(f26));

                //27
                params.put("f27", String.valueOf(f27));
                params.put("f28", String.valueOf(f28));
                params.put("f29", String.valueOf(f29));
                params.put("f30", String.valueOf(f30));
                params.put("f31", String.valueOf(f31));
                params.put("f32", String.valueOf(f32));
                params.put("f33", String.valueOf(f33));
                params.put("f34", String.valueOf(f34));
                params.put("f35", String.valueOf(f35));
                params.put("f36", String.valueOf(f36));
                params.put("f37", String.valueOf(f37));
                params.put("f38", String.valueOf(f38));
                params.put("f39", String.valueOf(f39));
                params.put("f40", String.valueOf(f40));
                params.put("f41", String.valueOf(f41));

                params.put("f42", String.valueOf(f42));
                params.put("f43", String.valueOf(f43));
                params.put("f44", String.valueOf(f44));

                // display Native results
                params.put("fn1", String.valueOf(fn1));
                params.put("fn2", String.valueOf(fn2));
                params.put("fn3", String.valueOf(fn3));
                params.put("fn4", String.valueOf(fn4));
                params.put("fn5", String.valueOf(fn5));
                params.put("fn6", String.valueOf(fn6));
                params.put("fn7", String.valueOf(fn7));
                params.put("fn8", String.valueOf(fn8));
                params.put("fn9", String.valueOf(fn9));
                params.put("fn10", String.valueOf(fn10));
                params.put("fn11", String.valueOf(fn11));
                params.put("fn12", String.valueOf(fn12));
                params.put("fn13", String.valueOf(fn13));
                params.put("fn14", String.valueOf(fn14));
                params.put("fn15", String.valueOf(fn15));
                params.put("fn16", String.valueOf(fn16));
                params.put("fn17", String.valueOf(fn17));
                params.put("fn18", String.valueOf(fn18));
                params.put("fn19", String.valueOf(fn19));
                params.put("fn20", String.valueOf(fn20));
                params.put("fn21", String.valueOf(fn21));
                params.put("fn22", String.valueOf(fn22));
                params.put("fn23", String.valueOf(fn23));
                params.put("fn24", String.valueOf(fn24));
                params.put("fn25", String.valueOf(fn25));
                params.put("fn26", String.valueOf(fn26));

                //27
                params.put("fn27", String.valueOf(fn27));
                params.put("fn28", String.valueOf(fn28));
                params.put("fn29", String.valueOf(fn29));
                params.put("fn30", String.valueOf(fn30));
                params.put("fn31", String.valueOf(fn31));
                params.put("fn32", String.valueOf(fn32));
                params.put("fn33", String.valueOf(fn33));
                params.put("fn34", String.valueOf(fn34));
                params.put("fn35", String.valueOf(fn35));
                params.put("fn36", String.valueOf(fn36));
                params.put("fn37", String.valueOf(fn37));
                params.put("fn38", String.valueOf(fn38));
                params.put("fn39", String.valueOf(fn39));
                params.put("fn40", String.valueOf(fn40));
                params.put("fn41", String.valueOf(fn41));

                params.put("fn42", String.valueOf(fn42));
                params.put("fn43", String.valueOf(fn43));
                params.put("fn44", String.valueOf(fn43));


                params.put("fn45", String.valueOf(fn45));
                params.put("fn46", String.valueOf(fn46));

                params.put("orgLabel", String.valueOf(orgLabel));
                params.put("appsList", Alltext );

                //String label = request.getParameter("label");


                HttpUtility.newRequest(url2, HttpUtility.METHOD_POST, params, new HttpUtility.Callback() {
                    @Override
                    public void OnSuccess(String response) {
                        Log.e("async", "HTTP POST Successful: features ");
                    }

                    @Override
                    public void OnError(int status_code, String message) {
                        Log.d("async", "in AsyncTask; Error: features ");
                    }
                });



    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */


    public native String stringFromJNI();
    public native String stringFromJNI2();
    public native String stringFromJNI3();
    public native String stringFromJNI3a();
    public native String stringFromJNI3b();
    public native String stringFromJNI4();
    // get list of packages
    public native String stringFromJNI5();

//    public native String stringFromJNI11();
    //  public native String stringFromJNI12();
    //public native String stringFromJNI13();
    //public native String stringFromJNI14();

    public native String stringFromJNISU15();
    public native String stringFromJNISU16();
    public native String stringFromJNISU17();
    public native String stringFromJNISU18();
    public native String stringFromJNISU19();
    public native String stringFromJNISU20();
    public native String stringFromJNISU21();
    public native String stringFromJNISU22();
    public native String stringFromJNISU23();
    public native String stringFromJNISU24();
    public native String stringFromJNISU25();


    public native String stringFromJNI26();  // data
    public native String stringFromJNI27(); //config


    //public native String stringFromJNI16();

    public native String stringFromJNI28();
    public native String stringFromJNI29();
    public native String stringFromJNI30();
    public native String stringFromJNI31();
    public native String stringFromJNI32();
    public native String stringFromJNI33();
    public native String stringFromJNI34();
    public native String stringFromJNI35();
    public native String stringFromJNI36();
    public native String stringFromJNI37();
    public native String stringFromJNI38();
    public native String stringFromJNI39();
    public native String stringFromJNI40();
    public native String stringFromJNI41();

    public native String stringFromJNI42(); // busybox df


    public native String stringFromJNI45(); // Vul
    public native String stringFromJNI46(); // Vul


}
