package com.my.mall.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.mall.domain.dto.PageRequestDto;
import com.my.mall.domain.dto.TodoDto;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServiceTest {
	@Autowired private TodoService todoService;
	
	@Test
	public void getTodo() {
		log.info(todoService.getTodo(2L));
	}
	
	@Test
	public void addTodo() {
		TodoDto todoDto = TodoDto.builder()
				.title("제목")
				.writer("작성자")
				.dueDate(LocalDate.now())
				.build();
		todoService.addTodo(todoDto);
	}
	
	@Test
	public void fixTodo() {
		TodoDto todoDto = TodoDto.builder()
				.todoNo(101L)
				.title("제목.수정")
				.dueDate(LocalDate.now().plusDays(1))
				.build();
		todoService.fixTodo(todoDto);
		
		log.info(todoService.getTodo(101L));
	}
	
	@Test
	public void delTodo() {
		todoService.delTodo(101L);
	}
	
	@Test
	public void getTodos() {
		PageRequestDto request = PageRequestDto.builder()
				.page(2)
				.size(6)
				.build();
		log.info(todoService.getTodos(request));
	}
}
