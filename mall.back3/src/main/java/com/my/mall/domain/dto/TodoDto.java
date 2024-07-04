package com.my.mall.domain.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// controller와 상호작용하며 데이터를 front로 보내주기도 받기도 한다.

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
	private Long todoNo;
	private String title;
	private String writer;
	private boolean done;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") 
	private LocalDate dueDate; 
	//json을 변환해줄
	//날짜로 계산을 할 필요없다면 굳이 LocalDate가 아닌 String으로 표현해줘도 된다.
}
