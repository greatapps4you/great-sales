/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;

@Service
public class OrderFormLayoutService {
    private Logger logger = LoggerFactory.getLogger(OrderFormLayoutService.class);

    @Value(("${vendor.layouts.dir}"))
    private String vendorLayoutsDir;

    public String getOrderLayoutForVendor(String vendorName) throws IOException {
        String layoutFile = vendorLayoutsDir + vendorName.toLowerCase() + "/layout.html";
        logger.debug("Getting Specs: {}", layoutFile);

        final StringBuilder fileContents = new StringBuilder(2000);
        final InputStream is = new FileInputStream(layoutFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        }
        return fileContents.toString();
    }

    public void saveOrderLayoutForVendor(String vendorName, String layoutContent) throws IOException {
        String layoutFile = vendorLayoutsDir + vendorName.toLowerCase() + "/layout.htm";
        logger.debug("Saving: {}", layoutFile);

        try (FileOutputStream fos = new FileOutputStream(layoutFile)) {
            byte[] layoutContentBytes = layoutContent.getBytes();
            fos.write(layoutContentBytes);
        }
    }

    public String[] getAllLayoutNames() {
        File[] files = new File(vendorLayoutsDir).listFiles();
        return Arrays.stream(files)
                .filter(f -> !f.isHidden() && f.isDirectory())
                .map(f -> f.getName().toUpperCase())
                .toArray(String[]::new);
    }
}
