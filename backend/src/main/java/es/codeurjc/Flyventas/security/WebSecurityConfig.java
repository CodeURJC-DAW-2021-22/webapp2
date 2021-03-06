package es.codeurjc.Flyventas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    RepositoryUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // ...
                .csrf().disable();

        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/register").permitAll();
        //http.authorizeRequests().antMatchers("/perfil").permitAll();

        // Private pages
        http.authorizeRequests().antMatchers("/confirmacionCompra/*").hasAnyRole("USER", "ADMIN");
        http.authorizeRequests().antMatchers("/confirmacionContraoferta/*").hasAnyRole("USER", "ADMIN");
        http.authorizeRequests().antMatchers("/subirProducto").hasAnyRole("USER", "ADMIN");
        http.authorizeRequests().antMatchers("/perfil/*").hasAnyRole("USER", "ADMIN");
        http.authorizeRequests().antMatchers("/perfilAdmin").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/perfilAdmin/*").hasAnyRole("ADMIN");
        //http.authorizeRequests().antMatchers("/subirProducto/*").hasAnyRole("USER");
        //http.authorizeRequests().antMatchers("/addFilm").hasAnyRole("ADMIN");
        //http.authorizeRequests().antMatchers("/menuAdmin").hasAnyRole("ADMIN");

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }
}
