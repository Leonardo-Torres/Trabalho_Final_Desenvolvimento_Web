package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;

@Repository
public class PapelDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Papel papel){
		manager.persist(papel);
	}
	public void alterar(Papel papel){
		manager.merge(papel);
	}
	public List<Papel> listar(){
		String sql = "select p from PAPEL as p";
		return manager.createQuery(sql, Papel.class).getResultList();
	}
	public Papel recuperar(Long id){
		return manager.find(Papel.class, id);
	}
	public void apagar(Long id){
		Papel auxiliar = this.recuperar(id);
		manager.remove(auxiliar);
	}
	public Long recuperar(String papel){
		String sql = "select p from PAPEL as p where papel = :varPapel";
		Query query = manager.createQuery(sql);
		List<Papel> p = query.setParameter("varPapel", papel).getResultList();
		if(p.size() != 0){
			Papel ref = p.get(0);
			return ref.getId_papel();
		}
		return null;
	}

}
