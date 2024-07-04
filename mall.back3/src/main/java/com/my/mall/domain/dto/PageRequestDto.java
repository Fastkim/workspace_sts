package com.my.mall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder // super(부모) 생성자의 builder까지 내가 설정하겠다는 의미
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDto {
	@Builder.Default
	private int page = 1;
	
	@Builder.Default
	private int size = 5; //size는 팀내에서 정해서 설정
}
