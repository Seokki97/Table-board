# SpringBoot 게시판 & 스프링 시큐리티 Login


<br />

* <b> 프로젝트 기간: 2022.12.30 ~ 2023.01.7 </b>

<br />

### ☄️ 회원가입 & 로그인 & 게시판

<br />

### 🧑🏻‍💻참여 인원 👩🏻‍💻
| 이름  | 파트      | 역할              |
|-----|---------|-----------------|
| 김준석 | BACKEND | 회원가입,로그인,게시판API |
 ---




### 사용한 기술

- ☑️AWS EC2 :
    - 서버 배포를 위해 사용
- ☑️AWS RDS :
    - 데이터베이스 구축, 관리 (MYSQL)
- ☑️Spring Security :
    - 로그인 기능을 위해 사용
- ☑️Spring JPA : 
    - 관계형 데이터베이스 MAPPING

## 기능 구현목록


### 📝회원가입
| 분류   | 기능                               |   구현   |  비고  | 담당자
|------|----------------------------------| ---- | --- | ---- | 
| 회원가입 | 회원가입 시 비밀번호 암호화 및 USER 정보 DB에 저장 |  ✅ | | 준석


### 📝로그인
| 분류  | 기능        |   구현   |  비고  | 담당자
|-----|-----------| ---- | --- | ---- | 
| 로그인 | JWT 토큰 생성 |  ✅ | |준석
| 로그인 | 유효성 검증    | ✅ | 준석
| 로그아웃 | 세션 만료     | ✅ | 준석

### 📚게시판
| 분류  | 기능              |   구현   |  비고  | 담당자
|-----|-----------------| ---- | --- | ---- | 
| 게시판 | 게시글 작성          |  ✅ | |준석
| 게시판 | 게시글 전체 조회       |  ✅ | |준석
| 게시판   | 게시글 삭제          |  ✅ | |준석
| 게시판   | 게시글 단일 조회       |  ✅ | |준석
| 게시판| 게시글 수정          |  ✅ | |준석
| 게시판 | 게시글 찾기 (제목 ,내용) |  ✅ | |준석


