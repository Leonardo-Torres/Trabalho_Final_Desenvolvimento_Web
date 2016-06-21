package br.ufc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.DAO.PapelDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import sun.misc.BASE64Encoder;

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	@Qualifier(value = "usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value = "papelDAO")
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
	
	@RequestMapping("/loginUsuarioFormulario")
	public String loginUsuarioFormulario(){
		return "usuario/loginUsuarioFormulario";
	}
	@RequestMapping("/login")
	public String login(HttpSession session, Usuario usuario, String papel){
		Usuario aux = uDAO.recuperar(usuario.getLogin());
		String senhaCriptografada = criptografia(usuario.getSenha());
		Long id_papel = pDAO.recuperar(papel);
		Papel p = pDAO.recuperar(id_papel);
		if(aux != null){
			List<Papel> papeis = aux.getPapeis();
			if(senhaCriptografada.equals(aux.getSenha()) && 
					papel.equals("leitor") && papeis.contains(p)){
				session.setAttribute("leitor_logado", aux);
				return "home";
			}else if(senhaCriptografada.equals(aux.getSenha()) && 
					papel.equals("jornalista") && papeis.contains(p)){
				session.setAttribute("jornalista_logado", aux);
				return "home";
			}else if(senhaCriptografada.equals(aux.getSenha()) && 
					papel.equals("editor") && papeis.contains(p)){
				session.setAttribute("editor_logado", aux);
				return "home";
			}
		}
		return "redirect:loginUsuarioFormulario";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
