package br.com.caelum.financas.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setId(2);
		
		EntityManager manager = JPAUtil.getEmf();
		manager.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getValor());
		}
		
		manager.getTransaction().commit();
		manager.close();		
	}

}
