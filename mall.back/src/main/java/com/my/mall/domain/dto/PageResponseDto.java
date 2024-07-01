package com.my.mall.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDto<E> {
	private List<E> items;
	private List<Integer> pageNums; //page의 총개수 1페이지 5개, 총 5페이지면 25개
	private PageRequestDto request;
	private boolean prev, next;
	private int currentPage, prevPage, nextPage, totPageCnt, totItemCnt;
	
	@Builder() //메서드위에 쓰면 우리가만든 메서드를 builder 메서드로 쓰는것.
	public PageResponseDto(List<E> items, PageRequestDto request, long totItemCnt) {
		this.items = items;
		this.request = request;
		this.totItemCnt = (int)totItemCnt;
		int end = (int)(Math.ceil(request.getPage() / 10.0)) * 10; // page의 시작과 끝값 구하기, end = 10페이지
		int start = end - 9; //start = 1페이지
		int last = (int)(Math.ceil((totItemCnt / (double)request.getSize())));
		end = end > last ? last : end;
		this.prev = start > 1; // 1페이지가 아니라면 이전페이지가 모두 있다.
		this.next = totItemCnt > end * request.getSize();
		this.pageNums = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
		if(prev) this.prevPage = start - 1;
		if(next) this.nextPage = end + 1;
		this.totPageCnt = this.pageNums.size();
		this.currentPage = request.getPage();
	}
}
