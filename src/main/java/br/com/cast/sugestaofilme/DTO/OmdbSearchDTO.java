package br.com.cast.sugestaofilme.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * classe utilizada para mapear os campos que vem da API OMDb
 * @author Cast
 *
 */
public class OmdbSearchDTO {
	
	@JsonProperty("Title")
	private String nome;
	@JsonProperty("Year")
	private String ano;
	@JsonProperty("imdbID")
	private String imdbID;
	@JsonProperty("Poster")
	private String poster;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}

	
	
}
