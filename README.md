# Wematch



## 환경

- SpringBoot
- MySQL
- JPA



## 실행 방법

### 직접 빌드

빌드

```
./gradlew bootJar
```

이미지 생성

```
docker build -t cde0409/wematch:v1 .
```

혹은

### 저장소에서 다운

[Dockerhub wematch 저장소](https://hub.docker.com/repository/docker/cde0409/wematch)

```
docker pull cde0409/wematch:v1
```



### 실행

Docker 네트워크 생성

```
docker network create test
```

mysql 실행

```
docker run -d --name db -e MYSQL_ROOT_PASSWORD=we -p 3306:3306 --network test mysql
```

bash로 접속

```
docker exec -it db bash
```

mysql 접속(password: we)

```
mysql -u root -p
```

DB 생성

```
create database wematch;
```

서버 실행

```
docker run -it --name app --network test -p 8080:8080 cde0409/wematch:v1
```



## 테스트

1. 프로젝트 루트에 있는 PostMan collection import 사용

   [/Wematch.postman_collection.json](./Wematch.postman_collection.json)

2. *src/test/java/com/wematch/apis/v1/ApisTests.class* 에서 Run as - Junit Test

   ```
   1. 이사업체 정보 목록 조회(등록 포함)
   _01_findAllCompanyApiTest
   2. 고객 정보 목록 조회(등록 포함)
   _02_findAllCustomerApiTest
   3. 주문 정보 목록 조회(등록 포함)
   _03_findAllOrderApiTest
   ```



## 패키지 구조

```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─wematch
│  │  │          ├─apis
│  │  │          │  ├─dto       # dto 모음
│  │  │          │  └─v1        # Api 모음
│  │  │          ├─models       # Entity 모음
│  │  │          ├─repositories # repositoriy 모음
│  │  │          ├─services     # service 모음
│  │  │          └─utils        # util 모음
│  │  └─resources
│  │      ├─static
│  │      └─templates
│  └─test
│      ├─java
│      │  └─com
│      │      └─wematch
│      │          ├─apis
│      │          │  └─v1       # Api Test 코드
│      │          └─assignment  # 과제1 코드
│      └─resources              # 과제1 로그 파일
└─WEB-INF
```















