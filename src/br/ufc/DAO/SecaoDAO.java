package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;


@Repository
public class SecaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao secao){
		manager.persist(secao);
	}
	public void alterar(Secao secao){
		manager.merge(secao);
	}
	public List<Secao> listar(){
		String sql = "select s from SECAO as s";
		return manager.createQuery(sql, Secao.class).getResultList();
	}
	public Secao recuperar(Long id){
		return manager.find(Secao.class, id);
	}
	public void apagar(Long id){
		Secao auxiliar = this.recuperar(id);
		manager.remove(auxiliar);
	}


}
