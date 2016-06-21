package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Comentario comentario){
		manager.persist(comentario);
	}
	public void alterar(Comentario comentario){
		manager.merge(comentario);
	}
	public List<Comentario> listar(){
		String sql = "select c from COMENTARIO as c";
		return manager.createQuery(sql, Comentario.class).getResultList();
	}
	public Comentario recuperar(Long id){
		return manager.find(Comentario.class, id);
	}
	public void apagar(Long id){
		Comentario auxiliar = this.recuperar(id);
		manager.remove(auxiliar);
	}

}
