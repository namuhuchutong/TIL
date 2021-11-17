# 캡슐화 연습

## 1

```java

public AuthResult authenticate(String id, String pw){
    Member mem = findOne(id);
    if(mem == null) return AuthResult.NO_MATCH;

    /*
        - Tell, Don't Ask -
    if(mem.getVerificationEmailStatus() != 2){
        return AuthResult.NO_EMAIL_VERIFIED;
    }
    */

    if(!mem.isEmailVerified()){
        return AuthResult.NO_EMAIL_VERIFIED;
    }

    if(passwordEncoder.isPasswordValid(mem.getPassword(), pw, mem.getId())){
        return AuthResult.SUCCESS;
    }
    return AuthResult.NO_MATCH;
}

public class Member {
    ...
    private int verificationEmailStatus;

    public boolean isEmailVerified() {
        return verificationEmailStatus == 2;
    }
}

```

## 2

```java

public clas Rental {
    private Movie movie;
    private int dayRented;

    /*
        - Tell, Don't Ask
    public int getFrequentRenterPoints() {
        if (movie.getPriceCode() == Movie.NEW_RELEASE && dayRented > 1)
            return 2;
        else
            return 1;
    }
    */

    public int getFrequentRenterPoints() {
        return movie.getFrequenRenterPoints(dayRented);
    }

    ...
}

public class Movie {
    public static int REGULAR = 0;
    public static int NEW_RELEASE = 1;
    private int priceCode;

    /*
    public int getPriceCode() {
        return priceCode;
    }
    */

    public int getFrequenRenterPoints(int dayRented){
        if(priceCode == NEW_RELEASE && dayRented > 1)
            return 2;
        else
            return 1;
    }

    ...
}

```

## 3

```java

// 절차지향적 코드

Timer t = new Timer();
t.startTime = System.currentTimeMillis();

...

t.stopTime = System.currentTimeMillis();
long elapsedTime = t.stopTime - t.startTime;

public class Timer {
    public long startTime;
    public long stopTime;
}

```

```java

// 수정

Timer t = new Timer();
t.start();
...
t.stop();

long time = t.elapsedTime(MILLISECOND);

public class Timer {
    private long startTime;
    private long stopTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public long elapsedTime(TimeUnit unit){
        switch(unit) {
            case MILLISECOND:
                return stopTime - startTime;
        }
    }
}


```

## 4

```java

// 변경 전

public void verifyEmail(String token) {
    Member mem = findByToken(token);
    if(mem == null) throw new BadTokenException();

    if (mem.getVerificationemailStatus() == 2) {
        throw new AlreadyVerifiedException();
    } else {
        mem.setVerificationemailStatus(2);
    }

    // 수정 사항 DB  반영
}

```

```java

// 변경 후 

public void verifyEmail(String Token) {
    Member mem = findByToken(token);
    if (mem == null)
        throw new BadTokenException();

    mem.verifyEmail();

    // 수정 사항 DB 반영
}

public class Member {
    private int verificationEmailStatus;

    public void verifyEmail(){
        if (isEmailVerified())
            throw new AlreadyVerifiedException();
        else
            this.verificationemailStatus = 2;
    }
    
    public boolean isEmailVerified() {
        return verificationEmailStatus == 2;
    }
}

```