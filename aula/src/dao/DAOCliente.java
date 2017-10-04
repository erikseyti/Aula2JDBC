package dao;

import entidade.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOCliente {

    private Connection conn;

    public void salvar(Cliente cliente) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoteste", "postgres", "postgres");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTE (NOME) VALUES(?)");
            ps.setString(1, cliente.getNome());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
