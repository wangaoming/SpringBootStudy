package com.example.spring.security.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//安全信息加密
@Configuration
public class SecuityConfig extends WebSecurityConfigurerAdapter {
    @Bean
//   明码的比对
    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();//密码不加密
        return new BCryptPasswordEncoder();//密码加密
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //使用内存进行身份验证
        auth.inMemoryAuthentication()
                //配置用户名、密码、角色
                .withUser("admin").password("$2a$10$u.C/3H3djMjLcjdZoO/.t.y49zrImptjvxHsaA6.ovlaLXzfPsxKe").roles("admin")
                .and()
                .withUser("user").password("$2a$10$pjeeg5mIRhiYNN4jSSUHXuqhHvUgAzIiWWpZMoZBdu0Hb.gwp/IKC").roles("user");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //开启配置
                .antMatchers("/admin/**").hasRole("admin") //配置urL路径和角色
                .antMatchers("/user/**").hasAnyRole("admin", "user")
                .anyRequest().authenticated() // 其它请求登灵之后都能访问
                .and()
                .formLogin() //表单登录
                .loginProcessingUrl("/doLogin") // 处理登灵请求B9rl地址,默认是/login
                .usernameParameter("username") // 登灵用户名的参数字符串
                .passwordParameter("password") // 登录密码的参数字符串
                .successHandler(new AuthenticationSuccessHandler() {//前后端分离 登录验证成功返回值
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Authentication authentication)
                            throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Map<Object,Object> map = new HashMap<>();
                        map.put("status",200);
                        map.put("msg",authentication.getPrincipal());
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler(){
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        AuthenticationException e)
                                                    throws IOException,ServletException{
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Map<Object,Object> map = new HashMap<>();
                        map.put("status",401);
                      if (e instanceof LockedException){
                          map.put("msg","账户被锁定，登录失败");
                      } else if (e instanceof BadCredentialsException){
                          map.put("msg","用户名或密码错误，登录失败");
                      } else if (e instanceof DisabledException){
                          map.put("msg","账户被禁用，登录失败");
                      } else if (e instanceof AccountExpiredException){
                          map.put("msg","账户过期，登录失败");
                      } else if (e instanceof CredentialsExpiredException){
                          map.put("msg","密码过期，登录失败");
                      } else {
                          map.put("msg","未知错误");
                      }

                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll() //与登录相关的请求直接通过
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request,
                                                HttpServletResponse response,
                                                Authentication authentication)
                            throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Map<Object,Object>map = new HashMap<>();
                        map.put("status",200);
                        map.put("msg","注销成功");
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .and()
                .csrf().disable(); // 关闭院srf攻击, 用开ostman测试
    }


}
