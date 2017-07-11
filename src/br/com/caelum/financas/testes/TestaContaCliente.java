package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Juarez");
		cliente.setEndereco("Estrada do caraio, 666");
		cliente.setProfissao("Vadio");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Chicao");
		cliente2.setEndereco("Estrada da pqp, 999");
		cliente2.setProfissao("Pinguço");
		
		Conta conta = new Conta();
		conta.setId(6);
		
		cliente.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager manager = JPAUtil.getEmf();
		manager.getTransaction().begin();
		
		manager.persist(cliente);
		manager.persist(cliente2);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
