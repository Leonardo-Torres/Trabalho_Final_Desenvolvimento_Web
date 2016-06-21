package br.ufc.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Usuario usuario,Papel papel){
		List<Papel>p = new ArrayList<>();
		p.add(papel);
		usuario.setPapeis(p);
		manager.persist(usuario);
	}
	public void alterar(Usuario usuario){
		manager.merge(usuario);
	}
	public List<Usuario> listar(){
		String sql = "select u from USUARIO as u";
		return manager.createQuery(sql, Usuario.class).getResultList();
	}
	public Usuario recuperar(Long id){
		return manager.find(Usuario.class, id);
	}
	public void apagar(Long id){
		Usuario auxiliar = this.recuperar(id);
		manager.remove(auxiliar);
	}
	public Usuario recuperar(String login){
		String sql = "select u from USUARIO as u where u.login =:param_login";
		Query query = manager.createQuery(sql);
		List<Usuario> usuarios = query.setParameter("param_login",login).getResultList();
		if(usuarios.size() != 0){
			return usuarios.get(0);
		}
		return null;
	}

}
