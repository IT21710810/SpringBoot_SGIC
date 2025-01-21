package org.example.samuelITMaven.util;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StandardResponse {
    private int statusCode;
    private String statusMessage;
    private Object message;

    public StandardResponse(int code, String message, Object data) {
        this.statusCode = code;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
