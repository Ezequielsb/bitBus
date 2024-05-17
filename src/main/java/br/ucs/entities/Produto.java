package br.ucs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Produto {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codigoProduto;
	private String nome;
	private Integer ano;
	private Integer quantidade;
	private String dimensao;
	private String informcoes;
	private String caminhoImagem;
	private String link;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getDimensao() {
		return dimensao;
	}
	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}
	public String getInformcoes() {
		return informcoes;
	}
	public void setInformcoes(String informcoes) {
		this.informcoes = informcoes;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
