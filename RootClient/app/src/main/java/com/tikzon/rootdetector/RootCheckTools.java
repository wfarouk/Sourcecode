package com.tikzon.rootdetector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.security.AccessController;

/**
 * Created by welsersy1 on 1/22/2017.
 */

public class RootCheckTools {

    // SU -c id
    public static boolean SUid0() {
        if (isRootAvailable()) {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(new String[]{"su", "-c", "id"});
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String output = in.readLine();

                if (output != null && output.toLowerCase().contains("uid=0"))
                  return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (process != null)
                    process.destroy();
            }
        }

        return false;
    }

    public  static String getAllActivities(Context context) {
        try {

            String Activities = "";
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if(pi.activities!=null)
            {
                ActivityInfo[] Activities_array = pi.activities;

                for (int i = 0; i < Activities_array.length; i++) {
                    int j=i+1;
                    Activities  = Activities + j + ") "+ pi.activities[i].name+ ", \n";
                }
            }

            if(Activities.equals(null))
                return "-";
            else
                return Activities;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

   public static  void thankYouMessage (Context con) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(con);
       builder1.setTitle("Thanks");
        builder1.setMessage("Thank you very much for you feedback :)");
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    public static boolean isRootAvailable() {
        for (String pathDir : System.getenv("PATH").split(":")) {
            if (new File(pathDir, "su").exists()) {
                return true;
            }
        }
        return false;
    }

    // 2 - Test-Keys

    public static boolean TestKeysCheck() {
        //TextView TextView11 = (TextView) findViewById(R.id.TextView11);
        //TextView11.setText("Custom image if test-keys exist is not realiable iwth emulator");

        // get from build info
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }

        return false;
    }

    // 3- is /data readable?

    public static boolean ReadableDataFolder() {

        String line;
        String Alltext = "";
        BufferedReader bufread = null;
        try {
            Process process;
            String command[] = {"su", "-c", "ls", "/data"};
            process = Runtime.getRuntime().exec(command);
            bufread = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader STDERR = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            try {
                while ((line = bufread.readLine()) != null) {
                    Alltext = Alltext + "\n" + line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //TextView TextView11 = (TextView) findViewById(R.id.TextView11);
        //TextView11.setText(Alltext);
        if ((Alltext.contains("system"))) {  // not found replace "system"
            return true;

        } else
            return false;


    }
   // 3 and 26 and 27- is /data readable? or config folder is readable

    public static String ReadableFolder(String foldername) {

        String line;
        String Alltext = "";
        BufferedReader bufread = null;
        try {
            Process process;
            String command[] = {"su", "-c", "ls", foldername};
            process = Runtime.getRuntime().exec(command);
            bufread = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader STDERR = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            try {
                while ((line = bufread.readLine()) != null) {
                    Alltext = Alltext + "\n" + line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
            Alltext = "error";
        }
        //TextView TextView11 = (TextView) findViewById(R.id.TextView11);
        //TextView11.setText(Alltext);
        return  Alltext.toLowerCase();


    }


    // 4- OTAzip Files exist means OS is leagal

    public static boolean isOTAZIP() {
        String[] paths = { "/etc/security/otacert.zip"};
        //TextView TextView11 = (TextView) findViewById(R.id.TextView11);
        //TextView11.setText(paths[0]+ "If file exist means not rooted");
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }



 // this run for feature 5- 13

    public static String getInstalledPackages (){

    String line;
    String Alltext = "";
    BufferedReader bufread = null;
    try {
        Process process;
        String command[] = {"pm", "list", "packages"};
        process = Runtime.getRuntime().exec(command);
        bufread = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader STDERR = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        try {
            while ((line = bufread.readLine()) != null) {
                Alltext = Alltext + "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return Alltext;

}

// used for makeing folder test

    public static String runCommand1 (String foldername) {
// String command[]
        String line;
        String Alltext = "";
        BufferedReader bufread = null;
        try {
            Process process;
            String command[] = {"su", "-c", "mkdir", foldername};
            process = Runtime.getRuntime().exec(command);

            bufread = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader STDERR = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            try {
                while ((line = bufread.readLine()) != null) {
                    Alltext = Alltext + "\n" + line;
                }
            } catch (IOException e) {
                e.printStackTrace();

            }

        } catch (IOException e) {
            e.printStackTrace();
            Alltext = "error";
        }

        //TextView TextView11 = (TextView) findViewById(R.id.TextView11);
        //TextView11.setText(Alltext);
        return  Alltext.toLowerCase();
    }


    public static String RunCommand (String CommandArray[]){

    String line;
    String Alltext = "";
    BufferedReader bufread = null;
    try {
        Process process;
        process = Runtime.getRuntime().exec(CommandArray);

        bufread = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader STDERR = new BufferedReader(new InputStreamReader(process.getErrorStream()));


        try {
            while ((line = bufread.readLine()) != null) {
                Alltext = Alltext + "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

      } catch (IOException e) {
        e.printStackTrace();
    }

    return Alltext;

}

    public static Boolean openPort (int portNo) {

        Boolean portOpenedResult = false;
        try {
            ServerSocket ss = new ServerSocket(portNo);
            portOpenedResult = true;
            ss.close();
        } catch (Exception e) {

        }
    return portOpenedResult;

    }
public static Boolean isAppInstalled(String appName){

    String Alltext = getInstalledPackages();
    if  (Alltext.contains(appName)) {
        return true;

    } else {
        return false;
    }


}
    public static Boolean isFolderReadable(String folderName, String isContains){
        String command[] = {"su", "-c", "ls", folderName};
    String Alltext = RunCommand(command);
    if  (Alltext.contains(isContains)) {
        return true;

    } else {

        return false;
    }


}

    public static Boolean cancreateFolder(String folderName){
        String command[] = {"su", "-c", "ls", folderName};
        String Alltext = RunCommand(command);
        if  (Alltext.contains(folderName)) {
            return true;

        } else {

            return false;
        }


    }

    public static Boolean RunBusyBox(){
        String command[] = {"busybox", "df"};
        String Alltext = RunCommand(command);

        if  (Alltext.contains("system")) {
            return true;

        } else {

            return false;
        }


    }

    public static Boolean CheckDirPermissions(String Dir) {

        String path = Dir ; //"/system/*";

        String actions = "write";

        try {
            AccessController.checkPermission(new FilePermission(path, actions));

            return true; //System.out.println("You have read/write permition to use : " + path);

        } catch (SecurityException e) {
            return false; //System.out.println("You have read/write permition to use : " + path);

        }

    }




//end of the class

}