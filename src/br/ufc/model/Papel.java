package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "PAPEL")
public class Papel {
	@Id
	@Column(name = "ID_PAPEL", nullable = false)
	private Long id_papel;
	
	@Column(name = "PAPEL", nullable = false)
	private String papel;
	
	//um usuario pode ter varios papeis, como tambem um papel esta ligado a varios usuarios;
	@ManyToMany(mappedBy = "papeis",fetch = FetchType.EAGER)
	private List<Usuario> usuarios;


	public Long getId_papel() {
		return id_papel;
	}

	public void setId_papel(Long id_papel) {
		this.id_papel = id_papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Papel)){
			return false;
		}
		Papel ref = (Papel) obj;
		if(ref.id_papel == this.id_papel){
			return true;
		}
		return false;
	}


}
