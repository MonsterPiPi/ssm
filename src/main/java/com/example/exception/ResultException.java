package com.example.exception;


import com.example.enums.ResultEnums;

public class ResultException extends RuntimeException {
    private Integer code;
    public ResultException(ResultEnums resultEnums){
        super(resultEnums.getMsg());
        this.code=resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
