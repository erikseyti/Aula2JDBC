package tela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TelaConta {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoTeste", "postgres", "postgres");

            String resp = "n";
            conn.prepareStatement("DROP TABLE IF EXISTS ITEMCONTA").execute();
            conn.prepareStatement("DROP TABLE IF EXISTS CONTA").execute();

            conn.prepareStatement("create table conta("
                    + "id serial not null"
                    + ",saldo numeric(7,2) default 0 not null"
                    + ",cliente_id int not null"
                    + ",constraint pk_conta primary key (id)"
                    + ",constraint fk_cliente foreign key (cliente_id) references cliente"
                    + ")").execute();
            conn.prepareStatement("create table itemConta("
                    + "id serial not null"
                    + ",natureza char"
                    + ",conta_id int not null"
                    + ",constraint pk_itemConta primary key (id)"
                    + ",constraint fk_conta foreign key (conta_id) references conta"
                    + ")").execute();

            do {
                Scanner scan = new Scanner(System.in);
                System.out.print("Cliente:");
                int cliente = scan.nextInt();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO CONTA (CLIENTE_ID) VALUES(?)");
                ps.setInt(1, cliente);
                ps.execute();

                System.out.println("\nCadastrar outro? (s/n)");
                resp = scan.next().toUpperCase();

            } while (resp.equals("S"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
