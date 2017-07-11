package br.com.caelum.financas.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		/*Conta conta = new Conta();
		conta.setAgencia("6418");
		conta.setBanco("Itau");
		conta.setNumero("12345-6");
		conta.setTitular("Lucas");*/
		
		EntityManager em = JPAUtil.getEmf();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 6);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Sorveteria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(20.0));
		
		
		//em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
