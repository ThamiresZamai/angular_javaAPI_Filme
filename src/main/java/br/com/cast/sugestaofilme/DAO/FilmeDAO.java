package br.com.cast.sugestaofilme.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.sugestaofilme.entidade.Filme;

@Repository
public class FilmeDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Filme filme) {		
		em.persist(filme);
	}
	
	public Filme buscarPorID(String imdbID) {
		return em.find(Filme.class, imdbID);
	}
	
	public void alterar(Filme filme) {
		em.merge(filme);
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme>  buscar(String nome) {
		String qlString = " FROM " + Filme.class.getName();
			   qlString += " where lower(nome) like :nome ";			
		
		Query query = em.createQuery(qlString)
				.setParameter("nome", (nome == null ? "" : nome.toLowerCase()) + "%");
		
		return query.getResultList();
	}

}
