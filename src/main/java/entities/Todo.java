package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="TODO")
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TODO_NAME")
	@NotNull(message="{todo.name.empty}")
	private String todoName;

	@Column(name="TODO_DESCRIPTION")
	@NotNull(message="{todo.description.empty}")
	private String todoDescription;

	
	public Todo(String todoName, String todoDescription) {
		this.todoName = todoName;
		this.todoDescription = todoDescription;
	}

}
