package com.chemco.hrms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class HttpResponse {

    private static final String TIME_ZONE = "Asia/Jakarta";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = TIME_ZONE)
    private Date timeStamp;
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;

    public HttpResponse() {}

    public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
        this.timeStamp = new Date();
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }

    public Date getTimeStamp() { return timeStamp; }

    public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }

    public int getHttpStatusCode() { return httpStatusCode; }

    public void setHttpStatusCode(int httpStatusCode) { this.httpStatusCode = httpStatusCode; }

    public HttpStatus getHttpStatus() { return httpStatus; }

    public void setHttpStatus(HttpStatus httpStatus) { this.httpStatus = httpStatus; }

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
