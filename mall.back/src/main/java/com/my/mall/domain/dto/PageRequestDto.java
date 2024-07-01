package com.my.mall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder // 부모의 private 필드도 자식에서 접근 가능하도록 많드는 annotation
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDto {
	@Builder.Default //필드의 기본값이 있을때 지정, page=1 값이 기본으로 들어간다.
	private int page = 1;
	
	@Builder.Default
	private int size = 5;
}
