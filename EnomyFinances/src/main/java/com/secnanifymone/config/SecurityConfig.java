package com.secnanifymone.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.secnanifymone.auth.UserDetailsServiceImpl;





@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public UserDetailsService userDetailsService() {
       return new UserDetailsServiceImpl();
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		
		System.out.println("Configure Authentication");

		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable() // Disable CSRF protection
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
                .and()
            .authorizeRequests()
            	// Allow access to the home page, signup, signup_error, thank-you, and login
            	.antMatchers("/", "/signup", "/signup_error", "/login").permitAll()
            	.antMatchers(HttpMethod.POST, "/check-email").permitAll()
            	.antMatchers(HttpMethod.POST, "/EnomyFinances/signupprocess").permitAll()
            	.antMatchers(HttpMethod.POST, "/addExpense").permitAll()
            	.antMatchers(HttpMethod.POST, "/convert").permitAll()
            
            	
            
            	// Allow access to static resources like CSS, images, etc.
            	.antMatchers("/css/**", "/images/**", "/js/**").permitAll()
            
            	// Define access rules for other endpoints based on roles
            	.antMatchers("/admin/**").hasRole("Admin")
            	.antMatchers("/user/**").hasAnyRole("User", "Admin")
            	.antMatchers("/dashboard").hasAnyRole("User", "Admin")
            	
            
            	// All other requests must be authenticated
            	
            	.and()
            .logout()
            	.logoutSuccessUrl("/EnomyFinances/")
            	.invalidateHttpSession(true)
                .deleteCookies("SESSIONID");
        
    
    
    }
    

}
