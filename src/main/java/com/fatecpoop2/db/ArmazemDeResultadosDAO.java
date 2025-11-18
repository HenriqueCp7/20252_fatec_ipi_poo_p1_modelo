package com.fatecpoop2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ArmazemDeResultadosDAO {
    
     public void cadastrar(String nome, String resultado, int rodadaAtual ) throws Exception {


            String sql = "INSERT INTO resultados_rodada(data_atual, nome_personagem, resultado, rodada) VALUES(CURRENT_TIMESTAMP, ?, ?, ?)";
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, resultado);
            ps.setInt(3, rodadaAtual);
            ps.execute();
            ps.close();
            conexao.close();
        }
}
