package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "CLASSIFICADO")
public class Classificado {
	@Id
	@Column(name = "ID_CLASSIFICADO", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_classificado;
	
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "TEXTO", nullable = false)
	private String texto;
	
	@Column(name = "PRECO", nullable = false)
	private float preco;
	
	@Column(name = "TELEFONE", nullable = false)
	private String telefone;
	
	@Column(name = "MELHOR_OFERTA")
	private float melhor_oferta;
	
	@Column(name = "DATA_OFERTA")
	private Date data_oferta;
	
	//id do usuario, que publicou um classificado;
	@Column(name = "ID_AUTOR", insertable = false, updatable = false)
	private Long id_autor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_AUTOR",referencedColumnName = "ID_USUARIO")
	private Usuario usuario;

	public Long getId_classificado() {
		return id_classificado;
	}

	public void setId_classificado(Long id_classificado) {
		this.id_classificado = id_classificado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getMelhor_oferta() {
		return melhor_oferta;
	}

	public void setMelhor_oferta(float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}

	public Date getData_oferta() {
		return data_oferta;
	}

	public void setData_oferta(Date data_oferta) {
		this.data_oferta = data_oferta;
	}

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//verificação se o objeto que esta sendo usado é do tipo classificado;
	public boolean equals(Object obj) {
		if(!(obj instanceof Classificado)){
			return false;
		}
		Classificado ref = (Classificado) obj;
		if(ref.id_classificado == this.id_classificado){
			return true;
		}
		return false;
	}
}
