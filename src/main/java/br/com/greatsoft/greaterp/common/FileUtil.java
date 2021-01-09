package br.com.greatsoft.greaterp.common;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FileUtil {
    public FileUtil() {
    }

    public static void main(String[] args) {
        System.out.println(getAbsoluteHome());
        System.out.println(getHome());
    }

    private static String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] var2 = e.getStackTrace();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            StackTraceElement element = var2[var4];
            sb.append(element.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void log(Throwable ex) {
        String content = stackTraceToString(ex);
        String time = DateUtil.toLogFormat(new Date());
        String logDir = getHome() + "log/";
        File logPath = new File(logDir);
        if (!logPath.exists()) {
            logPath.mkdirs();
        }

        File file = new File(logDir + "greatSalesLog-" + time + ".txt");

        try {
            Files.write(Paths.get(file.getAbsolutePath()), content.getBytes(), new OpenOption[]{StandardOpenOption.CREATE});
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public static void exportLogo() {
        ImageIcon imageIcon = getLogo();
        Image image = imageIcon.getImage();
        RenderedImage rendered = null;
        if (image instanceof RenderedImage) {
            rendered = (RenderedImage)image;
        } else {
            BufferedImage buffered = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), 1);
            Graphics2D g = buffered.createGraphics();
            g.drawImage(image, 0, 0, (ImageObserver)null);
            g.dispose();
            rendered = buffered;
        }

        try {
            File imgDir = new File(getHome() + "img/logo-vof.jpg");
            if (!imgDir.exists()) {
                imgDir.mkdirs();
            }

            ImageIO.write((RenderedImage)rendered, "JPEG", imgDir);
        } catch (IOException var5) {
            log(var5);
        }

    }

    private static ImageIcon getLogo() {
        try {
            String icon = "br/com/greatsoft/greaterp/view/img/logo-vof.jpg";
            URL url = (new FileUtil()).getClass().getClassLoader().getResource(icon);
            ImageIcon imageIcon = new ImageIcon(url);
            return imageIcon;
        } catch (Exception var3) {
            log(var3);
            return null;
        }
    }

    private static void exportResource(String resource, String dest) {
        File outFile = new File(dest);
        if (!outFile.exists()) {
            URL url = (new FileUtil()).getClass().getClassLoader().getResource(resource);

            try {
                InputStream is = url.openStream();
                FileOutputStream fos = new FileOutputStream(outFile);

                int oneChar;
                while((oneChar = is.read()) != -1) {
                    fos.write(oneChar);
                }

                is.close();
                fos.close();
            } catch (IOException var7) {
                log(var7);
            }
        }

    }

    public static void exportH2Service() {
        String dest = getHome() + "h2/h2.conf";
        String upstartScript = "description \"H2 Database TCP Server\"  \n    author \"GreatSoft\"\n\n    start on startup\n    stop on shutdown \n      \n    expect fork\n\n    script \n        cd /home/username/greatsoft/greatsales/h2/\n        java -jar /home/username/greatsoft/greatsales/h2/greath2server.jar \n    end script";
        upstartScript = upstartScript.replaceAll("username", OS.getUser());
        File scriptDir = new File(getHome() + "h2/");
        if (!scriptDir.exists()) {
            scriptDir.mkdirs();
        }

        try {
            FileOutputStream fos = new FileOutputStream(dest, false);
            fos.write(upstartScript.getBytes());
            fos.close();
        } catch (FileNotFoundException var4) {
            log(var4);
        } catch (IOException var5) {
            log(var5);
        }

    }

    public static void exportH2Server() {
        String resource = "br/com/greatsoft/greaterp/resource/greath2server.jar";
        String dest = getHome() + "h2/greath2server.jar";
        File launcherDir = new File(getHome() + "h2/");
        if (!launcherDir.exists()) {
            launcherDir.mkdirs();
        }

        exportResource(resource, dest);
    }

    public static void exportH2Lib() {
        String resource = "br/com/greatsoft/greaterp/resource/h2-1.3.175.jar";
        String dest = getHome() + "h2/lib/h2-1.3.175.jar";
        File launcherDir = new File(getHome() + "h2/lib");
        if (!launcherDir.exists()) {
            launcherDir.mkdirs();
        }

        exportResource(resource, dest);
    }

    public static void exportReadme() {
        String resource = "br/com/greatsoft/greaterp/resource/leia-me.txt";
        String dest = getHome() + "leia-me.txt";
        File launcherDir = new File(getHome() + "h2/lib");
        if (!launcherDir.exists()) {
            launcherDir.mkdirs();
        }

        exportResource(resource, dest);
    }

    public static String getHome() {
        String home = "";
        if (OS.isLinux()) {
            home = "greatsoft/greatsales/";
        } else if (OS.isWindows()) {
            home = "c:/greatsoft/greatsales/";
        }

        return home;
    }

    public static String getAbsoluteHome() {
        String home = "";
        if (OS.isLinux()) {
            home = "/home/" + OS.getUser() + "/greatsoft/greatsales/";
        } else if (OS.isWindows()) {
            home = "c:/greatsoft/greatsales/";
        }

        return home;
    }
}
