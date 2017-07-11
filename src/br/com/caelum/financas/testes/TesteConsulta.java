package br.com.caelum.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(6);
		
		EntityManager manager = JPAUtil.getEmf();
		manager.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getId());
		}
				
		manager.getTransaction().commit();
		manager.close();
	}

}
