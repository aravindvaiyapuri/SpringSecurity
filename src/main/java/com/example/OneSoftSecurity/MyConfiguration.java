package com.example.OneSoftSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
@Configuration
public class MyConfiguration  extends WebSecurityConfigurerAdapter{
     
//      @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.inMemoryAuthentication().withUser("aravind").password("$2a$10$zQRf7fmMY8.SD9qcQ/sguORiKYH.zUgIQxEOELrS5oK2pKsmXxrmO").roles("trainer");
//    }
////      @Bean
////      public PasswordEncoder getPass() {
////    	  return NoOpPasswordEncoder.getInstance();
////      }
//        @Bean
//        public  PasswordEncoder getPass() {
//        	return new  BCryptPasswordEncoder(10);
//        }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("aravind").password("$2a$10$zQRf7fmMY8.SD9qcQ/sguORiKYH.zUgIQxEOELrS5oK2pKsmXxrmO").roles("get").and().withUser("arun").password("$2a$10$HzfnCIgWqgKVYeXgG8TXhOAvx36RH/USEc.KhJuthSaTuq0IDNS2S").roles("trainer").and().withUser("Anto").password("$2a$10$ss0CfYYG595NX08wsbSsA.cgkGJWLKZXCQRXvhI8v5ZDjgV/GBRgu").roles("manager");

	}
	@Bean
	public PasswordEncoder getPass() {
		return new BCryptPasswordEncoder(10);
	}
	@Override
		protected void configure(HttpSecurity http) throws Exception {
		   http.authorizeRequests().antMatchers("/manager").hasRole("manager");
		   http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer","manager");
		   http.authorizeRequests().antMatchers("/get").permitAll().and().formLogin();
		}
}
