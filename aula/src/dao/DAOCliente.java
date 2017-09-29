/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.Fabrica;
import entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Aluno
 */
public class DAOCliente {
    
    private Connection conn;
    
    public void salvar(Cliente cliente)
    {
        try{
        //Connection conn = Fabrica.getConexao();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTE (NOME) VALUES(?)");
            ps.setString(1, cliente.getNome());
            ps.execute();
                    
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void excluir()
    {
    
    }
    
    
}
