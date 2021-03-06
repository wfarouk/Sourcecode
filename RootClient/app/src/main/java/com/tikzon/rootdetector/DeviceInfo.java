package com.tikzon.rootdetector;

import android.os.Build;

/**
 * Created by fuzion24 on 9/21/15.
 */
public class DeviceInfo {

    private final String kernelVersion;
    private final String buildManufacturer;
    private final String buildBrand;
    private final String buildModel;
    private final String buildRelease;
    private final String buildSDK;
    private final long   buildDateUTC;
    private final String buildFingerPrint;
    private final String buildCpuABI;
    private final String buildCpuABI2;
    private final String[] supported32BitABIS;
    private final String[] supported64BitABIS;
    private final String[] supportedABIS;


    private final String buildID;


    private DeviceInfo(String kVer,
                       String bManufacturer,
                       String bBrand,
                       String bModel,
                       String bRelease,
                       String bSDK,
                       long   bDateUTC,
                       String bFingerPrint,
                       String bID,
                       String bCPUABI,
                       String bCPUABI2,
                       String[] bCPU32List,
                       String[] bCPU64List,
                       String[] bABIS){
        this.kernelVersion = kVer;
        this.buildManufacturer = bManufacturer;
        this.buildBrand = bBrand;
        this.buildModel = bModel;
        this.buildRelease = bRelease;
        this.buildSDK = bSDK;
        this.buildDateUTC = bDateUTC;
        this.buildFingerPrint = bFingerPrint;
        this.buildID = bID;
        this.buildCpuABI  = bCPUABI;
        this.buildCpuABI2 = bCPUABI2;
        this.supported32BitABIS = bCPU32List;
        this.supported64BitABIS = bCPU64List;
        this.supportedABIS = bABIS;
    }

    public static DeviceInfo getDeviceInfo() {
        String kVer               = readKernelVersion();
        String bManufac           = Build.MANUFACTURER;
        String bBrand             = Build.BRAND;
        String bModel             = Build.MODEL;
        String bRelease           = Build.VERSION.RELEASE;
        String bSdk               = Build.VERSION.SDK;
        long   bDateUTC           = Build.TIME;
        String bFingerPrint       = Build.FINGERPRINT;
        String bID                = Build.ID;
        String bCPUABI            = Build.CPU_ABI;
        String bCPUABI2           = Build.CPU_ABI2;
        String[] bCPU32List       = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? Build.SUPPORTED_32_BIT_ABIS :  new String[]{};
        String[] bCPU64List       = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? Build.SUPPORTED_64_BIT_ABIS :  new String[]{};
        String[] bABIS            = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? Build.SUPPORTED_ABIS        :  new String[]{};

        return new DeviceInfo(kVer,
                bManufac,
                bBrand,
                bModel,
                bRelease,
                bSdk,
                bDateUTC,
                bFingerPrint,
                bID,
                bCPUABI,
                bCPUABI2,
                bCPU32List,
                bCPU64List,
                bABIS
                );
    }

    public static String readKernelVersion() {
        return System.getProperty("os.version");
    }

    public String getKernelVersion() {
        return kernelVersion;
    }

    public String getBuildManufacturer() {
        return buildManufacturer;
    }

    public String getBuildBrand() {
        return buildBrand;
    }

    public String getBuildModel() {
        return buildModel;
    }

    public String getBuildRelease() {
        return buildRelease;
    }

    public String getBuildSDK() {
        return buildSDK;
    }

    public String getBuildFingerPrint() {
        return buildFingerPrint;
    }

    public String getBuildID() {
        return buildID;
    }

    public String getBuildCpuABI() {
        return buildCpuABI;
    }

    public String getBuildCpuABI2() {
        return buildCpuABI2;
    }

    public String[] getSupported32BitABIS() {
        return supported32BitABIS;
    }

    public String[] getSupported64BitABIS() {
        return supported64BitABIS;
    }

    public String[] getSupportedABIS() {
        return supportedABIS;
    }

    public long getBuildDateUTC() {
        return buildDateUTC;
    }


}
