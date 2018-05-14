package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper=false)
@ResponseStatus(value=HttpStatus.I_AM_A_TEAPOT)
public class TodoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NonNull
	private String message;
	
}
