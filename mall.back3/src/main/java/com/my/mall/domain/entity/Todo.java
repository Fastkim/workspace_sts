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

//테이블이름은 복수형 클래스이름은 단수형

@Entity //OR-Mapping 하는 녀석
@Table(name="todos") // 테이블이름을 이렇게 명시하지않으면 클래스이름 Todo를 따라간다.
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long todoNo;
	private String title;
	private String writer;
	private boolean done;
	private LocalDate dueDate;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}
