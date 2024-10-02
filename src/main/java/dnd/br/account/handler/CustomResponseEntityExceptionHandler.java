package dnd.br.account.handler;

import dnd.br.account.exeptions.InvalidJwtAuthenticationException;
import dnd.br.account.exeptions.NotFoundExeption;
import dnd.br.account.exeptions.ExceptionResponse;
import dnd.br.account.exeptions.RequiredObjectIsNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundExeption.class)
    final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
            Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RequiredObjectIsNullException.class)
    final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
            Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(
            Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(Exception.class)
    final ResponseEntity<ExceptionResponse> handleAllException(
            Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
