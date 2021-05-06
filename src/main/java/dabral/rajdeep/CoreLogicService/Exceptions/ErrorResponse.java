package dabral.rajdeep.CoreLogicService.Exceptions;

import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ErrorResponse {

    private String message;
    private List<String> details;
    private HttpStatus status;

    public ErrorResponse(String message, List<String> details, HttpStatus status) {
        this.message = message;
        this.details = details;
        this.status = status;
    }

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
