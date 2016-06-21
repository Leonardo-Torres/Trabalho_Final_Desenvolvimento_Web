package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "SECAO")
public class Secao {
	
	@Id
	@Column(name = "ID_SECAO", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_secao;
	
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "secao",targetEntity = Noticia.class,fetch = FetchType.EAGER)
	private List<Noticia> noticias;

	public Long getId_secao() {
		return id_secao;
	}

	public void setId_secao(Long id_secao) {
		this.id_secao = id_secao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Secao)){
			return false;
		}
		Secao ref = (Secao) obj;
		if(ref.id_secao == this.id_secao){
			return true;
		}
		return false;
	}

}
