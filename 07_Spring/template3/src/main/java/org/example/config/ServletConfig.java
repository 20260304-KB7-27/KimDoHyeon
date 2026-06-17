package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// @Controller 인식 / @RequestMapping, @GetMapping
// @ViewResolver 설정
@EnableWebMvc // Spring MVC 기능 활성화 -> 모든 요청이 Dispatcher Servlet을 거치게 됨.
@ComponentScan(basePackages = {
        "org.example.exception",
        "org.example.controller",
        "org.example.service"
}) // Spring MVC용 컴포넌트 등록을 위한 스캔 패키지
public class ServletConfig implements WebMvcConfigurer {

    // 정적 리소스(이미지 css, js, 등)은 컨트롤러에서 처리하지 않기 위함.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")     // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/");    // webapp/resources/경로로 매핑
    }

    // jsp 쓰기위한 view resolver 설정
    // -> 컨트롤러가 return한 view 이름을 실제 JSP 파일 경로로 변환해주는 역할
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);
    }

    //Servlet 3.0 파일 업로드 사용시
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return resolver;
    }


}
