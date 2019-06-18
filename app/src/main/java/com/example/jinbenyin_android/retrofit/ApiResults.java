package com.example.jinbenyin_android.retrofit;

public class ApiResults<T> {

    private String code;

    private String message;

    private T result;

    public ApiResults() {

    }

    public ApiResults(String code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.result = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}

