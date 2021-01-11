/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FinnancialMath {
    public FinnancialMath() {
    }

    public static double roundDecimal(double valor, int casasDecimais) {
        if (casasDecimais < 0) {
            throw new IllegalArgumentException();
        } else {
            long factor = (long)Math.pow(10.0D, (double)casasDecimais);
            valor *= (double)factor;
            long tmp = Math.round(valor);
            return (double)tmp / (double)factor;
        }
    }

    public static boolean isNumber(String value) {
        boolean resultado = true;

        try {
            NumberFormat.getInstance().parse(value);
        } catch (ParseException var3) {
            resultado = false;
        }

        return resultado;
    }

    public static String formatarMoeda(Double valor, int casasDecimais) {
        DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(casasDecimais);
        formatoDois.setParseBigDecimal(true);
        return formatoDois.format(valor);
    }
}
