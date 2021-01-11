package us.greatapps4you.greatsales.desktop.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public DateUtil() {
    }

    public static void main(String[] args) {
        System.out.println(toDateDDmmYYYY("19/09/2014"));
        System.out.println(toStringDDmmYYYY(new Date()));
    }

    public static String toLogFormat(Date data) {
        Locale locale = Locale.getDefault();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy-HHmmss", locale);
        return data != null && locale != null ? sdf.format(data) : null;
    }

    public static String toStringDDmmYYYY(Date data) {
        Locale locale = Locale.getDefault();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", locale);
        return data != null && locale != null ? sdf.format(data) : null;
    }

    public static Date toDateDDmmYYYY(String data) {
        Locale locale = Locale.getDefault();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", locale);
        Date result = null;

        try {
            result = formatter.parse(data);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }
}
