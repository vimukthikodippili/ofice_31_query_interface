package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.advisor;


import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.exception.ValidateException;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse> handleException(Exception e) {
        return new ResponseEntity<StandardResponse>(new StandardResponse(500, "Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return new ResponseEntity(new StandardResponse(404, "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException e) {
        return new ResponseEntity(new StandardResponse(400, "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler({EntryDuplicateException.class})
//    public ResponseEntity duplicateExceptionHandler(EntryDuplicateException e){
//        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(404, "Entries Duplicate Exception",
//                        e.getMessage()), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({EntryNotFoundException.class})
//    public ResponseEntity notFoundExceptionHandler(EntryNotFoundException e){
//        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(404, "Entries Not Found Exception", e.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({ConstraintViolationException.class})
//    protected ResponseEntity apiValidationHandler(ConstraintViolationException e){
//        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(400, "Validation Exception", e.getMessage()),
//                HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
//        Map<String,String> errors = new HashMap<>();
//        e.getBindingResult().getAllErrors().forEach((error) ->{
//            errors.put(
//                    ((FieldError) error).getField(),
//                    error.getDefaultMessage()
//            );
//        });
//        return new ResponseEntity(
//                new StandardResponse(400, "Validation Exception", errors),
//                HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler({Exception.class})
//    protected ResponseEntity globalExceptionHandler(Throwable e){
//        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(500, "Server Error", e.getMessage()),
//                HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler({UsernameNotFoundException.class})
//    protected ResponseEntity usernameNotFoundExceptionHandler(UsernameNotFoundException e){
//        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(404, "Username Not Found", e.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler({SecurityException.class})
//    public ResponseEntity servletException(SecurityException e){
//        LoggerHandler.handleLogger(new StandardLogger("error",e.getMessage()));
//        return new ResponseEntity(
//                new StandardResponse(401, "Authorization not valid", e.getMessage()),
//                HttpStatus.BAD_REQUEST);
//    }

}
