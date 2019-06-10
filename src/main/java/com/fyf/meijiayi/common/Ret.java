package com.fyf.meijiayi.common;



import java.io.Serializable;


public class Ret implements Serializable {


    private int code;
    private String message;
    private Object data;
    private Boolean success = true;

    public Ret(int code){
        this.code = code;
    }

    /**
     * 返回成功
     * @param isSuccess
     * @param code
     * @param data
     */
    public Ret(boolean isSuccess , int code, Object data){
        this.success = isSuccess;
        this.code = code;
        this.data = data;
    }

    /**
     * 返回失败
     * @param isSuccess
     * @param code
     * @param message
     */
    public Ret(boolean isSuccess,int code ,String message){
        this.success = isSuccess;
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
