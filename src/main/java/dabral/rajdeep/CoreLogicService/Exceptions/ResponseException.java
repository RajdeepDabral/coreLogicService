package dabral.rajdeep.CoreLogicService.Exceptions;

import java.util.Date;

public class ResponseException {
    private String errorMessage;
    private Date timeStamp;

    public ResponseException(String errorMessage, Date timeStamp) {
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
    }

    public ResponseException(){
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
