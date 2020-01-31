package com.thanhtung.randomuser.utils;

public class Resource<T> {
    public final Status status;
    public final T data;
    public final String message;

    public Resource(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(T data){
        return new Resource<>(Status.SUCCESS,data,null);
    }
    public static <T>Resource<T> error(T data, String message){
        return new Resource<>(Status.ERROR,data,message);
    }
    public static <T>Resource<T> loading(T data){
        return new Resource<>(Status.LOADING,data,null);
    }

}
