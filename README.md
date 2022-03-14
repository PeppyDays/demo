# Demo Project for Database Migration

## Agenda

- Spring Boot 프로젝트 생성
- 로컬 환경 구축 docker compose
- JPA, QueryDSL, Flyway, MariaDB Driver 설정
- 왜 JPA, Flyway, QueryDSL 이 필요한가?
- 샘플 모델 작성
    - https://miro.com/app/board/uXjVOYAHapc=/?invite_link_id=903401227700
    - https://quip-amazon.com/r0yRAoyfbIB1/DDD-
- JpaRepository 작성
- Repository 의 Dependency inversion & injection 설명
- 데이터 입력 테스트 코드 작성
- 첫 Flyway migration
- Flyway Directory Layout 정책
- Flyway 동작 원리
    - https://flywaydb.org/documentation/getstarted/how
- Flyway 명령어
    - flyway migration
        - https://flywaydb.org/documentation/concepts/migrations
    - flyway clean
    - flyway info
    - flyway validate
    - flyway repair
- Flyway 파라미터
- Flyway migration immutable, idempotent
    - https://www.red-gate.com/hub/product-learning/flyway/creating-idempotent-ddl-scripts-for-database-migrations?utm_source=flywaynewsletter&utm_medium=email&utm_campaign=databasedevops&utm_content=idempotentddlscriptsapr21&utm_term=story1&mkt_tok=ODA4LUlURy03ODgAAAF-RO9KzXzckdlIEV3KP9QyE_r-qmpUIqQMsZ9K-GdIQokEOqjmaxwmL7x7dZjph2Zuj0yo0EPpwjRjsEstPZq1hEVi77vSXgHTz59op1fJ_Hrfow
- Flyway 버저닝 정책
    - https://www.red-gate.com/hub/product-learning/redgate-deploy/branching-and-merging-in-database-development-using-flyway
    - https://semver.org/
- Flyway 유료 vs 무료
    - https://www.red-gate.com/blog/why-would-you-pay-for-flyway?utm_source=flywaynewsletter&utm_medium=email&utm_campaign=flyway&utm_content=payforflywayjul21&utm_term=story3&mkt_tok=ODA4LUlURy03ODgAAAGAPIxUlME9Ipo-vLF1FjAPAtCVavjlx8ptNiyG2cV7lKSLKwZQavymtVzE6YM7v7W7z9N3x2P17IY1l__ZjbX52u6d9Qgpyydrbst1uFSHk2Pnig
- Flyway 롤백
- Flyway reset baseline
    - https://flywaydb.org/reset-the-baseline-migration?ref=v7.12.0
- Flyway CI/CD 적용 예시
- 동시 버전 존재에 따른 Database Refactoring
