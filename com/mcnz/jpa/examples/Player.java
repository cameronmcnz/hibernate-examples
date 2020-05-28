package com.mcnz.jpa.examples;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity 
@Table(name="player", schema="hibernate_examples")
public class Player {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="handle", unique=true)
	@Basic private String name;
	
	@Basic private String emailAddress;
	
	@Basic private Boolean verified;
	
	@Column(unique=true, nullable=false)
	private String password;
	
	@Transient
	private String encryptedPassword;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date lastAccessTime;
	
	@Temporal(TemporalType.DATE)
	@Column(updatable=false)
	private java.util.Calendar registrationDate;
	
	public Player() { }
	
	public Player(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Player(String name, String pass, String email) {
		this(name, pass);
		this.emailAddress = email;
		this.verified = false;
		this.lastAccessTime = new java.util.Date();
		this.registrationDate = Calendar.getInstance();
	}
	
	public static void main(String args[]) {
		
		MyDatabaseWizard.main(null);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Player player0 = new Player("Bart", "kowabunga", "bart@mcnz.com");
		Player player1 = new Player("Ralph", "choo-choo", "ralph@example.com");
		Player player2 = new Player("Homer", "doh!", "homer@pulpjava.com");
		
		entityManager.persist(player0);
		entityManager.persist(player1);
		entityManager.persist(player2);
		
		entityManager.getTransaction().commit();
		
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public java.util.Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(java.util.Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public java.util.Calendar getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(java.util.Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}

/*

The persistent fields or properties of an entity may be of the following types: Java primitive types,
java.lang.String, other Java serializable types (including wrappers of the primitive types,
java.math.BigInteger, java.math.BigDecimal, java.util.Date,
java.util.Calendar[5], java.sql.Date, java.sql.Time, java.sql.Timestamp,
byte[], Byte[], char[], Character[], java.time.LocalDate, java.time.Local-
Time, java.time.LocalDateTime, java.time.OffsetTime, java.time.OffsetDateTime,
and user-defined types that implement the Serializable interface); enums; entity types;
collections of entity types; embeddable classes (see Section 2.5); collections of basic and embeddable
types (see Section 2.6).


The Temporal annotation must be specified for persistent fields or properties of type
java.util.Date and java.util.Calendar unless a converter is being applied. It may only be
specified for fields or properties of these types.

The Basic annotation is the simplest type of mapping to a database column. The Basic annotation
can be applied to a persistent property or instance variable of any of the following types: Java primitive
types, wrappers of the primitive types, java.lang.String, java.math.BigInteger,
java.math.BigDecimal, java.util.Date, java.util.Calendar, java.sql.Date,
java.sql.Time, java.sql.Timestamp, java.time.LocalDate, java.time.Local-
Time, java.time.LocalDateTime, java.time.OffsetTime, java.time.OffsetDateTime,
byte[], Byte[], char[], Character[], enums, and any other type that implements
Serializable.[102] As described in Section 2.8, the use of the Basic annotation is optional for persistent
fields and properties of these types. If the Basic annotation is not specified for such a field or
property, the default values of the Basic annotation will apply.
 
 */
