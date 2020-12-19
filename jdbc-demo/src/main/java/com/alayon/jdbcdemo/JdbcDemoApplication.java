package com.alayon.jdbcdemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alayon.jdbcdemo.entities.Person;
import com.alayon.jdbcdemo.jdbc.PersonJdbcDao;
import com.alayon.jdbcdemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJdbcDao dao;
	
	@Autowired
	private PersonJpaRepository jpa;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//jdbc
		log.info("=====================JDBC============================");
		log.info("All users -> {}", dao.findAll());
		log.info("User id 1001 -> {}", dao.findById(1001));
		log.info("User name jair -> {}", dao.findByName("Jair"));
		log.info("Deleting user id 1002 -> # of rows deleted - {}", dao.deleteById(1002));
		log.info("Inserting 1004 -> {}", dao.insert(new Person(1004,"karla", "Queretaro", new Date())));
		log.info("Updating 1003 -> {}", dao.update(new Person(1003,"Jose", "Veracruz", new Date())));
		
		
		//jpa
		log.info("=====================JPA============================");
		log.info("All users -> {}", jpa.findAll());
		log.info("User id 1001 -> {}", jpa.findById(1001));
		log.info("Inserting 1005 -> {}", jpa.update(new Person(1005, "Alicia", "Veracruz", new Date())));
		log.info("Updating 1005 -> {}", jpa.update(new Person(1005, "Alicia Machado", "Veracruz", new Date())));
		jpa.deleteById(1001);
		log.info("Deletegin user id 1001");
		/*
		 * log.info("All users -> {}", dao.findAll()); log.info("User id 1001 -> {}",
		 * dao.findById(1001)); log.info("User name jair -> {}",
		 * dao.findByName("Jair"));
		 * log.info("Deleting user id 1002 -> # of rows deleted - {}",
		 * dao.deleteById(1002)); log.info("Inserting 1004 -> {}", dao.insert(new
		 * Person(1004,"karla", "Queretaro", new Date())));
		 * log.info("Updating 1003 -> {}", dao.update(new Person(1003,"Jose",
		 * "Veracruz", new Date())));
		 */
		
	}

}
