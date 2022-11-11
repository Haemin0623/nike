package com.ch.nike.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.ch.nike.service.SessionChk;


@Configuration
public class WebSecurityConfiguration {
	// 암호화
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// sessionChk - session에 이메일 없어도 되는 페이지는 exclude에 추가
	public void addInterceptors(InterceptorRegistry registory) {
		registory.addInterceptor(new SessionChk())
			.excludePathPatterns("/**/email.do","/**/emailLoginForm.do","/**/join.do",
				"/**/loginForm.do","/**/joinForm.do")
			.addPathPatterns("/**/*.do");
	}

}
