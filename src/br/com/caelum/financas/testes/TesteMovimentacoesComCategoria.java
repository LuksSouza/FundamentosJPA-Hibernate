package br.com.caelum.financas.testes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Viagem SP");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("100.0"));
		movimentacao.setCategorias(Arrays.asList(categoria1, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem RJ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
		
		Conta conta = new Conta();
		conta.setId(6);
		
		movimentacao.setConta(conta);
		movimentacao2.setConta(conta);
		
		EntityManager manager = JPAUtil.getEmf();
		manager.getTransaction().begin();
		
		manager.persist(categoria1);
		manager.persist(categoria2);
		
		manager.persist(movimentacao);
		manager.persist(movimentacao2);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
