package br.ucs.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ministrante;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String horario;
    private String local;
    private String duracao;
    private String titulo;
    private String curriculoPalestrante;
    private String resumoPalestra;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL)
    private List<VisitanteOficina> visitantes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCurriculoPalestrante() {
		return curriculoPalestrante;
	}

	public void setCurriculoPalestrante(String curriculoPalestrante) {
		this.curriculoPalestrante = curriculoPalestrante;
	}

	public String getResumoPalestra() {
		return resumoPalestra;
	}

	public void setResumoPalestra(String resumoPalestra) {
		this.resumoPalestra = resumoPalestra;
	}

	public List<VisitanteOficina> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<VisitanteOficina> visitantes) {
		this.visitantes = visitantes;
	}
}
