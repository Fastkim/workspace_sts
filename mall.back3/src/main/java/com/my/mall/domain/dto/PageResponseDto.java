package com.my.mall.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDto<E> {
	private List<E> items;
	private List<Integer> pageNums;
	private PageRequestDto request;
	private boolean prev, next;
	private int currentPage, prevPage, nextPage, totPageCnt, totItemCnt;
	
	@Builder
	public PageResponseDto(List<E> items, PageRequestDto request, long totItemCnt) { // 이 3개의 값이 있으면 페이지를 동적으로 만들수있다.
		this.items = items;
		this.request = request;
		this.totItemCnt = (int)totItemCnt;
		int end = (int)(Math.ceil(request.getPage() / 10.0)) * 10; //마지막 페이지 10개
		int start = end - 9;
		int last = (int)(Math.ceil((totItemCnt/ (double)request.getSize()))); // 마지막페이지
		end = end > last ? last : end;
		this.prev = start > 1;
		this.next = totItemCnt > end * request.getSize();
		this.pageNums = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList()); //boxed: 시작부터 끝페이지 값을 Integer타입으로 변환
		if(prev) this.prevPage = start - 1;
		if(next) this.nextPage = end + 1;
		this.totPageCnt = this.pageNums.size();
		this.currentPage = request.getPage();
	}
}
