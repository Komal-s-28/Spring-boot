package com.spring.boot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	static{
		System.out.println("###SecurityConfig statck blk");
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("###configure() method in SecurityConfig");
		auth.inMemoryAuthentication()
			.withUser("user1@example.com").password("user1").roles("USER").and()
			.withUser("admin1@example.com").password("admin1").roles("USER", "ADMIN");
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Below is the default configuration provided by Spring Security.
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
		
		//Customized configuration to disable csrf() inorder to access H2 console in web browser
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic().and().csrf().disable();

		//Customized configuration to all authenticated users with only role USER.
		//http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin().and().httpBasic().and().csrf().disable();
		
		//Customized Configuration to use our customized login page
		/*http.authorizeRequests()
		    //The below line is to avoid continuous page-redirection error
		    .antMatchers("/login/form").hasAnyRole("ANONYMOUS", "USER")
		    .antMatchers("/**").hasRole("USER")
		    .and().formLogin()
				.loginPage("/login/form")
                .loginProcessingUrl("/processlogin")
                .failureUrl("/login/form?error")
                .usernameParameter("username")
                .passwordParameter("password")
            .and().httpBasic().and().csrf().disable();*/
		
		//adding logout url
		/*http.authorizeRequests()
	    .antMatchers("/login/form").hasAnyRole("ANONYMOUS", "USER")
	    .antMatchers("/**").hasRole("USER")
	    .and().formLogin()
			.loginPage("/login/form")
            .loginProcessingUrl("/processlogin")
            .failureUrl("/login/form?error")
            .usernameParameter("username")
            .passwordParameter("password")
        .and().logout()
              .logoutSuccessUrl("/login/form?logout")		
	    .and().httpBasic().and().csrf().disable();*/
		
		
		//Adding Role-based authorization
		/*http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/").hasAnyRole("ANONYMOUS", "USER")
	    .antMatchers("/login/**").hasAnyRole("ANONYMOUS", "USER")
	    .antMatchers("/admin/*").hasRole("ADMIN")
        .antMatchers("/events/").hasRole("ADMIN")
	    .antMatchers("/**").hasRole("USER")
	    .and().formLogin()
			.loginPage("/login/form")
            .loginProcessingUrl("/processlogin")
            .failureUrl("/login/form?error")
            .usernameParameter("username")
            .passwordParameter("password")
        .and().logout()
              .logoutSuccessUrl("/login/form?logout")		
	    .and().httpBasic().and().csrf().disable();*/
		
		// Leverage Spring Expression Language (SpEL) 
		/*http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/").permitAll()
	    .antMatchers("/login/**").permitAll()
	    .antMatchers("/admin/h2/**").permitAll()
        .antMatchers("/events/").hasRole("ADMIN")
	    .antMatchers("/**").hasRole("USER")
	    .and().formLogin()
			.loginPage("/login/form")
            .loginProcessingUrl("/processlogin")
            .failureUrl("/login/form?error")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/default")
            //.defaultSuccessUrl("/default", true)
        .and().logout()
              .logoutSuccessUrl("/login/form?logout")		
	    .and().httpBasic().and().csrf().disable();
		
		 // Enable <frameset> in order to use H2 web console
        http.headers().frameOptions().disable();*/
	}

} // The End...
