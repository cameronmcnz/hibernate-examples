package com.mcnz.jpa.examples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaCrudExample {

	public static void main(String[] args) {
		
		//MyDatabaseWizard.addEntity(Player.class);
		//MyDatabaseWizard.createDatabase();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Player player = new Player();
		player.setName("Bart");
		player.setPassword("kowabunga");
		entityManager.persist(player);
		
		entityManager.getTransaction().commit();
		

	}
}
