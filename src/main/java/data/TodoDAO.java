package data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Todo;

@Repository
public interface TodoDAO extends JpaRepository<Todo, Long>{

}
