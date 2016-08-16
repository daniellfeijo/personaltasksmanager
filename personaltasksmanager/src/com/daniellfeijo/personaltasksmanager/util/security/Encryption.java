package com.daniellfeijo.personaltasksmanager.util.security;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.math.BigInteger;

public class Encryption {
	/**
	 * create hash of password
	 * 
	 * 
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
		return hash.toString(16);
	}
	
	/**
	 * test the function in the console
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String password = "personalTasksmanager";
		String encryptedPass ="";
		try {
			encryptedPass = md5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(encryptedPass);
	}
}