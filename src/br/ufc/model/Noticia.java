package br.ufc.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "NOTICIA")
public class Noticia {
	@Id
	@Column(name = "ID_NOTICIA", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_noticia;
	
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "SUBTITULO", nullable = false)
	private String subtitulo;
	
	@Column(name = "TEXTO", nullable = false)
	private String texto;
	
	@Column(name = "ID_AUTOR", nullable = false, insertable = false, updatable = false)
	private Long id_autor;
	
	@Column(name = "DATA_NOTICIA", nullable = false)
	private Date data_noticia;
	
	@Column(name = "ID_SECAO", nullable = false, insertable = false, updatable = false)
	private Long id_secao;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_SECAO", referencedColumnName = "ID_SECAO")
	private Secao secao;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_AUTOR",referencedColumnName = "ID_USUARIO")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "noticia", targetEntity = Comentario.class, fetch = FetchType.EAGER)
	private List<Comentario> comentarios;

	public Long getId_noticia() {
		return id_noticia;
	}

	public void setId_noticia(Long id_noticia) {
		this.id_noticia = id_noticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public Date getData_noticia() {
		return data_noticia;
	}

	public void setData_noticia(Date data_noticia) {
		this.data_noticia = data_noticia;
	}

	public Long getId_secao() {
		return id_secao;
	}

	public void setId_secao(Long id_secao) {
		this.id_secao = id_secao;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Noticia)){
			return false;
		}
		Noticia ref = (Noticia) obj;
		if(ref.id_noticia == this.id_noticia){
			return true;
		}
		return false;
	}

}
