package br.ufc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import br.ufc.DAO.PapelDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import sun.misc.BASE64Encoder;

@Transactional
@Controller
public class UsuarioController {
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	public String criptografia(String senha){
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
				          digest.update(senha.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
					return encoder.encode(digest.digest());
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
		}
		return senha;
	} 
	
	@RequestMapping("/inserirLeitorFormulario")
	public String inserirLeitorformulario(){
		return "usuario/inserirLeitorformulario";
	}
	@RequestMapping("/inserirUsuario")
	public String inserirLeitor(Usuario usuario){
		String senha = criptografia(usuario.getSenha());
		usuario.setSenha(senha);
		
		Long idPapel = pDAO.recuperar("Leitor");
		Papel p = new Papel();
		p.setId_papel(idPapel);
		
		uDAO.inserir(usuario, p);
		return "operacaoRealizada";
	}

	@RequestMapping("/inserirJornalistaformulario")
	public String inserirJornalistaformulario(){
		return "usuario/inserirJornalistaformulario";
	}
	@RequestMapping("/inserirJornalista")
	public String inserirJornalista(Usuario usuario){
		String senha = criptografia(usuario.getSenha());
		usuario.setSenha(senha);
		
		Long idPapel = pDAO.recuperar("Jornalista");
		Papel p = new Papel();
		p.setId_papel(idPapel);
		
		uDAO.inserir(usuario, p);
		return "operacaoRealizada";
	}
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		return "usuario/listarUsuario";
	}
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		uDAO.apagar(id);
		return "redirect:listarUsuario";
	}
	@RequestMapping("alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Model model, Long id){
		Usuario usuario = uDAO.recuperar(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterarUsuarioFormulario";
	}
	@RequestMapping("alterarUsuario")
	public String alterarUsuario(Usuario usuario){
		uDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}
}

