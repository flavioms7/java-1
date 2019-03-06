package br.com.codenation;

import java.time.LocalDate;

public class Time {
	
	Long id = null;
	Long idCapitaoTime = null;
	String nome ="";
	String corUniformePrincipal = "";
	String corUniformeSecundario = "";
	LocalDate dataCriacao = null;
	
	public Time(Long id, String nome, String corUniformePrincipal, String corUniformeSecundario,
			LocalDate dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
		this.dataCriacao = dataCriacao;
	}

	public Long getIdCapitaoTime() {
		return idCapitaoTime;
	}

	public void setIdCapitaoTime(Long idCapitaoTime) {
		this.idCapitaoTime = idCapitaoTime;
	}

	public Time() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}
	public void setCorUniformePrincipal(String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}
	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}
	public void setCorUniformeSecundario(String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}