# 상속과 재사용

## 상속을 통한 재사용
- 상위 클래스의 기능을 재사용, 확장하는 방법으로 활용

- 상위 클래스 변경 어려움
    - 변경 여파가 계층도를 따라 전파됨
- 클래스 증가

- 상속 오용
    - 상위 클래스와 메서드가 중복될 경우, 잘못 사용할 수 있음


## 조립

- 여러 객체를 묶어서 더 복잡한 기능을 제공

- 보통 필드로 다른 객체를 참조하는 방식으로 조립 or 객체를 필요 시점에 생성
```java

public class FlowController {
    private Encryptor encryptor = new Encryptor();

    public void process() {
        ...
        byte[] encryptedDate = encryptor.encrypt(data);
        ...
    }
}

```

- Composition over inheritance
     - 상속하기에 앞서 조립으로 풀 수 없는지 검토
     - 진짜 하위 타입인 경우에만 상속 사용


