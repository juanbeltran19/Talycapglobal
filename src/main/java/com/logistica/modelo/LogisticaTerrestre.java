/**
 * Empresa: Talycapglobal
 * Clase:   LogisticaTerrestre
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.modelo;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Esta clase es el modelo de LogisticaTerrestre
 */
@Entity
@Table(name="logisticaterrestre")
public class LogisticaTerrestre {

	@Column(name="tipodeproducto")
	private String tipodeproducto;

	@Column(name="cantidadproducto")
	private int cantidadproducto;
	
	@Column(name="fecharegistro")
	private String fecharegistro;
	
	@Column(name="fechaentrega")
	private String fechaentrega;

	@Column(name="bodegaentrega")
	private String bodegaentrega;
	
	@Column(name="precioenvio")
	private int precioenvio;
	
	@Id	
	@Column(name="placavehiculo")
	private String placavehiculo;
	
	@Column(name="numeroguia")
	private String numeroguia;
	
	@Column(name="descuento")
	private int descuento;

	public String getTipodeproducto() {
		return tipodeproducto;
	}

	public void setTipodeproducto(String tipodeproducto) {
		this.tipodeproducto = tipodeproducto;
	}

	public int getCantidadproducto() {
		return cantidadproducto;
	}

	public void setCantidadproducto(int cantidadproducto) {
		this.cantidadproducto = cantidadproducto;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public String getBodegaentrega() {
		return bodegaentrega;
	}

	public void setBodegaentrega(String bodegaentrega) {
		this.bodegaentrega = bodegaentrega;
	}

	public int getPrecioenvio() {
		return precioenvio;
	}

	public void setPrecioenvio(int precioenvio) {
		this.precioenvio = precioenvio;
	}

	public String getPlacavehiculo() {
		return placavehiculo;
	}

	public void setPlacavehiculo(String placavehiculo) {
		this.placavehiculo = placavehiculo;
	}

	public String getNumeroguia() {
		return numeroguia;
	}

	public void setNumeroguia(String numeroguia) {
		this.numeroguia = numeroguia;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
}
