package br.com.nutrition.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutricionistaResource {
	
	@JsonProperty("nome_nutricionista")
	private String nome;
	
	@JsonProperty("idade")
	private String idade;
	
	@JsonProperty("codigo_registro")
	private String codigo_registro;
	
	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCodigo_registro() {
		return codigo_registro;
	}

	public void setCodigo_registro(String codigo_registro) {
		this.codigo_registro = codigo_registro;
	}

	@JsonProperty("id_paciente")
	private String idPaciente;

	public NutricionistaResource(String nome, String idPaciente) {
		this.nome = nome;
		this.idPaciente = idPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "NutricionistaResource [nome=" + nome + ", idade=" + idade + ", codigo_registro=" + codigo_registro
				+ ", idPaciente=" + idPaciente + "]";
	}
	
	
	

}
