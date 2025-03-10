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

    public Object getMessage() {
        return message;
    }

    // Optionally, you can add setters if required.
}
