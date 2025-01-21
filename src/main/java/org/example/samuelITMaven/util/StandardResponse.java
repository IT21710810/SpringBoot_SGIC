package org.example.samuelITMaven.util;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StandardResponse {
    private int statusCode;
    private String statusMessage;
    private Object message;

    // Constructor
    public StandardResponse(int statusCode, String statusMessage, Object message) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
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
