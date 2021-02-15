package br.com.tda.sistemanotas.error;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.tda.sistemanotas.error.exception.ValorMaximoException;

@RestControllerAdvice
public class RestHandleException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ClasseError>> getErrorResponse(MethodArgumentNotValidException e) {

		List<ClasseError> errorList = new ArrayList<>();

		e.getBindingResult().getFieldErrors().forEach(er -> {
			ClasseError error = new ClasseError();

			error.setCampo(er.getField());
			error.setMenssagem(er.getDefaultMessage());

			errorList.add(error);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> getErrorResponse(EntityExistsException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> getErrorResponse(EntityNotFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> getErrorResponse(NullPointerException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> getErrorResponse(HttpMessageNotReadableException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nenhum parâmetro enviado");
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> getErrorResponse(IllegalArgumentException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(InvalidParameterException.class)
	public ResponseEntity<String> getErrorResponse(InvalidParameterException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<String> getErrorResponse(PSQLException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Por favor, verifique se os dados informados estão corretos");
	}

	@ExceptionHandler(ValorMaximoException.class)
	public ResponseEntity<String> getErrorResponse(ValorMaximoException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
