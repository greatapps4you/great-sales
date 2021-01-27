/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

@Component
public class SystemConfigurationService
        implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${vendor.layouts.dir}")
    private String layoutsDir;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            exportFormLayout();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    private void exportFormLayout() throws IOException {
        String destinationDir = layoutsDir + "/guerra/";
        File destinationDirPath = new File(destinationDir);
        if (!destinationDirPath.exists()) {
            Files.createDirectories(destinationDirPath.toPath());
        }
        exportResource("layouts/guerra/layout.html",
                destinationDir + "layout.html");
        exportResource("layouts/guerra/logo.png",
                destinationDir + "logo.png");

    }

    private void exportResource(String resource, String dest) throws IOException {
        File outFile = new File(dest);
        if (!outFile.exists()) {
            System.out.println("Exporting: " + dest);

            URL url = this.getClass().getClassLoader().getResource(resource);
            InputStream is = url.openStream();
            FileOutputStream fos = new FileOutputStream(outFile);

            try {
                int oneChar;
                while ((oneChar = is.read()) != -1) {
                    fos.write(oneChar);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                is.close();
                fos.close();
            }
        } else {
            System.out.println("Already exists: " + dest);
        }
    }
}