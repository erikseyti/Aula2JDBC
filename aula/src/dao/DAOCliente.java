package dao;

import entidade.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOCliente {

    private EntityManager sessao;
    
    public Cliente salvar(Cliente cliente)
    {
        sessao.persist(cliente);
        return cliente;
    
    }
    
    public Cliente alterar(Cliente cliente)
    {
        return sessao.merge(cliente);
    
    }
    
    public void excluir(Cliente cliente)
    {
        sessao.remove(cliente);
    }
    
    public Cliente buscar(Class c, int id)
    {
    return sessao.find(Cliente.class, id);
    }
    
    public List<Cliente> buscar()
    {
    return sessao.createQuery("from Cliente").getResultList();
    }

    public void setSessao(EntityManager get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
