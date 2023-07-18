/**
 * Empresa: Talycapglobal
 * Clase:   ClienteControlador
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.controlador;

import com.logistica.modelo.Cliente;

import com.logistica.repositorio.RepositorioCliente;

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
 * Esta clase es la api de clientes 
 */
@RestController
@RequestMapping("/api")
public class ClienteControlador {
	
	private final Logger LOOGER = LoggerFactory.getLogger(ClienteControlador.class);

	@Autowired
	RepositorioCliente repositorioCliente;
	
	/**
	 * Este metodo devuelve la lista de los clientes 
	 * @return Iterable<Cliente> listarClientes 
	 */
	@GetMapping(path="/clientes")
	public @ResponseBody Iterable<Cliente> listarClientes(){
		return repositorioCliente.findAll();
	}
	
	/**
	 * Este metodo permite crear los clientes 
	 * @param Cliente clientes parametro de tipo Cliente
	 * @return String mensaje
	 */
	@PostMapping("/clientes/crear")
	public String crearCliente(@RequestBody Cliente clientes) {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdentificacion(clientes.getIdentificacion());
			cliente.setNombres(clientes.getNombres());
			cliente.setApellidos(clientes.getApellidos());
			cliente.setDireccion(clientes.getDireccion());
			cliente.setTelefono(clientes.getTelefono());
			repositorioCliente.save(cliente);
		}catch(Exception e) {
			LOOGER.error("Error crearCliente: "+e.getMessage());
		}				
		return "Cliente Creado Correctamente";
	}
	
	/**
	 * Este metodo permite buscar y devolver un cliente 
	 * @param String id parametro identificacion cliente
	 * @return Optional<Cliente> informacion del cliente
	 */	
	@GetMapping("/clientes/consultar/{id}")
	@ResponseBody
	public Optional<Cliente> consultarCliente(@PathVariable("id") String id) {
		return repositorioCliente.findById(id);
	}
	
	/**
	 * Este metodo permite eliminar un cliente
	 * @param String id parametro identificacion cliente
	 * @return String mensaje
	 */	
	@PostMapping("/clientes/eliminar/{id}")
	@ResponseBody
	public String eliminarCliente(@PathVariable("id") String id) {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdentificacion(id);
			repositorioCliente.delete(cliente);
		}catch(Exception e) {
			LOOGER.error("Error eliminarCliente: "+e.getMessage());
		}
		return "Cliente eliminado";
	}
	
	/**
	 * Este metodo permite actualizar la informacion de un cliente
	 * @param Cliente usuario parametro informacion cliente
	 * @param String id parametro identificacion cliente
	 * @return String mensaje
	 */	
	@PutMapping("/clientes/actualizar/{id}")
	public String actualizarCliente(@RequestBody Cliente usuario, @PathVariable("id") String id) {
		try {
			Cliente cliente = new Cliente();
			Optional<Cliente> aux = repositorioCliente.findById(id);
			Cliente clienteObj = aux.get();
			cliente.setIdentificacion(clienteObj.getIdentificacion());
			cliente.setNombres(usuario.getNombres());
			cliente.setApellidos(usuario.getApellidos());
			cliente.setDireccion(usuario.getDireccion());
			cliente.setTelefono(usuario.getTelefono());
			repositorioCliente.save(cliente);
		}catch(Exception e) {
			LOOGER.error("Error actualizarCliente: "+e.getMessage());
		}	
		return "Cliente actualizado correctamente";
	}	
	
}
