/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package us.greatapps4you.greatsales.desktop.common;

public class OS {
    private static final String OSName = System.getProperty("os.name").toLowerCase();

    public OS() {
    }

    public static void main(String[] args) {
        System.out.println(OSName);
        System.out.println(getUser());
    }

    public static boolean isWindows() {
        return OSName.contains("win");
    }

    public static boolean isMac() {
        return OSName.contains("mac");
    }

    public static boolean isLinux() {
        return OSName.equals("linux");
    }

    public static boolean isSolaris() {
        return OSName.contains("sunos");
    }

    public static String getUser() {
        return System.getProperty("user.name");
    }
}
