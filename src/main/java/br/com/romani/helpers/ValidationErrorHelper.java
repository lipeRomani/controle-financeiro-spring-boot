package br.com.romani.helpers;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ValidationErrorHelper {


    private HttpServletRequest request;
    private String path;
    private long timestamp;
    private int status;
    private HashMap<String, String> error = new HashMap<String, String>();

    public ValidationErrorHelper(BindingResult errors, HttpStatus status) {
        setRequestContext();
        setErrors(errors);
        this.status = status.value();
        timestamp = Calendar.getInstance().getTimeInMillis();
        path = request.getRequestURI();
    }

    private void setRequestContext() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        request = sra.getRequest();
    }

    private void setErrors(BindingResult errors) {

        List<FieldError> fields = errors.getFieldErrors();

        for (FieldError f : fields) {
            this.error.put(f.getField(), f.getDefaultMessage());
        }
    }

    public HashMap<String, String> getFields() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public long getTimestamp() {
        return timestamp;
    }


}
