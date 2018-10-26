package br.com.cast.sugestaofilme.entidade;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filme", schema = "sugestaofilme")
public class Filme {
	
	
	private String nome;
	private String ano;
	@Id
	private String imdbID;
	private String poster;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name = "imdbID_detalhe")
	private Detalhe detalhe;
	
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
	public void setIndbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public Detalhe getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(Detalhe detalhe) {
		this.detalhe = detalhe;
	}	
	
	
}
