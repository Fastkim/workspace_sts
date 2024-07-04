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
@Transactional //Service의 메서드를 하나를 실행할때 업데이트 하나성공했더라도 두번째 업데이트 실패하면 이전 성공한 업데이트를 rollback한다.
@RequiredArgsConstructor   // 즉 메서드하나를 transaction으로 보는것이고, 메서드하나에 sql문이 하나이면 안써도 되고 두개이상이면 써야합니다.
public class TodoServiceImpl implements TodoService {
	// DI의 세번째방법: final의 경우는 변수가 탄생하자마자 원하는값으로 고정할당해야한다, 즉 무의미한 초기값 불가능
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
		Todo todo = result.orElseThrow(); //NoSearchElement 발생하면 여기서 멈추고 아니면 todo가 return
		
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
				request.getPage() -1,
				request.getSize(),
				Sort.by("todoNo").descending());
		
		Page<Todo> page = todoRepository.findAll(pageable);
		List<TodoDto> todoDtos = page.getContent().stream()
				.map(todo -> modelMapper.map(todo, TodoDto.class)) //entity들을 dto로 만든다.
				.collect(Collectors.toList());
		
		PageResponseDto<TodoDto> response = PageResponseDto.<TodoDto>builder()
				.items(todoDtos)
				.request(request)
				.totItemCnt(page.getTotalElements())
				.build();
		
		return response;
	}
}
