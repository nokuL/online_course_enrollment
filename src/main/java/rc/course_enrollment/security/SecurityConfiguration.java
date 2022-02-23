package rc.course_enrollment.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import rc.course_enrollment.db.UserRepository;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "rc.course_enrollment.security")
@ComponentScan(basePackages = "rc.course_enrollment.db")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    UserRepository userRepository;
     UserPrincipalDetailsService userPrincipalDetailsService;

    public SecurityConfiguration(UserRepository userRepository, UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userRepository = userRepository;
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // remove csrf and state in session because in jwt we do not need them
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // add jwt filters (1. authentication, 2. authorization)
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository))
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/public/registration").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/api/public/admin/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/public/delete/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/public/admin-only").hasAuthority("ROLE_ADMIN")
                .antMatchers("api/public/course/newCourse").hasAuthority("ROLE_ADMIN")
                .antMatchers("api/public/course/create-course").hasAuthority("ROLE_ADMIN")
                .antMatchers("api/public/course/edit-course").hasAuthority("ROLE_ADMIN")
                .antMatchers("api/public/course/delete/*").hasAuthority("ROLE_ADMIN")





                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
