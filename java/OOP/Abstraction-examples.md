# 추상화 예제

- 기능 예시
    - 클라우드 파일 통합 관리 기능 개발
    - 대상 클라우드 : 드롭박스, 박스
    - 주요 기능 : 각 클라우드의 파일 목록 조회, 다운로드, 업로드, 삭제, 검색

## 추상화하지 않은 구현
### 파일 목록 조회

```java

public enum CloudId {
    DROPBOX,
    BOX;
}

public class FileInfo {
    private CloudId cloudId;
    private String fileId;
    private String name;
    private long length;

    // ... get 메서드
}

public class CloudFilemanager {
    public List<FileInfo> getFileInfos(CloudId cloudId) {
        if(cloudId == CloudId.DROPBOX) {
            DropboxClient dc = ...;
            List<DbFile> dbFiles = db.getFiles();
            List<FileInfo> result = new ArrayList<>();
            for (DbFile dbFile : dbFiles){
                FileInfo fi = new FileInfo();
                fi.setCloudId(Cloud.DROPBOX);
                fi.setFileId(fi.getFileId());
                ...
                result.add(fi);
            }
            return result;
        } else if (cloudId == CloudId.BOX) {
            BoxService boxSvc = ...;
            ...
        }
    }
}

```
### 파일 다운로드

```java

public void download(FileInfo file, File localTarget) {
    if (file.getCloudId() == CloudId.DROPBOX) {
        DropboxClient dc = ...;
        FileOutputStream out = new FileOutputStream(localTarget);
        dc.copy(file.getFileId(), out);
        out.close();
    } else if (file.getCloudId() == CloudId.BOX) {
        BoxService boxSvc = ...;
        InputStream is = boxSvc.getInputStream(file.getId());
        FileOutputStream out = new FileOutputStream(localTarget);
        CopyUtil.copy(is, out);
    }
}

```

- 그 외 기능 구현 : 전부 if, else 기능이 들어감

- 반응이 좋아서 다른 기능을 추가하기로 함
    - if, else if, else if, else if ...

### 클라우드 간 복사

```java

if (to == CloudId.DROPBOX) {
    if (from == CloudId.NBOX) {

    } else if (...) {

    } else if (...) {

    } else

    ...
} else if ( ... ) {
    ...
} else if ( ... ) {
    ...
}

```
- 계속 else if 추가

### 개발 시간 증가 이유

- 코드 구조가 길어지고 복잡해짐
    - 새로운 클라우드 추가 시 모든 메서드에 새로운 if 블록 추가

- 관련 코드가 여러 곳에 분산됨
    - 한 클라우드 처리와 관련된 코드가 여러 메서드에 흩어짐

- 결과적으로 코드 가독성과 분석 속도 저하
    - 코드 추가에 따른 노동 시간 증가
    - 실수하기 쉽고 이로 인한 불필요한 디버깅 시간 증가

