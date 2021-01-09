//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.greatsoft.greaterp.common;

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
