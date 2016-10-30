package edu.entities;

import java.net.PasswordAuthentication;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private char[] password;
	private String profilepic;
	public String getProfilepic() {
		return profilepic;
	}



	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}



	private PasswordAuthentication userinfo ;
		
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(int id, String nom, String prenom, String email, String login,
			char[] password, PasswordAuthentication userinfo) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.password = password;
		this.userinfo = userinfo;
	}
	public User(int id, String nom, String prenom, String email, String login,String profilepic) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.profilepic=profilepic;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public char[] getPassword() {
		return password;
	}



	public void setPassword(char[] password) {
		this.password = password;
	}



	public PasswordAuthentication getUserinfo() {
		return userinfo;
	}



	public void setUserinfo(PasswordAuthentication userinfo) {
		this.userinfo = userinfo;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + this.nom + this.prenom + this.email + this.login;
	}
	
}
