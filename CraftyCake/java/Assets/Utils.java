package CraftyCake.java.Assets;

import javafx.scene.control.Alert;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

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
    public void drawAlert(String message, String header, Alert.AlertType type){
        Alert a = new Alert(type);
        a.setHeaderText(header);
        a.setContentText(message);
        a.show();
    }
}
