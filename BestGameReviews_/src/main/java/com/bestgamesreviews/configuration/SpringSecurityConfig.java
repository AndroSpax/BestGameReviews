/**
 * 
 */
package com.bestgamesreviews.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
/**
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter  {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("springuser").password(passwordEncoder().encode("spring123"))
			.roles(AuthoritiesConstants.USER)
			.and()
			.withUser("springadmin").password(passwordEncoder().encode("admin123"))
			.roles(AuthoritiesConstants.ADMIN,AuthoritiesConstants.USER );
	}
	@Override 
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
	      .and().authorizeRequests()
            .antMatchers("/api/authenticate").hasAuthority(AuthoritiesConstants.ANONYMOUS)
            .antMatchers("/api/inscription").hasAuthority(AuthoritiesConstants.ANONYMOUS) //.antMatchers("/api/register").permitAll()
            .antMatchers("/api/activate").permitAll()
            .antMatchers("/api/jeux/plateforme").permitAll()
            .antMatchers("/utilisateurs").permitAll()
            .antMatchers("/api/account/reset-password/init").permitAll()
            .antMatchers("/api/account/reset-password/finish").permitAll()
			.antMatchers("/api/admin/**").hasAuthority(AuthoritiesConstants.ADMIN)
			.antMatchers("/api/**")
			.authenticated()
			.and().csrf().disable() //TODO : aréactiver avec Rudolph
            //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            //.and()
            .cors()
            .and()
            .authorizeRequests()
            .anyRequest().authenticated();
//       
//        .and()
//            .apply(securityConfigurerAdapter());
        // @formatter:on
    
//			.and()
//			.formLogin();
//			.and()
//			.oauth2Login();
	}
//	private JWTConfigurer securityConfigurerAdapter() {
//        return new JWTConfigurer(tokenProvider);
//    }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
