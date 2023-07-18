/**
 * Empresa: Talycapglobal
 * Clase:   RepositorioLogisticaMaritima
 * fecha:	18/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica.repositorio;

import com.logistica.modelo.LogisticaMaritima;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface permite operaciones crud sobre
 *  la tabla logisticamaritima en la base de datos 
 */
@Repository
public interface RepositorioLogisticaMaritima extends JpaRepository<LogisticaMaritima, String> {

}
