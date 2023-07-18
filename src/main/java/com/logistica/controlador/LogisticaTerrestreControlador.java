/**
 * Empresa: Talycapglobal
 * Clase:   LogisticaTerrestreControlador
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.controlador;

import com.logistica.modelo.LogisticaTerrestre;

import com.logistica.repositorio.RepositorioLogisticaTerrestre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;
/**
 * Esta clase es la api de logistica terrestre 
 */
@RestController
@RequestMapping("/api")
public class LogisticaTerrestreControlador {
	private final Logger LOOGER = LoggerFactory.getLogger(LogisticaTerrestreControlador.class);

	@Autowired
	RepositorioLogisticaTerrestre repositorioLogisticaTerrestre;
	
	/**
	 * Este metodo devuelve la lista de logistica terrestre
	 * @return Iterable<LogisticaTerrestre> listarLogisticaTerrestre 
	 */
	@GetMapping(path="/logisticaterrestre")
	public @ResponseBody Iterable<LogisticaTerrestre> listarLogisticaTerrestre(){
		return repositorioLogisticaTerrestre.findAll();
	}
	
	/**
	 * Este metodo permite crear los registros de logistica terrestre 
	 * @param LogisticaTerrestre logisticaTerrestres parametro de tipo LogisticaTerrestre
	 * @return String mensaje
	 */
	@PostMapping("/logisticaterrestre/crear")
	public String crearLogisticaTerrestre(@RequestBody LogisticaTerrestre logisticaTerrestres) {
		try {
			LogisticaTerrestre logisticaTerrestre = new LogisticaTerrestre();
			logisticaTerrestre.setTipodeproducto(logisticaTerrestres.getTipodeproducto());
			logisticaTerrestre.setCantidadproducto(logisticaTerrestres.getCantidadproducto());
			logisticaTerrestre.setFecharegistro(logisticaTerrestres.getFecharegistro());
			logisticaTerrestre.setFechaentrega(logisticaTerrestres.getFechaentrega());
			logisticaTerrestre.setBodegaentrega(logisticaTerrestres.getBodegaentrega());
			logisticaTerrestre.setPrecioenvio(logisticaTerrestres.getPrecioenvio());
			logisticaTerrestre.setPlacavehiculo(logisticaTerrestres.getPlacavehiculo());
			logisticaTerrestre.setNumeroguia(logisticaTerrestres.getNumeroguia());
			if(logisticaTerrestres.getCantidadproducto() > 10) {
				logisticaTerrestre.setDescuento( (logisticaTerrestres.getPrecioenvio()*5)/100 );
			}else {
				logisticaTerrestre.setDescuento(0);
			}	
			repositorioLogisticaTerrestre.save(logisticaTerrestre);
		}catch(Exception e) {
			LOOGER.error("Error crearLogisticaTerrestre: "+e.getMessage());
		}				
		return "Registro Logistica Terrestre Creado Correctamente";
	}
	
	/**
	 * Este metodo permite buscar y devolver un registro de logistica 
	 * terrestre por la placa del vehiculo 
	 * @param String id parametro placa del vehiculo
	 * @return Optional<LogisticaTerrestre> informacion de logistica terrestre
	 */	
	@GetMapping("/logisticaterrestre/consultar/{id}")
	@ResponseBody
	public Optional<LogisticaTerrestre> consultarLogisticaTerrestrePlacaVehiculo(@PathVariable("id") String id) {
		return repositorioLogisticaTerrestre.findById(id);
	}	
	
	/**
	 * Este metodo permite eliminar un registro de logistica terrestre
	 * @param String id parametro placa del vehiculo
	 * @return String mensaje
	 */	
	@PostMapping("/logisticaterrestre/eliminar/{id}")
	@ResponseBody
	public String eliminarLogisticaTerrestre(@PathVariable("id") String id) {
		try {
			LogisticaTerrestre logisticaTerrestre = new LogisticaTerrestre();
			logisticaTerrestre.setPlacavehiculo(id);
			repositorioLogisticaTerrestre.delete(logisticaTerrestre);
		}catch(Exception e) {
			LOOGER.error("Error eliminarLogisticaTerrestre: "+e.getMessage());
		}
		return "Registro Logistica Terrestre eliminado";
	}
	
	/**
	 * Este metodo permite actualizar la informacion de logistica terrestre
	 * @param LogisticaTerrestre logisticaTerrestres parametro informacion logistica terrestre
	 * @param String id parametro placa del vehiculo
	 * @return String mensaje
	 */	
	@PutMapping("/logisticaterrestre/actualizar/{id}")
	public String actualizarLogisticaTerrestre(@RequestBody LogisticaTerrestre logisticaTerrestres, @PathVariable("id") String id) {
		try {
			LogisticaTerrestre logisticaTerrestre = new LogisticaTerrestre();
			Optional<LogisticaTerrestre> aux = repositorioLogisticaTerrestre.findById(id);
			LogisticaTerrestre logisticaTerrestreObj = aux.get();
			logisticaTerrestre.setPlacavehiculo(logisticaTerrestres.getPlacavehiculo());
			logisticaTerrestre.setTipodeproducto(logisticaTerrestres.getTipodeproducto());
			logisticaTerrestre.setCantidadproducto(logisticaTerrestres.getCantidadproducto());
			logisticaTerrestre.setFecharegistro(logisticaTerrestres.getFecharegistro());
			logisticaTerrestre.setFechaentrega(logisticaTerrestres.getFechaentrega());
			logisticaTerrestre.setBodegaentrega(logisticaTerrestres.getBodegaentrega());
			logisticaTerrestre.setPrecioenvio(logisticaTerrestres.getPrecioenvio());
			logisticaTerrestre.setNumeroguia(logisticaTerrestres.getNumeroguia());
			if(logisticaTerrestres.getCantidadproducto() > 10) {
				logisticaTerrestre.setDescuento( (logisticaTerrestres.getPrecioenvio()*5)/100 );
			}else {
				logisticaTerrestre.setDescuento(0);
			}				
			repositorioLogisticaTerrestre.save(logisticaTerrestre);
		}catch(Exception e) {
			LOOGER.error("Error actualizarLogisticaTerrestre: "+e.getMessage());
		}	
		return "Registro Logistica Terrestre actualizado correctamente";
	}	
}
