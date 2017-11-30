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

    private static String[][] formatosSuportados() {
        String[][] formatos = {
            {"image/png", ".png"},
            {"image/jpeg", ".jpg"},
            {"application/pdf", ".pdf"},
            {"text/plain", ".txt"}
        };
        return formatos;
    }

    public static String retornaFormato(String mimeType) {
        String[][] formatos = formatosSuportados();
        for (int i = 0; i < formatos.length; i++) {
            for (int j = 0; j < formatos[i].length; j++) {
                if (mimeType.equals(formatos[i][0])) {
                    return formatos[i][1];
                }
            }
        }
        return null;
    }

    public static String getDiretorioRelativo(String diretorio, String pastaProjeto) {
        String diretorioRelativo = diretorio.substring(diretorio.indexOf(pastaProjeto));
        return diretorioRelativo;
    }

    public static boolean validaEmail(String email) {
        return email.matches("\\S+@\\S+\\.\\S+");
    }
}
