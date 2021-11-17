# 캡슐화

- 데이터 + 관련 기능 묶기

- 객체가 기능을 어떻게 구현했는지 외부에 감추는 것 (구현에 사용된 데이터의 상세 내용을 
외부에 감춤)

- 정보 은닉

- 외부에 영향 없이 객체 내부 구현 변경 가능

## 캡슐화를 하지 않으면..

- 요구 사항의 변화 발생 (데이터 구조/사용에 변화를 발생시킴) -> 데이터를 사용하는 코드의 수정 발생

- ex) 장기 사용자에게 특정 기능 실행 권한을 연장

- ex) 계정을 차단하면 모든 실행 권한 없음

- ex) Date를 LocalDateTime으로 변경

## 캡슐화를 하면...

- 기능을 제공하고 구현 상세를 감춤
```java

# 변경 전

if(acc.hasRegularPermission()) {
    #do something
}

public class Account {
    private Memership membership;
    private Date expDate;

    public boolean hasRegularPermission() {
        return membership == REGULAR && expDate.isAfter(now())
    }
}
```

- 내부 구현만 변경

```java

# 변경후 

if(acc.hasRegularPermission()) {
    #do something
}

public class Account {
    public boolean hasRegularPermission() {
        return membership == REGULAR &&
            ( expDate.isAfter(now()) ||
                (
                    serviceDate.isBefore(fiveYearAgo()) &&
                    addMonth(expDate).isAfter(now())
                )
            );
    }
}

```

- 캡슐화는 연쇄적인 변경 전파를 최소화

## 캡슐화와 기능

- 캡슐화 시도 -> 기능에 대한 의도, 이해를 높임

```java
# 캡술화 전
if(acc.getMembership() == REGULAR){
    #do something
    /*
        멤버십이 REGULAR와 같은지 검사하는 이유는?
        계정이 REGULAR 권한을 가졌는지 확인하기 위함.
    */
}
# 캡슐화 후
if(acc.hasRegularPermission()){
    #do something
}

public class Account{
    public boolean hasRegularPermission() {

    }
}
```

## 캡슐화를 규칙

- Tell, Don't Ask : 데이터를 달라고 하지 말기. 해달라고 하기
```java
# not good
if(acc.getMembership() == REGULAR){
    #do something
}
# good
if(acc.hasRegularPermission()){
    #do something
}

```

- Demeter's Law
    - 메서드에서 생성한 객체의 메서드만 호출
    - 파라미터로 받은 객체의 메서드만 호출
    - 필드로 참조하는 객체의 메서드만 호출
```java
# 변경 전
acc.getExpDate().isAfter(now)
Date date = acc.getExpDate();
date.isAfter(now);

# 변경 후
acc.isExpired();
acc.isValid();

```