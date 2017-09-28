package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static Connection conn;
    
    public static Connection getConexao() throws SQLException{
        if(conn==null){
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bancoTeste", "postgres", "postgres");
        }
        return conn;
    }
    
}
