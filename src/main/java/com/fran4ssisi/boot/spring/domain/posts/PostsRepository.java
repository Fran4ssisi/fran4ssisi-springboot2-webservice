package com.fran4ssisi.boot.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JapRepository<Entity클래스, Pk 타입>를 사용하면 기본적 CRUD 메소드가 자동으로 생성된다.
//@Repository를 추가할 필요도 없다. 대신 Entity클래스와 기본 Entity Repository는 함께 위치해야한다
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
