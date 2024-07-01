package com.my.mall.domain.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto { // front-end의 react가 사용할 데이터, entity는 DB가 쓸 백단에서 쓸 데이터 서로 분리한다.
	private Long todoNo;
	private String title;
	private String writer;
	private boolean done;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate dueDate;
}
