/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.utils;

public final class OsUtil {

    private static final String OSName = System.getProperty("os.name").toLowerCase();

    private OsUtil() {
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
}