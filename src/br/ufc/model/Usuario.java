package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "USUARIO")
public class Usuario {
	@Id
	@Column(name = "ID_USUARIO", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_usuario;
	
	@Column(name = "LOGIN", nullable = false, unique = true)
	private String login;
	
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	//junção das tabelas usuario e papel;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_E_PAPEIS", joinColumns = @JoinColumn(name = "ID_USUARIO",
		referencedColumnName = "ID_USUARIO"),inverseJoinColumns = @JoinColumn(name = "ID_PAPEL",
		referencedColumnName = "ID_PAPEL"))
	private List<Papel> papeis;
	
	//um usuario pode publicar varias noticias, mais uma noticia so pode ser publicada por um usuario;
	@OneToMany(mappedBy = "usuario", targetEntity = Noticia.class, fetch = FetchType.EAGER)
	private List<Noticia> noticias;
	
	//um usuario pode publicar varias comentarios, mais um comentario so pode ser publicado por um usuario;
	@OneToMany(mappedBy = "usuario",targetEntity = Comentario.class, fetch = FetchType.EAGER)
	private List<Comentario> comentarios;
	
	//um usuario pode publicar varias classificados, mais um cassificado so pode ser publicado por um usuario;
	@OneToMany(mappedBy = "usuario", targetEntity = Classificado.class, fetch = FetchType.EAGER)
	private List<Classificado> classificados;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario)){
			return false;
		}
		Usuario ref = (Usuario) obj;
		if(ref.getId_usuario() == this.id_usuario){
			return true;
		}
		return false;
	}

}
