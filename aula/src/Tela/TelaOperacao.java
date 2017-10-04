/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TADS
 */
public class TelaOperacao {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoTeste", "postgres", "postgres");

            String resp = "n";
            conn.prepareStatement("DROP TABLE IF EXISTS ITEMCONTA").execute();
            
            conn.prepareStatement("create table itemConta(\n"
                    + "id serial not null\n"
                    + ",natureza char\n"
                    + ",valor numeric(7,2)\n"
                    + ",conta_id int not null\n"
                    + ",constraint pk_itemConta primary key (id)\n"
                    + ",constraint fk_conta foreign key (conta_id) references conta\n"
                    + ")").execute();

            do {
                
                conn.setAutoCommit(false);

                Scanner scan = new Scanner(System.in);
                System.out.print("conta:");
                int conta = scan.nextInt();
                System.out.print("crédito/débito:");
                String n = scan.next();
                System.out.print("valor:");
                double valor = scan.nextDouble();
                
                
                PreparedStatement ps = conn.prepareStatement("INSERT INTO ITEMCONTA (NATUREZA,VALOR,CONTA_ID) VALUES(?,?,?)");
                ps.setString(1, n);
                ps.setDouble(2, valor);
                ps.setDouble(3, conta);
                ps.execute();
                
                ResultSet rs = conn.prepareStatement("SELECT SALDO FROM CONTA WHERE ID = "+conta).executeQuery();
                
                double saldo = 0;
                if(rs.next())
                    saldo = rs.getDouble(1);
                
                if(n.equals("c"))
                    saldo += valor;
                else
                    saldo -= valor;
                
                ps = conn.prepareStatement("UPDATE CONTA SET SALDO = ? WHERE ID = "+conta);
                ps.setDouble(1,saldo);
                ps.execute();
                
                
                System.out.println("\nCadastrar outro? (s/n)");
                resp = scan.next().toUpperCase();
                
                conn.commit();

            } while (resp.equals("S"));

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
    }
}
