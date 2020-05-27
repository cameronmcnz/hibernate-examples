package com.mcnz.jpa.examples;

import javax.persistence.*;

public class JpaCrudExample {


	public static void main(String args[]) {
	
		MyDatabaseWizard.main(null);
		JpaCrudExample.createRecord();
		JpaCrudExample.readRecord();
		JpaCrudExample.updateRecord();
		JpaCrudExample.deleteRecord();
		
	
	}
	
	public static void createRecord() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Player player0 = new Player("Bart", "kowabunga");
		Player player1 = new Player("Homer", "doh!");
		Player player2 = new Player("Ralph", "choo-choo");


		entityManager.persist(player0);
		entityManager.persist(player1);
		entityManager.persist(player2);
		
		entityManager.getTransaction().commit();
		
	}
	
	public static void readRecord() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Player player = entityManager.find(Player.class, Long.valueOf(2));
		System.out.println("Password is: " + player.getPassword());
		
		entityManager.getTransaction().commit();
		
	}
	
	public static void updateRecord() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Player player = entityManager.find(Player.class, Long.valueOf(2));
		player.setPassword("whyyou!!!");
		
		entityManager.getTransaction().commit();
		
	}
	
	public static void deleteRecord() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Player player = entityManager.find(Player.class, Long.valueOf(2));
		entityManager.remove(player);
		
		entityManager.getTransaction().commit();
		
	}
	
	
}
