package br.com.cast.sugestaofilme.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.sugestaofilme.DTO.FilmeDTO;
import br.com.cast.sugestaofilme.DTO.OmdbSearchDTO;
import br.com.cast.sugestaofilme.business.FilmeBusiness;

@RestController
@RequestMapping(path = "/filme")
public class FilmesAPI {
	
	@Autowired
	private FilmeBusiness filmebusiness;
	
	@RequestMapping(path="/{nome}", method=RequestMethod.GET)
	public List<OmdbSearchDTO> buscar(@PathVariable("nome") String nome) {
		return filmebusiness.buscar(nome);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<OmdbSearchDTO> buscar() {
		return filmebusiness.buscar(null);
	}
	
	@RequestMapping(path="/{nome}/mais", method = RequestMethod.GET)
	public List<OmdbSearchDTO> maisFilme(@PathVariable("nome") String nome) {
		return filmebusiness.maisFilme(nome);
	}
	
	@RequestMapping(path="/{imdbID}/detalhe", method = RequestMethod.GET)
	public FilmeDTO detalhe(@PathVariable("imdbID") String imdbID) {
		return filmebusiness.detalhe(imdbID);
	}

}
