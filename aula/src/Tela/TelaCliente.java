package tela;

import dao.DAOCliente;
import entidade.Cliente;
import java.util.Scanner;

public class TelaCliente {

    public static void main(String[] args) {
        try {
            

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
