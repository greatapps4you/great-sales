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
