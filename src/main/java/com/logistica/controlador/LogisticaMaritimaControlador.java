/**
 * Empresa: Talycapglobal
 * Clase:   LogisticaMaritimaControlador
 * fecha:	18/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.controlador;

import com.logistica.modelo.LogisticaMaritima;

import com.logistica.repositorio.RepositorioLogisticaMaritima;

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
 * Esta clase es la api de logistica maritima 
 */
@RestController
@RequestMapping("/api")
public class LogisticaMaritimaControlador {
	private final Logger LOOGER = LoggerFactory.getLogger(LogisticaTerrestreControlador.class);

	@Autowired
	RepositorioLogisticaMaritima repositorioLogisticaMaritima;
	
	/**
	 * Este metodo devuelve la lista de logistica maritima
	 * @return Iterable<LogisticaMaritima> listarLogisticaMaritima 
	 */
	@GetMapping(path="/logisticamaritima")
	public @ResponseBody Iterable<LogisticaMaritima> listarLogisticaMaritima(){
		return repositorioLogisticaMaritima.findAll();
	}
	
	/**
	 * Este metodo permite crear los registros de logistica maritima 
	 * @param LogisticaMaritima logisticaMaritimas parametro de tipo LogisticaMaritima
	 * @return String mensaje
	 */
	@PostMapping("/logisticamaritima/crear")
	public String crearLogisticaMaritima(@RequestBody LogisticaMaritima logisticaMaritimas) {
		try {
			LogisticaMaritima logisticaMaritima = new LogisticaMaritima();
			logisticaMaritima.setTipodeproducto(logisticaMaritimas.getTipodeproducto());
			logisticaMaritima.setCantidadproducto(logisticaMaritimas.getCantidadproducto());
			logisticaMaritima.setFecharegistro(logisticaMaritimas.getFecharegistro());
			logisticaMaritima.setFechaentrega(logisticaMaritimas.getFechaentrega());
			logisticaMaritima.setPuertoentrega(logisticaMaritimas.getPuertoentrega());
			logisticaMaritima.setPrecioenvio(logisticaMaritimas.getPrecioenvio());
			logisticaMaritima.setNumeroflota(logisticaMaritimas.getNumeroflota());
			logisticaMaritima.setNumeroguia(logisticaMaritimas.getNumeroguia());
			if(logisticaMaritima.getCantidadproducto() > 10) {
				logisticaMaritima.setDescuento( (logisticaMaritimas.getPrecioenvio()*3)/100 );
			}else {
				logisticaMaritima.setDescuento(0);
			}	
			repositorioLogisticaMaritima.save(logisticaMaritima);
		}catch(Exception e) {
			LOOGER.error("Error crearLogisticaMaritima: "+e.getMessage());
		}				
		return "Registro Logistica Maritima Creado Correctamente";
	}
	
	/**
	 * Este metodo permite buscar y devolver un registro de logistica 
	 * maritima por el numero de flota 
	 * @param String id parametro numero de flota
	 * @return Optional<LogisticaMaritima> informacion de logistica maritima
	 */	
	@GetMapping("/logisticamaritima/consultar/{id}")
	@ResponseBody
	public Optional<LogisticaMaritima> consultarLogisticaMaritimaNumeroFlota(@PathVariable("id") String id) {
		return repositorioLogisticaMaritima.findById(id);
	}	
	
	/**
	 * Este metodo permite eliminar un registro de logistica maritima
	 * @param String id parametro numero de flota
	 * @return String mensaje
	 */	
	@PostMapping("/logisticamaritima/eliminar/{id}")
	@ResponseBody
	public String eliminarLogisticaMaritima(@PathVariable("id") String id) {
		try {
			LogisticaMaritima logisticaMaritima = new LogisticaMaritima();
			logisticaMaritima.setNumeroflota(id);
			repositorioLogisticaMaritima.delete(logisticaMaritima);
		}catch(Exception e) {
			LOOGER.error("Error eliminarLogisticaMaritima: "+e.getMessage());
		}
		return "Registro Logistica Maritima eliminado";
	}
	
	/**
	 * Este metodo permite actualizar la informacion de logistica maritima
	 * @param LogisticaMaritima logisticaMaritimas parametro informacion logistica maritima
	 * @param String id parametro numero de flota
	 * @return String mensaje
	 */	
	@PutMapping("/logisticamaritima/actualizar/{id}")
	public String actualizarLogisticaMaritima(@RequestBody LogisticaMaritima logisticaMaritimas, @PathVariable("id") String id) {
		try {
			LogisticaMaritima logisticaMaritima = new LogisticaMaritima();
			Optional<LogisticaMaritima> aux = repositorioLogisticaMaritima.findById(id);
			LogisticaMaritima logisticaTerrestreObj = aux.get();
			logisticaMaritima.setNumeroflota(logisticaTerrestreObj.getNumeroflota());
			logisticaMaritima.setTipodeproducto(logisticaMaritimas.getTipodeproducto());
			logisticaMaritima.setCantidadproducto(logisticaMaritimas.getCantidadproducto());
			logisticaMaritima.setFecharegistro(logisticaMaritimas.getFecharegistro());
			logisticaMaritima.setFechaentrega(logisticaMaritimas.getFechaentrega());
			logisticaMaritima.setPuertoentrega(logisticaMaritimas.getPuertoentrega());
			logisticaMaritima.setPrecioenvio(logisticaMaritimas.getPrecioenvio());
			logisticaMaritima.setNumeroguia(logisticaMaritimas.getNumeroguia());
			if(logisticaMaritima.getCantidadproducto() > 10) {
				logisticaMaritima.setDescuento( (logisticaMaritimas.getPrecioenvio()*5)/100 );
			}else {
				logisticaMaritima.setDescuento(0);
			}				
			repositorioLogisticaMaritima.save(logisticaMaritima);
		}catch(Exception e) {
			LOOGER.error("Error actualizarLogisticaMaritima: "+e.getMessage());
		}	
		return "Registro Logistica Maritima actualizado correctamente";
	}	
}
