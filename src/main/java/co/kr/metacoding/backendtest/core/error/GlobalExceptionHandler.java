package co.kr.metacoding.backendtest.core.error;

import co.kr.metacoding.backendtest.core.error.ex.ExceptionApi400;
import co.kr.metacoding.backendtest.core.error.ex.ExceptionApi404;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionApi400.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(ExceptionApi400 e) {
        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("reason", e.getMessage());
        return ResponseEntity.badRequest().body(errorBody); // HTTP 400
    }

    @ExceptionHandler(ExceptionApi404.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ExceptionApi404 e) {
        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("reason", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody); // HTTP 404
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoHandlerFound(NoHandlerFoundException e) {
        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("reason", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
    }

}
