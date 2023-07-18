/**
 * Empresa: Talycapglobal
 * Clase:   RepositorioCliente
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.repositorio;

import com.logistica.modelo.Cliente;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface permite operaciones crud sobre
 *  la tabla clientes en la base de datos 
 */
@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, String> {

}
