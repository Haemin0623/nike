# nike
Spring project
2022/10/24 ~ 2022/11/18


## 개요
![image](https://user-images.githubusercontent.com/112607474/204289075-6cf87125-189a-498c-9dec-e098c9e6443c.png)
의류 브랜드 '나이키'의 공식사이트를 최대한 유사하게 구현하는 프로젝트 입니다.  
이 프로젝트는 MVC패턴을 이용하여 기본적인 웹개발의 시작을 배우기위해 시작했습니다.  


## 개발환경
![image](https://user-images.githubusercontent.com/112607474/204293555-4a3517a5-2b5b-4bb7-8f16-66b47481da86.png)
JAVA를 기반으로 Spring framework (springboot)를 사용하여 개발을 진행했습니다.  
DATABASE는 ORACLE RDBMS를 사용했고 MyBatis를 사용해 SQL쿼리를 작업했습니다.  
HTML5와 템플릿엔진으로 Thymeleaf를 사용했고,  
화면구성은 nicepage라는 프로그램을 사용하여 작업했습니다.  
추가로 git을 사용해 형상관리를 했고 GitHub를 통해 협업을 진행했습니다.  


## 팀
![image](https://user-images.githubusercontent.com/112607474/204295490-8b16219e-47fd-4b71-a59c-904dc67d6afc.png)
이번 프로젝트에서 팀원들의 작업을 도와주며 관리 / 감독하는 역할을 맡았습니다.  
프로젝트를 잘 마무리하는 것도 중요하지만, (부끄럽지만) 제 실력이 다른 팀원들보다 조금 낫다고 생각을 했고 같이 공부하는 입장에서 모든 팀원들이 같이 성장하면 좋겠다고 생각하여 코드 작성 조언, 에러 해결을 도와 주는 등 프로젝트의 전체적인 관리를 맡았습니다.   


## ERD
![erd물리](https://user-images.githubusercontent.com/112607474/204297003-b240155f-2678-4533-b462-2e2601c4a2ce.png)
DB구성을 요약한 ERD 입니다.  
'나이키' 공식 사이트를 둘러보며 기능을 제대로 구현하기 위해 필요하다고 생각되는 테이블들을 작성했습니다.  


## 주요 화면 구성
#### 메인화면
![image](https://user-images.githubusercontent.com/112607474/204299476-ef5d5fa9-5607-4e2a-b3e4-d2e02adc1453.png)

#### 로그인
![image](https://user-images.githubusercontent.com/112607474/204300159-51b0a83c-0e71-4775-a3a9-055b4b65da6f.png)
네이버와 카카오에서 제공하는 oAuth api를 이용한 소셜로그인/가입 이 가능하며,  
이메일 입력시 입력한 메일로 인증번호를 보내서 검증하는 단계를 거치며,  
입력한 비밀번호는 BCryptPasswordEncoder를 이용해 해시화 하여 DB에 저장합니다.  

#### 상품리스트
![image](https://user-images.githubusercontent.com/112607474/204301303-700ad8d6-8686-49a1-9949-499ef657321b.png)
메뉴를 통해 상품 페이지로 이동하면 해당 메뉴에 해당하는 상품리스트를 보여줍니다.  
그리고 필터검색을 통하여 원하는 조건의 상품만 조회할 수 도 있습니다.  

#### 지도
![image](https://user-images.githubusercontent.com/112607474/204422513-7a1f1909-9f0d-440b-8547-966b47247207.png)
카카오 맵 api를 이용하여 오프라인 매장 찾기를 구현했습니다.  

#### 상품구매
![image](https://user-images.githubusercontent.com/112607474/204302097-0d9bdafc-650a-42c7-8f20-b8031a383619.png)
장바구니에 담은 상품으로 결제를 진행할 수 있으며, 카카오결제 api를 이용하여 결제시스템을 구현했습니다.  
  
그외에 리뷰(사진파일 업로드), 개인정보 수정, 관리자페이지를 통한 상품 추가 및 DB관리를 구현했습니다.  
