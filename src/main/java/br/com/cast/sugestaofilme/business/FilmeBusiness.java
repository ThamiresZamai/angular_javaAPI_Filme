package br.com.cast.sugestaofilme.business;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.sugestaofilme.DAO.FilmeDAO;
import br.com.cast.sugestaofilme.DTO.DetalheDTO;
import br.com.cast.sugestaofilme.DTO.FilmeDTO;
import br.com.cast.sugestaofilme.DTO.OmdbDTO;
import br.com.cast.sugestaofilme.DTO.OmdbSearchDTO;
import br.com.cast.sugestaofilme.entidade.Detalhe;
import br.com.cast.sugestaofilme.entidade.Filme;
import br.com.cast.sugestaofilme.filmeAPI.FilmeAPI;

@Service
public class FilmeBusiness {
	
	@Autowired
	private FilmeDAO filmedao;
	@Autowired
	private FilmeAPI filmeapi;
	
	private void salvar(Filme filme) {
		filmedao.inserir(filme);
	}
	
	public List<OmdbSearchDTO> buscar(String nome){
		List<Filme> lstfilmenome = filmedao.buscar(nome);
		List<OmdbSearchDTO> lstfimeresult = new ArrayList<>();
		
		for (Filme filme : lstfilmenome) {
			
			OmdbSearchDTO filmedto = new OmdbSearchDTO();
			filmedto.setNome(filme.getNome());
			filmedto.setAno(filme.getAno());
			filmedto.setImdbID(filme.getImdbID());
			filmedto.setPoster(filme.getPoster());

			
			lstfimeresult.add(filmedto);
		}
		return lstfimeresult;
	}
	
	@Transactional
	public List<OmdbSearchDTO> maisFilme(String nome){
			List<Filme> lstfilmenome = filmedao.buscar(nome);
			List<OmdbSearchDTO> lstfimeresult = new ArrayList<>();
			
		if(lstfilmenome.isEmpty()) {
			OmdbDTO omdbDto = filmeapi.getFilme(nome);
			for(OmdbSearchDTO searchDTO : omdbDto.getSearch()) {
				Filme filme = new Filme();
				filme.setImdbID(searchDTO.getImdbID());
				filme.setAno(searchDTO.getAno());
				filme.setNome(searchDTO.getNome());
				filme.setPoster(searchDTO.getPoster());
				
				salvar(filme);
			}
			
			
			lstfilmenome = filmedao.buscar(nome);
		}
		
		for (Filme filme : lstfilmenome) {
			
			OmdbSearchDTO filmedto = new OmdbSearchDTO();
			filmedto.setNome(filme.getNome());
			filmedto.setAno(filme.getAno());
			filmedto.setImdbID(filme.getImdbID());
			filmedto.setPoster(filme.getPoster());
			
			lstfimeresult.add(filmedto);
		}
		return lstfimeresult;
	}
	
	@Transactional
	public FilmeDTO detalhe(String imdbID) {
		Filme filme = filmedao.buscarPorID(imdbID);
		
		if(filme.getDetalhe() == null) {
			DetalheDTO detalhedto = filmeapi.getDetalhe(imdbID);
			Detalhe detalhe = new Detalhe();
			detalhe.setImdbID(imdbID);
			detalhe.setAtores(detalhedto.getAtores());
			detalhe.setDiretor(detalhedto.getDiretor());
			detalhe.setDuracao(detalhedto.getDuracao());
			detalhe.setGenero(detalhedto.getGenero());
			detalhe.setImdbID(detalhedto.getImdbID());
			detalhe.setSinopse(detalhedto.getSinopse());
			filme.setDetalhe(detalhe);
			filmedao.alterar(filme);
			
			return filmeParaDTO(imdbID);
		}else {
			return filmeParaDTO(imdbID);
		}
	}
	
	public FilmeDTO filmeParaDTO(String imdbID) {
		Filme filmecomdetallhe = filmedao.buscarPorID(imdbID);
		
		FilmeDTO filmeDto = new FilmeDTO();
		
		filmeDto.setAno(filmecomdetallhe.getAno());
		filmeDto.setImdbID(filmecomdetallhe.getImdbID());
		filmeDto.setNome(filmecomdetallhe.getNome());
		filmeDto.setPoster(filmecomdetallhe.getPoster());
		
		DetalheDTO detalhedto = new DetalheDTO();
		detalhedto.setAtores(filmecomdetallhe.getDetalhe().getAtores());
		detalhedto.setDiretor(filmecomdetallhe.getDetalhe().getDiretor());
		detalhedto.setDuracao(filmecomdetallhe.getDetalhe().getDuracao());
		detalhedto.setGenero(filmecomdetallhe.getDetalhe().getGenero());
		detalhedto.setImdbID(filmecomdetallhe.getDetalhe().getImdbID());
		detalhedto.setSinopse(filmecomdetallhe.getDetalhe().getSinopse());
		
		filmeDto.setDetalhe(detalhedto);
		
		return filmeDto;
	}
	
	
}
