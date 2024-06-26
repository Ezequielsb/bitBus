package br.ucs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Doacao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoDoacao;
	private Double valor;
	@ManyToOne
	private Produto produto;
	private String nomeDoador;
	private Integer idadeDoador;
	private String cidadeDoador;
	private String patrocinio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoDoacao() {
		return tipoDoacao;
	}
	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getNomeDoador() {
		return nomeDoador;
	}
	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}
	public Integer getIdadeDoador() {
		return idadeDoador;
	}
	public void setIdadeDoador(Integer idadeDoador) {
		this.idadeDoador = idadeDoador;
	}
	public String getCidadeDoador() {
		return cidadeDoador;
	}
	public void setCidadeDoador(String cidadeDoador) {
		this.cidadeDoador = cidadeDoador;
	}
	public String getPatrocinio() {
		return patrocinio;
	}
	public void setPatrocinio(String patrocinio) {
		this.patrocinio = patrocinio;
	}
}
