package spring.restful.crud.web.models;

import java.util.Objects;

public class MessageResponse {

    private String message;
    private Object result;

    public MessageResponse(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public MessageResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public MessageResponse setResult(Object result) {
        this.result = result;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageResponse that = (MessageResponse) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, result);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonResponse{");
        sb.append("message='").append(message).append('\'');
        sb.append(", person=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
