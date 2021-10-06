# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능
* UI 출력
  * 콘솔 출력 기능
* 사용자가 입력한 데이터 변환
  * 데이터를 배열로 변환
* 입력된 데이터 검증
  * 입력된 데이터가 숫자이고 3자리인지 확인
* 답 체크
  * 볼 or 스트라이크, 낫싱인지 체크
* 게임 시작
* 게임 종료
  * 게임 종료 명령어 입력 시 프로그램 종료
* 게임 재시작
  * 게임 재시작 명령어 입력 시 게임 재시작
* 서로 다른 임의 수 3자리 생성(1~9)
  * nextstep.utils.Randoms 클래스를 이용한 중복되징 낳는 3개의 임의 수 생성
* 게임 완료 여부 체크
* 게임데이터 초기화
* 게임힌트 생성
* controller & viewer 통신
  * event 방식