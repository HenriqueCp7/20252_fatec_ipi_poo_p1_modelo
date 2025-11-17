package com.fatecpoop2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class HistoricoAtaquesDAO {

    public void cadastrar(String nome, ArrayList<String> historicoAtaques) throws Exception {

        int qntFaca = 0;
        int qntFuzil = 0;
        int qntPistola = 0;
        
        for (int i = 0; i < historicoAtaques.size(); i++) {
            String armaDaRodada = historicoAtaques.get(i);
            
            if (armaDaRodada == ("Faca")) {
                qntFaca += 1;
            } else if (armaDaRodada == ("Fuzil")) {
                qntFuzil += 1;
            } else if (armaDaRodada == ("Pistola")) {
                qntPistola += 1;
            }
        }

        String[] armas = {"Faca", "Fuzil", "Pistola"};
        int[] qntArmas = {qntFaca, qntFuzil, qntPistola};

        for (int i = 0; i < 3; i++) {

            String sql = "INSERT INTO historico_ataques(nome_personagem, nome_arma, vezes_usada) VALUES(?, ?, ?)";
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, armas[i]);
            ps.setInt(3, qntArmas[i]);
            ps.execute();
            ps.close();
            conexao.close();
        }
    }
}
