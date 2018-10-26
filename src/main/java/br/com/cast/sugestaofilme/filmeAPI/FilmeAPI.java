package br.com.cast.sugestaofilme.filmeAPI;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.sugestaofilme.DTO.DetalheDTO;
import br.com.cast.sugestaofilme.DTO.OmdbDTO;

@Component
public class FilmeAPI {
	
	private static final String URL_FILME = "http://www.omdbapi.com/?s={nome}&type=movie&apikey={apikey}";
	private static final String URL_DETALHE = "http://www.omdbapi.com/?i={imdbID}&type=movie&apikey={apikey}";
	private static final String apikey = "2cc0e65c";
	
	private RestTemplate resttamplete;
	
	public FilmeAPI(RestTemplateBuilder builder) {
		this.resttamplete = builder.build();
	}
	

	public OmdbDTO getFilme(String nome){
		OmdbDTO resposta = this.resttamplete.getForObject(URL_FILME, OmdbDTO.class, nome, apikey);
		return resposta;
	}
	
	public DetalheDTO getDetalhe(String imdbID) {
		DetalheDTO resposta = this.resttamplete.getForObject(URL_DETALHE, DetalheDTO.class, imdbID, apikey);
		return resposta;
	}

}
