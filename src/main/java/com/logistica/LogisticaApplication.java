/**
 * Empresa: Talycapglobal
 * Clase:   LogisticaApplication
 * fecha:	17/07/2023
 * @author Juan Pablo Beltran
 */
package com.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.seguridad.JWTAuthorizationFilter;

/**
 * Esta clase principal que contiene el inicio de la aplicacion
 * La clase interna WebSecurityConfig, decorada con @EnableWebSecurity y @Configuration, 
 * nos permite especificar la configuración de acceso a los recursos publicados. 
 * En este caso se permiten todas las llamadas al controlador /user, pero el resto de las llamadas requieren autenticación.
 *
 */
@SpringBootApplication
public class LogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.anyRequest().authenticated();
		}
	}
}
