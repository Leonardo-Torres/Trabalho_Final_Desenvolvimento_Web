package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.DAO.NoticiaDAO;
import br.ufc.DAO.SecaoDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NoticiaController {
	@Autowired
	private NoticiaDAO nDAO;
	@Autowired
	private UsuarioDAO uDAO;
	@Autowired
	private SecaoDAO sDAO;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		List<Secao> secoes = new ArrayList<>();
		secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/inserirNoticiaFormulario";
	}
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(HttpSession session, Noticia noticia, Long idSecao, Long idUsuario){
		if(session != null && noticia.getTitulo() != null && noticia.getSubtitulo() != null
				&& noticia.getTexto() != null){
			Secao s = this.sDAO.recuperar(idSecao);
			Usuario u = this.uDAO.recuperar(idUsuario);
			noticia.setSecao(s);
			noticia.setUsuario(u);
			this.nDAO.inserir(noticia);
			return "cadastroOK";
		}
		return "redirect:inserirNoticiaFormulario";
	}
}
