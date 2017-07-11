package br.com.caelum.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEmf();
		manager.getTransaction().begin();
		
		/*Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
				
		System.out.println("Quantidade de movimentações na conta de " + movimentacao.getConta().getTitular()
				+ ": " + movimentacao.getConta().getMovimentacoes().size());*/
		
		Query query = manager.createQuery("select c from Conta c");
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Movimentações X conta - " + conta.getMovimentacoes().size() + " x " + conta.getTitular());
		}
		
		manager.getTransaction().commit();
		manager.close();
	}
}
