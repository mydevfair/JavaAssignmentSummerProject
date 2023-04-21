package CraftyCake.java;

import java.text.NumberFormat;
import java.util.Locale;

public class util {

    public static String getMoney(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);
        return nf.format(amount);
    }

    public static String tableHeads() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s | %10s | %13s", "|Name", "Cakes Made", "Wage |"));
        sb.append("\n" + "|-------------------------------------|\n");
        return sb.toString();
    }

    public static String tableFoot() {
        StringBuilder sb = new StringBuilder();
        sb.append("|-------------------------------------|\n");
        return sb.toString();
    }
}
