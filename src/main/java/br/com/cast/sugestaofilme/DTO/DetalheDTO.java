package br.com.cast.sugestaofilme.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalheDTO {

	private String imdbID;
	@JsonProperty("Runtime")
	private String duracao;
	@JsonProperty("Genre")
	private String genero;
	@JsonProperty("Director")
	private String diretor;
	@JsonProperty("Actors")
	private String atores;
	@JsonProperty("Plot")
	private String sinopse;


	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

}
