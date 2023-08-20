package com.yang.local;

public class ResultData {

    private String status = "";
    private String message = "";
    private String data = "";

    public ResultData() {
//            super();
    }

    public ResultData(String status, String message, String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData (String data) {
        this.data = data;
    }


    public String getStatus() {
        return this.status;
    }
    public String getMessage() {
        return this.message;
    }
    public String getData() {
        return this.data;
    }

}
