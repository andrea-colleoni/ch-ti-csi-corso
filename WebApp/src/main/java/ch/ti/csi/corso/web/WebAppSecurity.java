package ch.ti.csi.corso.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(securedEnabled=true)
public class WebAppSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().permitAll().and().logout().and().authorizeRequests().antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.debug(true);
		web.ignoring().antMatchers("/resources/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN").and().withUser("user")
//				.password("321").roles("USER");
		
		auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery(
		   "select username,password, enabled from users where username=?")
		  .authoritiesByUsernameQuery(
		   "select username, role from user_roles where username=?");	
	}

}
