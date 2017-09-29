package Tela;

import banco.Fabrica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TelaConta {

    public static void main(String[] args) {
        try {
           // Connection conn = Fabrica.getConexao();

            String resp = "n";
            

            do {
                Scanner scan = new Scanner(System.in);
                System.out.print("Cliente:");
                int cliente = scan.nextInt();
             //   PreparedStatement ps = conn.prepareStatement("INSERT INTO CONTA (CLIENTE_ID) VALUES(?)");
             //   ps.setInt(1, cliente);
             //   ps.execute();

                System.out.println("\nCadastrar outro? (s/n)");
                resp = scan.next().toUpperCase();

            } while (resp.equals("S"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
