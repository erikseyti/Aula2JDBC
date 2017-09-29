package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {
    
    private static EntityManagerFactory fabrica;
    
    public EntityManagerFactory getFabrica()
    {
    if(fabrica == null)
    {
    fabrica = Persistence.createEntityManagerFactory("bancoTestePU");
    }
    return fabrica;
    }
    
    
    
    
    /*
    private static Connection conn;
    
    public static Connection getConexao(){
        try {
        if(conn==null)
            
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoTeste", "postgres", "postgres");
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
                    
                    conn.prepareStatement("DROP TABLE IF EXISTS ITEMCONTA").execute();
            
            conn.prepareStatement("create table itemConta(\n"
                    + "id serial not null\n"
                    + ",natureza char\n"
                    + ",valor numeric(7,2)\n"
                    + ",conta_id int not null\n"
                    + ",constraint pk_itemConta primary key (id)\n"
                    + ",constraint fk_conta foreign key (conta_id) references conta\n"
                    + ")").execute();
            
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
                    
            } catch (SQLException ex) {
                Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
            }
        return conn;
        }
        */
    }
    

