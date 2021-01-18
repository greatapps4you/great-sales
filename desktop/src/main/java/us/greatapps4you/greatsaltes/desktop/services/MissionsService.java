/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class MissionsService {

    @Value(("${specs.dir}"))
    private String specsPath;

    public String getMissionInfo(String missionName) throws IOException {
        String specFile = specsPath + missionName;
        System.out.println("Getting Specs: " + specFile);
        final StringBuilder fileContents = new StringBuilder(2000);

        final InputStream is = new FileInputStream(specFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        }
        return fileContents.toString();
    }
}
