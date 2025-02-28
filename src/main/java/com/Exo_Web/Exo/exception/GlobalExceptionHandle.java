package com.Exo_Web.Exo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {
//
//    private static final String MIN_ATTRIBUTE = "min";
//
//    @ExceptionHandler(value = RuntimeException.class)
//    ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException e) {
//
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(1001);
//        apiResponse.setMessage(e.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
//
//    @ExceptionHandler(value = AppException.class)
//    ResponseEntity<ApiResponse> handleAppException(AppException e) {
//        ErrorCode errorCode = e.getErrorCode();
//
//        ApiResponse apiResponse = new ApiResponse();
//
//        apiResponse.setCode(errorCode.getCode());
//        apiResponse.setMessage(errorCode.getMessage());
//        return ResponseEntity
//                .status(errorCode.getStatusCode())
//                .body(apiResponse);
//    }
//
//    @ExceptionHandler(value = AccessDeniedException.class)
//    ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException e) {
//        ErrorCode errorCode =  ErrorCode.UNAUTHORIZED;
//
//        return ResponseEntity.status(errorCode.getStatusCode()).body(
//                ApiResponse.builder()
//                        .code(errorCode.getCode())
//                        .message(errorCode.getMessage())
//                        .build()
//        );
//    }
//
//
//
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//
//        String enumKey = e.getFieldError().getDefaultMessage();
//        ErrorCode errorCode = ErrorCode.INVALID_KEY;
//        Map<String, Object> attribute = null;
//
//        try{
//            errorCode = ErrorCode.valueOf(enumKey);
//
//            var contrainViolation = e.getBindingResult()
//                    .getAllErrors().getFirst().unwrap(ConstraintViolation.class);
//            attribute =  contrainViolation.getConstraintDescriptor().getAttributes();
//
//            log.info("Log Attribute" +attribute.toString());
//        }catch (IllegalArgumentException ex){
//
//        }
//        ApiResponse apiResponse = new ApiResponse();
//
//        apiResponse.setCode(errorCode.getCode());
//        apiResponse.setMessage(Objects.nonNull(attribute) ?
//                mapAttibute(errorCode.getMessage(), attribute)
//                : errorCode.getMessage());
//
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
//
//    private String mapAttibute(String message ,  Map<String,Object> attribute) {
//        String minValue = String.valueOf(attribute.get(MIN_ATTRIBUTE));
//
//
//        return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
//    }
}
