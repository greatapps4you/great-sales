package br.com.greatsoft.greaterp.common;

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
