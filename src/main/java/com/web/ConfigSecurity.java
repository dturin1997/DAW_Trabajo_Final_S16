package com.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	@Autowired
	private BCryptPasswordEncoder passEncripta;
	
	@Autowired
	public void autenticacion(AuthenticationManagerBuilder builder) {
		try {
			builder.jdbcAuthentication()
			.dataSource(ds)
			.passwordEncoder(passEncripta)
			.usersByUsernameQuery("SELECT usuario,PASSWORD,activo FROM usuarios\r\n"
					+ "WHERE usuario=?")
			.authoritiesByUsernameQuery("SELECT usuario,rol_nombre FROM roles\r\n"
					+ " INNER JOIN\r\n"
					+ "usuarios ON roles.usu_codigo=usuarios.usu_codigo\r\n"
					+ "WHERE usuario=?");
		}catch(Exception e) {
			System.out.println("Error de autenticacion");
		}
		
	}

}
