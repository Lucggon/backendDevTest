package org.backendDevTest.shared.domain;

public class DomainError extends RuntimeException{

    private final String errorCode;
    private final String errorMsg;


    public DomainError(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
