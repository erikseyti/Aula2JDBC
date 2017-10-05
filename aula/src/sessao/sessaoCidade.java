/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import dao.DAOCidade;
import entidade.Cidade;

/**
 *
 * @author Aluno
 */
public class sessaoCidade {
    public static void main(String[] args)
    {
    Cidade cidade = new Cidade();
    Sessao sessao = new Sessao();
    
    try{
        sessao.iniciarTransacao();
        cidade.setNome("PARANAVAÌ");
        DAOCidade dao = new DAOCidade();
        dao.setSessao(sessao.get());
        dao.salvar(cidade);
        sessao.confirmarTransacao();

        }catch(Exception e)
        {
        sessao.cancelarTransacao();
        DAOCidade dao = new DAOCidade();
        dao.setSessao(sessao.get());
        dao.salvar(cidade);
        }
    
    }
    
    
    
    
    
    
}
