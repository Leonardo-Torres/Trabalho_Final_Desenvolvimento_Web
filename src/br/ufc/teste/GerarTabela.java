package br.ufc.teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabela {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		fabrica.close();
	}

}
