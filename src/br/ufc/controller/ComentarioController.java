package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.DAO.ComentarioDAO;
import br.ufc.DAO.NoticiaDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

public class ComentarioController {
	@Autowired
	@Qualifier(value="comentarioDAO")
	private ComentarioDAO cDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value = "usuarioDAO")
	private UsuarioDAO uDAO;
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(){
		return "comentario/inserirComentarioFormulario";
	}
	@RequestMapping("/inserirComentario")
	public String inserirComentario(HttpSession session, Comentario c, Long idUsuario, Long idNoticia){
		if(session != null && c.getTexto() != null){
			Usuario u = this.uDAO.recuperar(idUsuario);
			Noticia n = this.nDAO.recuperar(idNoticia);
			c.setNoticia(n);
			c.setUsuario(u);
			this.cDAO.inserir(c);
			return "cadastroOK";
		}
		return "redirect:inserirComentarioFormulario";
	}
}
