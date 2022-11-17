package com.ch.nike.controller;

import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ch.nike.dto.Member;
import com.ch.nike.dto.NaverLoginProfile;
import com.ch.nike.dto.NaverLoginVo;
import com.ch.nike.service.MemberService;
import com.ch.nike.service.NaverLoginService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private JavaMailSender jms;
	@Autowired
	private BCryptPasswordEncoder bpe; //비밀번호 암호화
	@Autowired
	private NaverLoginService service;
	
	@RequestMapping("/member/emailLoginForm.do")
	public String emailLoginForm(Member member, Model model) {
		return "member/emailLoginForm";
	}

	@RequestMapping("/member/emailLogin.do")
	public String emailLogin(Member member, Model model, HttpSession session) {
		Member member2 = ms.select(member.getEmail());
		// 가입되어있을때
		if (member2 != null) { // 이미 있는 회원
			if (member2.getMemberDel().equals("Y")) { // 탈퇴한 회원
				int result = 1;
				model.addAttribute("result", result);
				return "member/emailLoginForm";
			} else { // 비번입력 후 로그인
				return "member/pwLoginForm";
			}
		} else { // 가입안되어있을때
			int vCode = (int) (Math.random() * 100000); /* 인증코드 랜덤으로 보내기 */
			session.setAttribute("vCode", vCode);
			session.setMaxInactiveInterval(60); // 60초 시간지정
			MimeMessage mm = jms.createMimeMessage();
			try {
				MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "utf-8");
				mmh.setSubject("일회용 코드를 알려드립니다");
				mmh.setText("요청하신 일회용 인증 코드는 " + vCode + "입니다.");
				mmh.setTo(member.getEmail());
				mmh.setFrom("sooin8181@naver.com");
				jms.send(mm);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				model.addAttribute("msg", "메일 인증코드 발송실패");
				return "member/emailLoginForm";
			}
			return "member/joinForm";
		}
	}

	@RequestMapping("/member/join.do")
	public String join(Member member, String tel1, String tel2, String tel3, Model model, int verifiCode, HttpSession session) {
		int result = 0;
		String memberTel = tel1 + "-" + tel2 + "-" + tel3;
		Member member2 = null;
		member.setMemberTel(memberTel);
		member2 = ms.select(member.getEmail());
		if (member2 == null) { // 가입x -> 회원가입
			if (session.getAttribute("vCode") == null) { // 인증코드 세션만료
				result = -2;
			} else {
				int vCode = (int) session.getAttribute("vCode");
				if (true) { // 사용자가 입력한 verifiCode, 메일발송한 vCode
					String encPass = bpe.encode(member.getPassword()); // 비밀번호 암호화
					member.setPassword(encPass);
					result = ms.insert(member);
				} else {
					result = -3; // 인증코드 불일치
				}
			}
		} else // 가입되어있을때
			result = -1;
		model.addAttribute("result", result);
		return "member/join";
	}

	@RequestMapping("/member/login.do")
	public String login(Member member, Model model, HttpSession session) {
		Member member2 = ms.select(member.getEmail());
		if (member2 != null) {
			if (bpe.matches(member.getPassword(),member2.getPassword())) { //(암호화된것과, 안된것)을 비교
				session.setAttribute("email", member.getEmail());
				return "redirect:/"; //redirect: (이 주소가 url로 ), forward: (/에서 요청한 주소가 url에 뜸) // ProductController의 @RequestMapping("/") 찾아감
			} else  {
				String msg = "📢비밀번호가 일치하지 않습니다";
				model.addAttribute("msg", msg);
				return "member/pwLoginForm";
			}
		} else
			return "member/emailLoginForm";
	}
	@RequestMapping("/member/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	@RequestMapping("/member/findPwForm.do")
	public String findPwForm(Member member, Model model, HttpSession session) {
		int vCode = (int) (Math.random() * 99999 - 10000 )+10000; /* 인증코드 랜덤으로 보내기(5자리) */
		session.setAttribute("vCode", vCode);
		session.setMaxInactiveInterval(60); //60초 시간지정
		MimeMessage mm = jms.createMimeMessage();
		try {
			MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "utf-8");
			mmh.setSubject("일회용 코드를 알려드립니다");
			mmh.setText("요청하신 일회용 인증 코드는 "+vCode+"입니다.");
			mmh.setTo(member.getEmail());
			mmh.setFrom("sooin8181@naver.com");
			jms.send(mm);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", "메일 인증코드 발송실패");
			
			return "member/pwLoginForm";	
		}
		return "member/findPwForm";
	}
	

	@RequestMapping("/member/pwLoginForm.do")
	public String pwLoginForm(Member member, Model model) {
		return "member/pwLoginForm";
	}
	
	
	@RequestMapping("/member/changePw.do")
	public String changePw(Member member, int verifiCode, String newPw, Model model, HttpSession session) {
		int result;
		if (session.getAttribute("vCode") == null) { // 인증코드 세션만료
			result = 0;
		} else {
			int vCode = (int) session.getAttribute("vCode");
			if (verifiCode == vCode) { // 사용자가 입력한 verifiCode, 메일발송한 vCode
				String encPass = bpe.encode(newPw); // 새비번 암호화
				member.setPassword(encPass);
				
				result = ms.changePw(member);
			} else { //인증코드 불일치
				result = -1;
			}
		}
		model.addAttribute("result", result);
		return "member/changePw";
	}
	
	
	@RequestMapping("/member/kakaoLogin.do")
	public String kakaoLogin(Member member, Model model, HttpSession session) {
		Member member2 = ms.kakaoselect(member);
		// 가입되어있을때
		if (member2 != null) { // 이미 있는 회원
			if (member2.getMemberDel().equals("Y")) { // 탈퇴한 회원
				int result = 1;
				model.addAttribute("result", result);
				return "member/emailLoginForm";
			}
		}else {
			ms.kakaoinsert(member);
			session.setAttribute("email", member.getAccount_email());
			return "redirect:/";
		}
		session.setAttribute("email", member.getAccount_email());
		return "redirect:/";
	}


    @GetMapping("/NaverLoginCallback")	// 네이버로그인 by 선희
    public String NaverLoginCallback(@RequestParam Map<String, String> resValue, HttpSession session){
        // code 를 받아오면 code 를 사용하여 access_token를 발급받는다.
        final NaverLoginVo naverLoginVo = service.requestNaverLoginAcceccToken(resValue, "authorization_code");
        // access_token를 사용하여 사용자의 고유 id값을 가져온다.
        final NaverLoginProfile naverLoginProfile = service.requestNaverLoginProfile(naverLoginVo);

        int result = 0;
        Member member = new Member();
        member.setPassword("SOCIAL");
        member.setEmail(naverLoginProfile.getEmail());
        member.setName(naverLoginProfile.getName());
        member.setMemberGender(naverLoginProfile.getGender());
        member.setMemberTel(naverLoginProfile.getMobile());
        String date = naverLoginProfile.getBirthyear()+"-"+naverLoginProfile.getBirthday();
        member.setDate(date);
        
        Member member2 = ms.select(member.getEmail());
        if (member2 == null) {
        	result = ms.insertByNaver(member);
        	if(result > 0) {
        		session.setAttribute("email", member.getEmail());
        		return "redirect:/";
        	}
        } else {
        	session.setAttribute("email", member.getEmail());
        	return "redirect:/";
        }
        return naverLoginProfile.toString();
    }
}

