/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 *
 * Team:
 * José Esteves de Souza Neto (Lead Engineer)
 * Renato Magrini (Front-End Developer)
 * Nathan Parra Ramos (Designer)
 *
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.services;

import org.springframework.stereotype.Service;

@Service
public  class OSService {
    private  final String OSName = System.getProperty("os.name").toLowerCase();

    public OS which() {
        if(OSName.equals("linux")) {
            return OS.LINUX;
        } else if( OSName.contains("mac")) {
            return OS.MAC;
        } else if( OSName.contains("sunos")) {
            return OS.SOLARIS;
        } else {
            // this OS is probably misspelled. Check later.
            return OS.RUINDOWS;
        }
    }
}




