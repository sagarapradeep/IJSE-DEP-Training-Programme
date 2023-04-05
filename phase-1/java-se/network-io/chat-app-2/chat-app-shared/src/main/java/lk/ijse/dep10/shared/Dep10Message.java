package lk.ijse.dep10.shared;

import java.io.Serializable;

public class Dep10Message implements Serializable {
    private Dep10Headers header;        //represent header
    private Object body;                //represent the body of the message object

    public Dep10Message() {
    }

    public Dep10Message(Dep10Headers header, Object body) {
        this.header = header;
        this.body = body;
    }

    public Dep10Headers getHeader() {
        return header;
    }

    public Object getBody() {
        return body;
    }

    public void setHeader(Dep10Headers header) {
        this.header = header;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
