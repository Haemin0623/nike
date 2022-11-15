package com.ch.nike.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.ch.nike.dto.NaverLoginProfile;
import com.ch.nike.dto.NaverLoginProfileResponse;
import com.ch.nike.dto.NaverLoginVo;

@Service
public class NaverLoginService {

    @Autowired
    private WebClient webClient;

    @Value("SLChQKPTdZVYH07OK_Rc")
    private String client_id;

    @Value("xc2B1cnIrn")
    private String client_secret;

    /**
     * @description Naver 로그인을 위하여 Access_tokin을 발급받음
     * @param resValue
     *          1) code: 토큰 발급용 1회용 코드
     *          2) state: CORS 를 방지하기 위한 임의의 토큰
     * @param grant_type
     *          1) 발급:'authorization_code'
     *          2) 갱신:'refresh_token'
     *          3) 삭제: 'delete'
     * @return
     */
    public NaverLoginVo requestNaverLoginAcceccToken(Map<String, String> resValue, String grant_type){
        final String uri = UriComponentsBuilder
                .fromUriString("https://nid.naver.com")
                .path("/oauth2.0/token")
                .queryParam("grant_type", grant_type)
                .queryParam("client_id", this.client_id)
                .queryParam("client_secret", this.client_secret)
                .queryParam("code", resValue.get("code"))
                .queryParam("state", resValue.get("state"))
                .queryParam("refresh_token", resValue.get("refresh_token")) // Access_token 갱신시 사용
                .build()
                .encode()
                .toUriString();

        return webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(NaverLoginVo.class)
                .block();
    }

    // ----- 프로필 API 호출 (Unique한 id 값을 가져오기 위함) -----
    public NaverLoginProfile requestNaverLoginProfile(NaverLoginVo naverLoginVo){
        final String profileUri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/nid/me")
                .build()
                .encode()
                .toUriString();

        return webClient
                .get()
                .uri(profileUri)
                .header("Authorization", "Bearer " + naverLoginVo.getAccess_token())
                .retrieve()
                .bodyToMono(NaverLoginProfileResponse.class)
                .block()
                .getResponse(); // NaverLoginProfile 은 건네준다.
    }

}