package com.jdojo.fxmlexercicios.Modelo;

import java.util.Objects;

public class Persona {
	private String nome;
	private String apelidos;
	private int idade;

	public Persona(String nome, String apelidos, int idade) {
		this.nome = nome;
		this.apelidos = apelidos;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelidos() {
		return apelidos;
	}

	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apelidos, other.apelidos) && idade == other.idade && Objects.equals(nome, other.nome);
	}
}