# 구현 목록
#### 가입
- [x] GET /member/join : 가입 폼
- [x] POST /member/join : 가입 폼 처리

#### 로그인
- [x] GET /member/login : 로그인 폼
- [x] POST /member/login : 로그인 폼 처리

#### 로그아웃
- [x] POST /member/logout : 로그아웃

#### 홈
- [x] GET / : 홈
  (최신글 30개 노출)

#### 글 목록 조회
- [x] GET /post/list : 전체 글 리스트
- [x] \+ 공개된 글만 노출

#### 내 글 목록 조회
- [x] GET /post/myList : 내 글 리스트

#### 글 상세내용 조회
- [x] GET /post/1 : 1번 글 상세보기

#### 글 작성
- [x] GET /post/write : 글 작성 폼
- [x] POST /post/write : 글 작성 처리

#### 글 수정
- [x] GET /post/1/modify : 1번 글 수정 폼
- [x] PUT /post/1/modify : 1번 글 수정 폼 처리

#### 글 삭제
- [x] DELETE /post/1/delete : 1번 글 삭제

#### 특정 회원의 글 모아보기
- [x] GET /b/user1 : 회원 user1 의 전체 글 리스트
- [x] GET /b/user1/3 : 회원 user1 의 글 중에서 3번글 상세보기

---

#### Member 클래스에 private boolean isPaid 필드를 추가
- 해당 필드가 `true` 인 사람이 로그인할 때, `ROLE_PAID` 권한도 가지도록 (스프링 시큐리티)
- 해당 필드가 `true` 이면 유료 멤버십 회원 입니다.
- [ ] 완료

#### Post 클래스에 private boolean isPaid 필드를 추가
- 해당 필드가 `true` 인 글은 유료회원이 아닌 사람에게는 상세보기(GET /post/1)에서 본문(content)이 나올 자리에 `이 글은 유료멤버십전용 입니다.` 라는 문구가 나온다.
- [ ] 완료

#### NotProd 에서 유료멤버십 회원(샘플 데이터)과 유료글(샘플 데이터)을 각각 100개 이상 생성
- [ ] 완료