package br.com.cast.sugestaofilme.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * classe utilizada para mapear os campos que vem da API OMDb
 * @author Cast
 *
 */
public class OmdbDTO {
	
	@JsonProperty("Search")
	private List<OmdbSearchDTO> search;

	public List<OmdbSearchDTO> getSearch() {
		return search;
	}
	public void setSearch(List<OmdbSearchDTO> Search) {
		this.search = Search;
	}
	
}
