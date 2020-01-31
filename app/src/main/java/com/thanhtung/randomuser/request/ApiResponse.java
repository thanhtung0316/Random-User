package com.thanhtung.randomuser.request;

import java.io.IOException;

import retrofit2.Response;

public class ApiResponse<T> {
    private static final String TAG = "ApiResponse";

    public ApiResponse<T> create(Throwable error){
        return new ApiErrorResponse<>(error.getMessage().equals("")? "Unknown error" :error.getMessage());
    }

    public ApiResponse<T> create(Response<T> response) {
        if (response.isSuccessful()) {
            T body = response.body();
            if (body instanceof PeopleResponse) {
                if (((PeopleResponse) body).getPeopleList().size() == 0) {
                    return new ApiErrorResponse<>("No more Result");
                } else {
                    return new ApiSuccessResponse<>(body);
                }
            } else {
                String errorMsg = "";
                try {
                    errorMsg = response.errorBody().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new ApiErrorResponse<>(errorMsg);
            }
        } else {
            String errorMsg="Can't convert data value";
            return new ApiErrorResponse<>(errorMsg);
        }
    }


    public class ApiSuccessResponse<T> extends ApiResponse<T> {
        private T body;

        public ApiSuccessResponse(T body) {
            this.body = body;
        }

        public T getBody() {
            return body;
        }
    }

    public class ApiErrorResponse<T> extends ApiResponse<T> {
        private String errorMessage;

        public ApiErrorResponse(String errorMessage) {
            this.errorMessage = errorMessage;
        }
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
