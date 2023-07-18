/**
 * Empresa: Talycapglobal
 * Clase:   Usuario
 * fecha:	18/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.modelo;
/**
 * Esta clase es el modelo de usuario
 * para almacenar las credenciales
 */
public class Usuario {
	
	private String user;
	private String password;
	private String token;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
