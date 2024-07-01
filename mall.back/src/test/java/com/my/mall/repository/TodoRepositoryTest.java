package com.my.mall.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.my.mall.domain.entity.Todo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class TodoRepositoryTest {
	@Autowired private TodoRepository todoRepository; //interface만 만들어주면 JPA가 TodoRepository의 객체를 다 만들어준다.
	
	@Test
	public void insertTodo() { //테스트하고싶은 메서드이름에만 커서찍고 F4누르면 테스트실행(JUnit), 녹색줄나오면 pass, 빨간줄은 에러
		for(int i = 1; i <= 100; i++) {
			Todo todo = Todo.builder() // builder 패턴 chaining
					.title("title " + i)
					.dueDate(LocalDate.now().plusDays(i))
					.writer("writer " + i)
					.build();
			todoRepository.save(todo);
		}
	}
	
	@Test
	public void selectTodo() {
		Long todoNo = 1L;
		Optional<Todo> result = todoRepository.findById(todoNo);
		Todo todo = result.orElseThrow();
		log.info(todo);
	}
	
	@Test
	public void updateTodo() {
		Long todoNo = 1L; // 같은 이름이 있네 그럼 업데이트 한다.
		Optional<Todo> result = todoRepository.findById(todoNo);
		Todo todo = result.orElseThrow();
		
		todo.setTitle("제목 1");
		todo.setDone(true);
		todo.setDueDate(LocalDate.now());
		
		todoRepository.save(todo);
	}
	
	@Test
	public void deleteTodo() {
		Long todoNo = 1L;
		todoRepository.deleteById(todoNo);
	}
	
	@Test
	public void selectTodos() { //react에서 page,size 넘겨줄때 이걸 이용하면된다.
		// 아래 코드를 분석하면, 1페이지에서 5개의 아이템을 내림차순으로 가져온다.
		Pageable pageable = PageRequest.of(0, 5, Sort.by("todoNo").descending()); // 1페이지 index는 0부터 시작, (pageIndex, 보여줄아이템의 수, 정렬)
		Page<Todo> page = todoRepository.findAll(pageable); //todo를 1개 가져올때는 findById,2개 이상은 findAll
		log.info("Total: " + page.getTotalElements()); //page 내부의 element 몇개있는지 보여줘
		page.getContent().stream().forEach(todo -> log.info(todo));
	}
}
