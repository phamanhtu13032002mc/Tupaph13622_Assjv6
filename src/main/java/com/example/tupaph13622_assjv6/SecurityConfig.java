package com.example.tupaph13622_assjv6;
import com.example.tupaph13622_assjv6.respository.AccountRepository;
import com.example.tupaph13622_assjv6.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountRepository adao;
    @Autowired
    HttpSession session;
    @Autowired
    BCryptPasswordEncoder pe;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Account user = adao.findById(username).get();
                String password = pe.encode(user.getPassword());
                session.setAttribute("img", user.getPhoto());
                String[] roles = user.getAuthorities().stream()
                        .map(er -> er.getRole().getId())
                        .collect(Collectors.toList()).toArray(new String[0]);
                return User.withUsername(username).password(password).roles(roles).build();
            }catch (NoSuchElementException e){
                throw new UsernameNotFoundException(username + "not found");
            }

        });

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().disable();


        http.authorizeRequests()
                .antMatchers("/order/**").authenticated() //bắt đăng nhập
                .antMatchers("/admin/**").hasAnyRole("nhanvien", "quanly")
                .antMatchers("/rest/authorities").hasRole("quanly")
                .anyRequest().permitAll();



        http.formLogin()
                .loginPage("/security/login/form")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/security/login/success", false)// đn thàng công chuyển về trang này
                .failureUrl("/security/login/error");// đn sai về trang này

        http.rememberMe()
                .tokenValiditySeconds(86400);// ghi nhớ tài khoản


        http.exceptionHandling()
                .accessDeniedPage("/security/unauthoried");

        http.logout().logoutUrl("/security/logoff")
                .logoutSuccessUrl("/security/logoff/success");
        // OAuth2 - Đăng nhập từ mạng xã hội
//        http.oauth2Login()
//                .loginPage("/security/login/from")
//                .defaultSuccessUrl("/oauth2/login/success", true)
//                .failureUrl("/security/login/error")
//                .authorizationEndpoint()
//                .baseUri("/oauth2/authorization");
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }


}