package com.my.mall.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="todos") // 테이블 이름 설정
@Getter
@ToString
@Builder // lombok이 해당 클래스 내부에 빌더클래스,메서드를 생성해준다.
@AllArgsConstructor // 파라미터가 전부있는 생성자
@NoArgsConstructor // 파라미터가 없는 생성자
public class Todo { // hibernate(OR mapping framework)가 필드를 보고 테이블을 자동으로 생성한다.
	@Id // primary key 지정
	@GeneratedValue(strategy=GenerationType.IDENTITY) // sequence 생성
	private Long todoNo;
	private String title;
	private String writer;
	private boolean done;
	private LocalDate dueDate;
	
	public void setTitle(String title) {
		this.title = title;
	}
}
