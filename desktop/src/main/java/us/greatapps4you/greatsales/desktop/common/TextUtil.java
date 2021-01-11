/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.common;

import java.util.Arrays;
import java.util.List;

public class TextUtil {
    public TextUtil() {
    }

    public static List<String> csvToList(String csv) {
        List<String> items = Arrays.asList(csv.split("\\s*;\\s*"));
        return items;
    }
}
