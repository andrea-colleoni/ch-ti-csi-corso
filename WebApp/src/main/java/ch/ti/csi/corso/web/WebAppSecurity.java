package ch.ti.csi.corso.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(securedEnabled=true)
public class WebAppSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
    private ClientDetailsService clientDetailsService;	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//			.csrf().disable()
//			.formLogin().permitAll()
//			.and()
//			.authorizeRequests()
//				.antMatchers("/oauth/token").permitAll()
//				.antMatchers("/user/**").hasRole("USER")
//				.antMatchers("/admin/**").hasRole("ADMIN")
//			.anyRequest().authenticated();
		.csrf().disable()
		.anonymous().disable()
        .authorizeRequests()
        .antMatchers("/oauth/token").permitAll();
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
	
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
 
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
 
    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }
     
    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }	

}
