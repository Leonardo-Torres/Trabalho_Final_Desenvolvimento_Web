package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classificado){
		manager.persist(classificado);
	}
	public void alterar(Classificado classificado){
		manager.merge(classificado);
	}
	public List<Classificado> listar(){
		String sql = "select c from FUNCIONARIO as c";
		return manager.createQuery(sql, Classificado.class).getResultList();
	}
	public Classificado recuperar(Long id){
		return manager.find(Classificado.class, id);
	}
	public void apagar(Long id){
		Classificado auxiliar = this.recuperar(id);
		manager.remove(auxiliar);
	}

}
