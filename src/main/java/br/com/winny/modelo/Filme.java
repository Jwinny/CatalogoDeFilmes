package br.com.winny.modelo;

public class Filme {
	private String nome;
	private String genero;
	private Integer ano;

	public Filme(String nome, String genero, Integer ano) {
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;

	}

	public String getNome() {
		return this.nome;
	}

	public String getGenero() {
		return this.genero;
	}

	public Integer getAno() {
		return this.ano;
	}
	
}
