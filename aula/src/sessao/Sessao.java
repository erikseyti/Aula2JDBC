/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import banco.Fabrica;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Aluno
 */
public class Sessao {
    private EntityManager sessao;
    private EntityTransaction transacao;
    
    public void setSessao(EntityManager sessao)
    {
    this.sessao = sessao;
    }
    
    public Sessao()
    {
    sessao = Fabrica.get().createEntityManager();
    }
    
    public void iniciarTransacao()
    {
    transacao.begin();
    }
    
    public void confirmarTransacao()
    {
    transacao.commit();
    }
    
    public void cancelarTransacao()
    {
    transacao.rollback();
    }
    
    public EntityManager get()
    {
    return sessao;
    }
    
}
