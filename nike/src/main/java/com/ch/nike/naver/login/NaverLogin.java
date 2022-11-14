package com.ch.nike.naver.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ch.nike.dto.Member;
import com.ch.nike.naver.login.vo.NaverLoginProfile;
import com.ch.nike.naver.login.vo.NaverLoginVo;
import com.ch.nike.service.MemberService;

@Controller
public class NaverLogin {

    @Autowired
    private NaverLoginService service;
    @Autowired
    private MemberService ms;


    @GetMapping("/NaverLoginCallback")
    public String NaverLoginCallback(@RequestParam Map<String, String> resValue, HttpSession session){
    	
        // code 를 받아오면 code 를 사용하여 access_token를 발급받는다.
        final NaverLoginVo naverLoginVo = service.requestNaverLoginAcceccToken(resValue, "authorization_code");

        // access_token를 사용하여 사용자의 고유 id값을 가져온다.
        final NaverLoginProfile naverLoginProfile = service.requestNaverLoginProfile(naverLoginVo);
        
        

        int result = 0;
        String date = naverLoginProfile.getBirthyear()+"-"+naverLoginProfile.getBirthday();
        Member member = new Member();
        member.setPassword(naverLoginProfile.getId());
        member.setEmail(naverLoginProfile.getEmail());
        member.setName(naverLoginProfile.getName());
        member.setMemberGender(naverLoginProfile.getGender());
        member.setMemberTel(naverLoginProfile.getMobile());
        member.setDate(date);
        
        Member member2 = ms.select(member.getEmail());
        if (member2 == null) {
        	result = ms.insertByNaver(member);
        	if(result > 0) {
        		session.setAttribute("email", member.getEmail());
        		return "redirect:/";
        	}
        } else {
        	return "redirect:/";
        }
        
        
         return naverLoginProfile.toString();
    }

}