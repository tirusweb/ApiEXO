package com.Exo_Web.Exo.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    EMPLOYEE_EXISTED(1001, "Employee already existed" , HttpStatus.INTERNAL_SERVER_ERROR ),
    EMPLOYEE_NOT_EXISTED(1005, "Employee not existed" , HttpStatus.NOT_FOUND ),
    UNAUTHENTICATED(1006, "Unauthenticated" , HttpStatus.UNAUTHORIZED ),
    UNAUTHORIZED(1007, "You to not have permission" , HttpStatus.FORBIDDEN ),
    INVALID_DOB(1008, "Your age must be at least {min}" , HttpStatus.BAD_REQUEST ),
    INVALID_KEY(1004, "Key is invalid" , HttpStatus.BAD_REQUEST ),


    ;
    private int code;
    private String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message , HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

}
