package com.instituto.atlantico.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.instituto.atlantico.dao.UsuarioDao;
import com.instituto.atlantico.service.impl.UsuarioDetail;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	private UsuarioDetail usuarioDetail;

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new UsuarioDetail(usuarioDao);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/h2-console/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/users").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/api/users/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
			/*	.antMatchers(HttpMethod.GET, "/api/users/**").authenticated();	
			    .access("hasAuthority('ADMIN')").anyRequest().authenticated().and().formLogin().loginPage("/login")
				.permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll().and().httpBasic();		
		*/

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());

	}

}