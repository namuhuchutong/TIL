# 다형성

- 한 객체가 여러 타입을 갖는 것
    - 한 객체가 여러 타입의 기능을 제공
    - 타입 상속으로 다형성 구현 ( 하위 타입은 상위 타입도 됨 )

# 추상화

- 데이터나 프로세스 등을 의미가 비슷한 개념이나 의미 있는 표현으로 정의하는 과정

- 두 가지 방식으로 추상화 진행(특정한 성질, 공통 성질)

## 타입 추상화 

- 여러 구현 클래스를 대표하는 상위 타입 도출
    - 보통 인터페이스 타입으로 추상화
    - 추상화 타입과 구현은 타입 상속으로 연결
- 추상 타입은 구현을 감춤 ( 기능의 구현이 아닌 의도를 더 잘 드러냄 )

## 추상 타입의 이점

- 변경에 유연함

```java

/*
*   콘크리트 클래스를 직접 사용해 구현
*   요구 사항이 추가되면 계속 수정해야 함
*   본질과 상관없는 기능이 계속 추가됨   
*/

//-------
private SmsSender smsSender;
public void cancel(String ono){
    #do something

    smsSender.sendSms(...);
}
//-------

//-------
// 요구사항 : 카카오 푸시 추가
private SmsSender smsSender;
private KakaoPush kakaoPush
public void cancel(String ono){
    #do something

    if(pushEnabled){
        kakaoPush.push();
    } else {
        smsSender.sendSms();
    }
}
//-------

//-------
// 요구사항 : 메일 보내기 추가
private SmsSender smsSender;
private KakaoPush kakaoPush
private MailService mailSvc;
public void cancel(String ono){
    #do something

    if(pushEnabled){
        kakaoPush.push();
    } else {
        smsSender.sendSms();
    }
    mailSvc.sendmail();
}
//-------

```
## 추상화 시점

- 추상화는 의존 대상이 변경하는 시점에

- 추상화 -> 추상 타입 증가 -> 복잡도 증가
    - 아직 존재하지 않는 기능에 대한 이른 추상화는 주의
    - 실제 변경, 확장이 발생할 대 추상화 시도

## 추상화를 잘 하려면...

- 구현을 한 이유가 무엇 때문인지 생각하기