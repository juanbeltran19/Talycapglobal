/**
 * Empresa: Talycapglobal
 * Clase:   Cliente
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.modelo;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Esta clase es el modelo de Cliente
 */
@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="identificacion")
	private String identificacion;

	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="direccion")
	private String direccion;

	@Column(name="telefono")
	private String telefono;

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}	
