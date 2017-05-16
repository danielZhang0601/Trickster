package cn.zxd.trickster.util;

import android.os.Build;

import java.io.File;

public class RootUtils {

    public static boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    private static boolean checkRootMethod1() {
        String buildTags = Build.TAGS;

        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }
        return false;
    }

    private static boolean checkRootMethod2() {
        try {
            File file = new File("/system/app/Superuser.apk");
            if (file.exists()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        return new ExecShell().executeCommand(ExecShell.SHELL_CMD.check_su_binary) != null;
    }

}
