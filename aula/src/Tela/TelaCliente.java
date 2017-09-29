/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import banco.Fabrica;
import dao.DAOCliente;
import entidade.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author TADS
 */
public class TelaCliente {

    public static void main(String[] args) {
        try {
            //conexão
          //  Connection conn = Fabrica.getConexao();

            String resp = "n";
            
            do {

                Scanner scan = new Scanner(System.in);
                System.out.print("Nome:");
                String nome = scan.next();
                
                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                
                DAOCliente dao = new DAOCliente();
                dao.salvar(cliente);
                System.out.println("\nCadastrar outro? (s/n)");
                resp = scan.next().toUpperCase();
            } while (resp.equals("S"));

          //  Statement st = conn.createStatement();
          //  ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE");

         //   while (rs.next()) {
          //      System.out.println("ID: " + rs.getInt(1) + " NOME: " + rs.getString(2));
          //  }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
