package com.fran4ssisi.boot.spring.domain.posts;

import com.fran4ssisi.boot.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스내 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동추가
@Entity //Entity클래스에서는 절대 Setter 메소드를 만들지 않는다. 필요시 목적과 의도를 나타내는 메소드를 추가한다.
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.IDENTITY 옵션을 추가해야만 autoincrement가 된다.
    private Long id;

    @Column(length = 500, nullable = false) //@Column 테이블의 칼럼,기본값 외에 추가로 변경이 필요한 옵션이 있을시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
