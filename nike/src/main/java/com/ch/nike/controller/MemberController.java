package com.ch.nike.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Member;
import com.ch.nike.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private JavaMailSender jms;
	
//	int vCode;
	@RequestMapping("/member/emailLoginForm.do")
	public String emailLoginForm(Member member, Model model) {
		return "member/emailLoginForm";
	}

	@RequestMapping("/member/emailLogin.do")
	public String emailLogin(Member member, Model model) {
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
		} else // 가입안되어있을때
			return "member/joinForm";

	}

	@RequestMapping("/member/join.do")
	public String join(Member member, String tel1, String tel2, String tel3, Model model) {
		int result = 0;
		String memberTel = tel1 + "-" + tel2 + "-" + tel3;
		Member member2 = null;
		member.setMemberTel(memberTel);
		member2 = ms.select(member.getEmail());
		if (member2 == null) { // 가입안되어있을때
			result = ms.insert(member);
		} else // 가입되어있을때
			result = -1;
		model.addAttribute("result", result);
		return "member/join";
	}

	@RequestMapping("/member/login.do")
	public String login(Member member, Model model, HttpSession session) {
		Member member2 = ms.select(member.getEmail());
		if (member2 != null) {
			if (member2.getPassword().equals(member.getPassword())) {
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
		int vCode = (int) (Math.random() * 100000); /* 인증코드 랜덤으로 보내기 */
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
				member.setPassword(newPw); // 새비번변경 성공
				result = ms.update(member);
			} else { //인증코드 불일치
				result = -1;
			}
		}
		model.addAttribute("result", result);
		return "member/changePw";
	}
	
}
