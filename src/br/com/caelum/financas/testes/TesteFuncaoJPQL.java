package br.com.caelum.financas.testes;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteFuncaoJPQL {
    public static void main(String[] args) {
    	
    	//Consulta teste antes sda criação da classe MovimentacaoDAO
        /*String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipo=:pTipo" +
                " group by m.data";

        TypedQuery<Double> query = manager.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> resultado = query.getResultList();*/

        EntityManager manager = new JPAUtil().getEmf();

        Conta conta = new Conta();
        conta.setId(6);
        
        /*MovimentacaoDAO dao = new MovimentacaoDAO(manager);

        double resultado = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA);

        System.out.println("Total movimentado ..: R$ " + resultado);*/
        
        //Teste com NamedQuery
        TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        
        Double media = query.getSingleResult();
        System.out.println("Media por NamedQuery: " + media);
    }

}

