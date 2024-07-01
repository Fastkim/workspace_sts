package com.my.mall.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.mall.domain.dto.PageRequestDto;
import com.my.mall.domain.dto.PageResponseDto;
import com.my.mall.domain.dto.TodoDto;
import com.my.mall.domain.entity.Todo;
import com.my.mall.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional // insert를 여러건 했을때, 한건의 insert라도 실패했을때 전체를 멈추는 데이터원자성을 지키기위한 조치
@RequiredArgsConstructor // final 필드들을 컨테이너로 초기화하는 생성자이다.
public class TodoServiceImpl implements TodoService {
	private final ModelMapper modelMapper;
	private final TodoRepository todoRepository;
	
	@Override
	public TodoDto getTodo(Long todoNo) {
		Optional<Todo> result = todoRepository.findById(todoNo);
		Todo todo = result.orElseThrow();
		TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
		return todoDto;
	}
	
	@Override
	public void addTodo(TodoDto todoDto) {
		Todo todo = modelMapper.map(todoDto, Todo.class);
		todoRepository.save(todo);
	}
	
	@Override
	public void fixTodo(TodoDto todoDto) {
		Optional<Todo> result = todoRepository.findById(todoDto.getTodoNo());
		Todo todo = result.orElseThrow();
		
		todo.setTitle(todoDto.getTitle());
		todo.setDueDate(todoDto.getDueDate());
		todo.setDone(todoDto.isDone());
		
		todoRepository.save(todo);
	}
	
	@Override
	public void delTodo(Long todoNo) {
		todoRepository.deleteById(todoNo);
	}
	
	@Override
	public PageResponseDto<TodoDto> getTodos(PageRequestDto request) {
		Pageable pageable = PageRequest.of(
				request.getPage() - 1,
				request.getSize(), 
				Sort.by("todoNo").descending());
		Page<Todo> page = todoRepository.findAll(pageable);
		List<TodoDto> todos = page.getContent().stream()
				.map(todo -> modelMapper.map(todo, TodoDto.class))
				.collect(Collectors.toList());
		
		long totTodoCnt = page.getTotalElements(); //
		PageResponseDto<TodoDto> response = PageResponseDto.<TodoDto>builder()
				.items(todos)
				.request(request)
				.totItemCnt(totTodoCnt)
				.build();
		
		return response;
	}
}
