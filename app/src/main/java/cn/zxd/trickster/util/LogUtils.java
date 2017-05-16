package cn.zxd.trickster.util;

import android.util.Log;

import cn.zxd.trickster.BuildConfig;

public class LogUtils {

    private static final String TAG = "TRICKSTER";

    public static void LogV(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void LogD(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void LogI(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void LogW(String msg) {
        Log.w(TAG, msg);
    }

    public static void LogE(String msg) {
        Log.e(TAG, msg);
    }

    public static void LogA(String msg) {
        Log.wtf(TAG, msg);
    }

    public static void LogFV(String msg) {
        LogV(msg);
    }

    public static void LogFD(String msg) {

    }

    public static void LogFI(String msg) {

    }

    public static void LogFW(String msg) {

    }

    public static void LogFE(String msg) {

    }

    public static void LogFA(String msg) {

    }
}
