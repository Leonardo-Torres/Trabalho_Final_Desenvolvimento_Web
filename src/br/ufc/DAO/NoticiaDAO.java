package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;
import br.ufc.model.Papel;


@Repository
public class NoticiaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Noticia noticia){
		manager.persist(noticia);
	}
	public void alterar(Noticia noticia){
		manager.merge(noticia);
	}
	public List<Noticia> listar(){
		String sql = "select n from NOTICIA as n";
		return manager.createQuery(sql,Noticia.class).getResultList();
	}
	public Noticia recuperar(Long id){
		return manager.find(Noticia.class, id);
	}
	public void apagar(Long id){
		Noticia auxiliar = this.recuperar(id);
		manager.remove(auxiliar);
	}
	public List<Noticia> noticiaSecao(Long idSecao){
		String hql = "select n from NOTICIA as n where id_secao =: varSecao";
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("varSecao", idSecao).getResultList();
		return noticias;
	}

}
