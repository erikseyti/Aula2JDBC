/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aluno
 */
public class DAOCidade {
    private EntityManager sessao;
    
    public Cidade salvar(Cidade cidade)
    {
        sessao.persist(cidade);
        return cidade;
    
    }
    
    public Cidade alterar(Cidade cidade)
    {
        return sessao.merge(cidade);    
    }
    
    public void excluir(Cidade cidade)
    {
        sessao.remove(cidade);
    }
    
    public Cidade buscar(Class c, int id)
    {
    return sessao.find(Cidade.class, id);
    }
    
    public List<Cidade> buscar()
    {
    return sessao.createQuery("from Cidade").getResultList();
    }

    public void setSessao(EntityManager get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
