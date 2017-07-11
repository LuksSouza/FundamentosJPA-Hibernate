package br.com.caelum.financas.testes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoes {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEmf();
		manager.getTransaction().begin();
		
		String jpql = "select c from Conta c join fetch c.movimentacoes";
		Query query = manager.createQuery(jpql);
		
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			
			for (Movimentacao movimento : (conta.getMovimentacoes())) {
				System.out.println("Movimentacões: " + movimento.getDescricao());
			}
		}
		
		/*Movimentacao mov1 = new Movimentacao();
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Salgados");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setValor(new BigDecimal("10.0"));
		
		Conta c1 = new Conta();
		c1.setId(5);
		Categoria cat = manager.find(Categoria.class, 3);
		
		mov1.setConta(c1);
		mov1.setCategorias(Arrays.asList(cat));
		
		manager.persist(mov1);*/
		
		manager.getTransaction().commit();
		manager.close();
	}

}
