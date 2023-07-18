/**
 * Empresa: Talycapglobal
 * Clase:   RepositorioLogisticaTerrestre
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.repositorio;

import com.logistica.modelo.LogisticaTerrestre;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface permite operaciones crud sobre
 *  la tabla logisticaterrestre en la base de datos 
 */
@Repository
public interface RepositorioLogisticaTerrestre extends JpaRepository<LogisticaTerrestre, String> {

}
