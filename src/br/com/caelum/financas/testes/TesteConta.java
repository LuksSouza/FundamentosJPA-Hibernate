package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Joaquim");
		conta.setBanco("Itau");
		conta.setAgencia("0123");
		conta.setNumero("12345-6");
		
		EntityManager em = JPAUtil.getEmf();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	} 

}
