/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rafael Andrade
 */
public class Util {

    private static String[][] SupportedFormats() {
        String[][] format = {
            {"image/png", ".png"},
            {"image/jpeg", ".jpg"},
            {"application/pdf", ".pdf"},
            {"text/plain", ".txt"}
        };
        return format;
    }

    public static String formatReturn(String mimeType) {
        String[][] format = SupportedFormats();
        for (int i = 0; i < format.length; i++) {
            for (int j = 0; j < format[i].length; j++) {
                if (mimeType.equals(format[i][0])) {
                    return format[i][1];
                }
            }
        }
        return null;
    }

    public static String getRelativeDirectory(String directory, String projectFolder) {
        String relativeDirectory = directory.substring(directory.indexOf(projectFolder));
        return relativeDirectory;
    }

    public static boolean emailController(String email) {
        return email.matches("\\S+@\\S+\\.\\S+");
    }
}
