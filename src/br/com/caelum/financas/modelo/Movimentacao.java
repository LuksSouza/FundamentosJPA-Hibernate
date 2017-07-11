package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name = "mediaDaContaPeloTipoMovimentacao", 
query = "select avg(m.valor) from Movimentacao m where m.conta=:pConta  and m.tipo = :pTipo")

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;

	@Temporal(TemporalType.DATE)
	private Calendar data;

	private String descricao;
	
	@ManyToMany
	private List<Categoria> categorias;
	
	@ManyToOne
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public Calendar getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}
