package com.daniellfeijo_renanslopes8.personaltasksmanager.util.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MakeTables {
	public static void main(String[] args){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("personalTasksmanager");
		factory.close();
	}

}
