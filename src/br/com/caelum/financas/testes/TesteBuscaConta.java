package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEmf();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 9);
		
		System.out.println("A conta do usuario " + conta.getTitular() + " sera removida...");
		
		//em.merge(conta);
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
