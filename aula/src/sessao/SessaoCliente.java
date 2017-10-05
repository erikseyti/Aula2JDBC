/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import dao.DAOCliente;
import entidade.Cliente;

/**
 *
 * @author Aluno
 */
public class SessaoCliente {
    public static void main(String args)
    {
    Cliente cliente = new Cliente();
    
    cliente.setNome("Jõao");
    Sessao sessao = new Sessao();
    
    try
    {
       
        sessao.iniciarTransacao();
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.setSessao(sessao.get());
        daoCliente.salvar(cliente);
       
        
    }
    
    catch(Exception e)
    {
    e.printStackTrace();
    sessao.cancelarTransacao();
    }
    
    }
    
}
