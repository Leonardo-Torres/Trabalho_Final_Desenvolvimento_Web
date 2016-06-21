package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "COMENTARIO")
public class Comentario {
	@Id
	@Column(name = "ID_COMENTARIO", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_comentario;
	
	@Column(name = "ID_NOTICIA", nullable = false, insertable = false, updatable = false)
	private Long id_noticia;
	
	@Column(name = "ID_AUTOR", nullable = false,insertable = false, updatable = false)
	private Long id_autor;
	
	@Column(name = "TEXTO", nullable = false)
	private String texto;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_NOTICIA", referencedColumnName = "ID_NOTICIA")
	private Noticia noticia;

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public Long getId_noticia() {
		return id_noticia;
	}

	public void setId_noticia(Long id_noticia) {
		this.id_noticia = id_noticia;
	}

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof Comentario)){
			return false;
		}
		Comentario ref = (Comentario) obj;
		if(ref.id_comentario == this.id_comentario){
			return true;
		}
		return false;
	}

}
