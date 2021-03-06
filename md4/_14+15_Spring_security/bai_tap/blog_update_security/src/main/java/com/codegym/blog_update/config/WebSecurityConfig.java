package com.codegym.blog_update.config;

import com.codegym.blog_update.models.service.impl.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encoder...*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    /*Cấu hình security bằng HTTP basic*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
//                    .loginPage("/login")
                /*Login thanh cong se chuyen huong ve URL man hinh hien tai,
                neu truy cap truc tiep /login thi login thanh cong se chuyen huong ve /student */
                .defaultSuccessUrl("/home/view").permitAll()
                .and()
                // cho phep tat ca cac role deu duoc truy cap vao trang view
                .authorizeRequests().antMatchers("/home/view").permitAll()
                // phan quyen` cho moi trang tuong ung voi moi loai user // o day cho t co' them . hasanyrole(....,.....) -> de set nhieu role cho 1 trang
                .antMatchers("home/create").hasRole("ADMIN")
                .antMatchers("/home/update**").hasAnyRole("USER","ADMIN")
                /* Tất cả request gởi lên server đều phải thực hiện xác thực*/
                .anyRequest().authenticated();
                /* Tất cả request gởi lên server không cần thực hiện xác thực*/
//                .authorizeRequests().anyRequest().permitAll();
    }
}
