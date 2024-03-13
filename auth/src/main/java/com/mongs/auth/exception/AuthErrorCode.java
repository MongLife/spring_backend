package com.mongs.auth.exception;

import com.mongs.core.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCode {
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "AUTH-100", "Invalid Parameter"),
    REFRESH_TOKEN_EXPIRED(HttpStatus.NOT_ACCEPTABLE, "AUTH-101", "RefreshToken Expired"),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "AUTH-102", "AccessToken Expired"),
    ACCOUNT_NOT_FOUND(HttpStatus.BAD_REQUEST, "AUTH-103", "Not Found Account"),
    PASSPORT_GENERATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH-104", "Passport Generate Fail"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH-105", "Internal Server Error"),
    ACCOUNT_LOG_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH-106", "Not Found Account Log"),
    REGISTER_MEMBER_FAIL(HttpStatus.BAD_REQUEST, "AUTH-107", "Can't Make Member")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
