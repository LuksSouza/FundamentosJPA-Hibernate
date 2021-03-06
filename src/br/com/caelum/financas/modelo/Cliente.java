package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	private String profissao;

	@JoinColumn(unique=true)
	@OneToOne
	private Conta conta;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
