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