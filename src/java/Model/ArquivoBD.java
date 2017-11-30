/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BD.BancoDados;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Andrade
 */
public class ArquivoBD {

    String sql= "select u.email,u.nome as nome_usuario,a.nome,a.diretorio,a.formato " + "from arquivos a inner join usuario u on (u.id=a.id_usuario) ";

    public boolean insereArquivo(Arquivo arquivo) {
        try {
            BancoDados bd = new BancoDados();
            bd.abrir();
            arquivo.setDiretorio(Util.getDiretorioRelativo(arquivo.getDiretorio(), "uploads"));
            String sql= "insert into arquivos (id_usuario,nome,diretorio,formato) values" + "(" + arquivo.getUsuario().getId() + ",'" + arquivo.getNome() + "','" + arquivo.getDiretorio() + "'," + "'" + arquivo.getFormato() + "')";
            return bd.insert(sql) > 0;
        } catch (Exception err) {
            System.out.println("Algo deu errado.");
            System.out.println(err.getMessage());
            return false;
        }
    }

    public List<Arquivo> getArquivos(String pesquisa) {
        List<Arquivo> arquivos = new ArrayList<>();
        try {

            BancoDados bd = new BancoDados();
            bd.abrir();

            if (pesquisa != null) {
                sql += "where a.nome like '%" + pesquisa + "%' ";
            }
            ResultSet rs = bd.select(sql);
            while (rs.next()) {
                String nomeUsuario = rs.getString("nome_usuario");
                String email = rs.getString("u.email");
                String nomeArquivo = rs.getString("a.nome");
                String diretorio = rs.getString("a.diretorio");
                String formato = rs.getString("a.formato");
                Arquivo arq = new Arquivo(nomeArquivo, new Usuario(), diretorio, formato);
                arq.getUsuario().setNome(nomeUsuario);
                arq.getUsuario().setEmail(email);
                arquivos.add(arq);
            }
            return arquivos;

        } catch (Exception err) {
            System.out.println(err.getMessage());
            return arquivos;
        }

    }

    public List<Arquivo> getArquivos() {
        return getArquivos(null);
    }

}
