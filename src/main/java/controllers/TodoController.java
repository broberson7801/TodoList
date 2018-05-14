package controllers;

import static util.Constants.TODO_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.TodoDAO;
import entities.Todo;
import exceptions.TodoException;
import lombok.SneakyThrows;
import util.Constants;

@RestController
@RequestMapping(value=TODO_PATH)
public class TodoController {
	
	@Autowired
	TodoDAO todoDAO;
	
	@GetMapping("todo-controller/ping")
	public String ping() {
		return "Todo Controller Pong";
	}
	
	@GetMapping("todos")
	public List<Todo> index() {
		return todoDAO.findAll();
	}
	
	@GetMapping("todos/{id}")
	@SneakyThrows(TodoException.class)
	public Todo show(@PathVariable Long id) {
		return todoDAO.findById(id).orElseThrow(() -> new TodoException(Constants.TODO_FIND_ERROR));
	}
	
	@PostMapping("create")
	public Todo create(@RequestBody Todo jsonTodo) {
		return todoDAO.save(jsonTodo);
	}
	
	@PutMapping("todos/{id}")
	@SneakyThrows(TodoException.class)
	public Todo update(@PathVariable Long id, @RequestBody Todo jsonTodo) {
		Todo todo = todoDAO.findById(id).orElseThrow(() -> new TodoException(Constants.TODO_UPDATE_ERROR));
		
		todo.setTodoName(jsonTodo.getTodoName());
		todo.setTodoDescription(jsonTodo.getTodoDescription());
		
		return todoDAO.save(todo);
	}
	
	@DeleteMapping("todos/{id}")
	@SneakyThrows(TodoException.class)
	public boolean destroy(@PathVariable Long id) {
		Todo todo = todoDAO.findById(id).orElseThrow(() -> new TodoException(Constants.TODO_DELETE_ERROR));
		
		todoDAO.delete(todo);
		return true;
	}

}
