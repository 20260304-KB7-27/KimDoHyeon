package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/*
* Spring Security의 보안 설정 클래스
* */
@Configuration
@EnableWebSecurity // 필터 체인 활성화
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@RequiredArgsConstructor
@ComponentScan(basePackages = {"org.scoula.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    // 문자셋필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    /*
    * CSRF : 로그인한 사용자를 악의적인 사이트에서 몰래 요청을 보내게 하는 공격
    * */
    // 시큐리티 세팅할 공간
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF 필터 앞에다 encodingFilter를 놓겠다.
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/security/all")
                    .permitAll() // 모든 권한 접근 허용
                .antMatchers("/security/admin")
                    .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member")
                    .access("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')");

        // form 기반 로그인 활성화
        http.formLogin()
                .loginPage("/security/login") // 로그인 페이지 커스텀
                .loginProcessingUrl("/security/login") // 스프링 기본 제공 POST 요청 시 로그인 시도
                .defaultSuccessUrl("/");
        
        http.logout()
                .logoutUrl("/security/logout") // POST 요청을 보내면 로그아웃 시도
                .invalidateHttpSession(true)
                .deleteCookies("JSESSION-ID") // 삭제할 쿠키
                .logoutSuccessUrl("/security/logout"); // 로그아웃 성공하면 이동할 페이지

    }

    // 테스트용으로 메모리 상에 사용자 정보 등록
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailsService) // userDetailsService
                .passwordEncoder(passwordEncoder());

/*
        // 관리자 계정
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$aVX83j9BRxoFyX3VL4rIiuPCKJGo8i3QsohYNWTuXYmBDX1f.RRCi")
                .roles("ADMIN", "MEMBER");

        // 일반 회원
        auth.inMemoryAuthentication()
                .withUser("member")
                .password("1234")
                .roles("MEMBER");
*/

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
