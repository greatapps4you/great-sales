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

@Component
public class SystemConfigurationService
        implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${vendor.layouts.dir}")
    private String layoutsDir;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        System.out.println("Saving layouts to: " + layoutsDir);
        File layoutsDirPath = new File(layoutsDir);
        System.out.println("Exists? " + layoutsDirPath.exists());
        System.out.println("Is Directory? " + layoutsDirPath.isDirectory());

        return;
    }
}