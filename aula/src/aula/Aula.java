/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

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
public class Aula {

    public static void main(String[] args) {
        try {
            //conexão
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoTeste", "postgres", "postgres");

            String resp = "n";
            conn.prepareStatement("DROP TABLE IF EXISTS ITEMCONTA").execute();
            conn.prepareStatement("DROP TABLE IF EXISTS CONTA").execute();
            conn.prepareStatement("DROP TABLE IF EXISTS CLIENTE").execute();
            conn.prepareStatement("create table cliente(\n"
                    + "id serial not null\n"
                    + ",nome varchar(50)\n"
                    + ",constraint pk_cliente primary key (id)\n"
                    + ");").execute();
            conn.prepareStatement("create table conta(\n"
                    + "id serial not null\n"
                    + ",saldo numeric(7,2) not null\n"
                    + ",cliente_id int not null\n"
                    + ",constraint pk_conta primary key (id)\n"
                    + ",constraint fk_cliente foreign key (cliente_id) references cliente\n"
                    + ");").execute();
            conn.prepareStatement("create table itemConta(\n" +
                    "id serial not null\n" +
                    ",natureza char\n" +
                    ",conta_id int not null\n" +
                    ",constraint pk_itemConta primary key (id)\n" +
                    ",constraint fk_conta foreign key (conta_id) references conta\n" +
                    ");").execute();
            do {

                Scanner scan = new Scanner(System.in);
                System.out.print("Nome:");
                String nome = scan.next();

                
                PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTE (NOME) VALUES(?)");
                ps.setString(1, nome);
                ps.execute();
                System.out.println("\nCadastrar outro? (s/n)");
                resp = scan.next().toUpperCase();
            } while (resp.equals("S"));

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " NOME: " + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
