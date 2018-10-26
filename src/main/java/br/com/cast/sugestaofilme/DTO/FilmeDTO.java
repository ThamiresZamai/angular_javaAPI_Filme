package br.com.cast.sugestaofilme.DTO;

public class FilmeDTO {

	private String nome;
	private String ano;
	private String imdbID;
	private String poster;
	private DetalheDTO detalhe;

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

	public DetalheDTO getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(DetalheDTO detalhe) {
		this.detalhe = detalhe;
	}

}
