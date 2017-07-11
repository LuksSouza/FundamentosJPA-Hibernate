 package br.com.caelum.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInserirMovimentacao {

	public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEmf();
        //em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);
        
        List<Movimentacao> movimentacoes = conta.getMovimentacoes();
        /*Query query = em.createQuery("select c.movimentacoes from Conta c join c.movimentacoes");
        List<Movimentacao> movimentacoes = query.getResultList();*/
        

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }

        em.close();
    }
}
