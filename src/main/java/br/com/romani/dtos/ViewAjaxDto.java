package br.com.romani.dtos;


public class ViewAjaxDto<T> {

    private T object;

    public ViewAjaxDto(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
