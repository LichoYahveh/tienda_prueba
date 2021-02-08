package com.prueba.root.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private DataSource ds;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Para mantener disponibles los recursos de la carpeta static
	    String[] resources = {	"/assets/**",
								"/index/carrito.js",
	    						"/usuario/**",
	    						"/",
	    						"/usuario/principal",
	    						"/usuario/listado",
	    						"/producto/**"
	    					};
	    
	    http.authorizeRequests().antMatchers(resources).permitAll().anyRequest().authenticated().
	    and().
    	formLogin().
    	permitAll().
    	defaultSuccessUrl("/").
    	failureUrl("/login?error=true").
    and().
    	logout().
    	permitAll().
    	logoutSuccessUrl("/");
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder auth) {
		String query	= " SELECT usuario, clave, true estado FROM usuarios where usuario=? and estado='A' ";
		String query2	= " SELECT usuario, rol FROM usuarios where usuario=? and estado='A' ";
		try {
			auth.jdbcAuthentication().dataSource(ds).passwordEncoder(encoder)
			.usersByUsernameQuery(query)
			.authoritiesByUsernameQuery(query2)
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
