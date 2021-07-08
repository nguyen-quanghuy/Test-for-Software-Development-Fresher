package com.example.simplestorage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    private T data;
    private Meta meta;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Meta {
        private Integer code;
        private String message;

        public static Meta ok() {
            return new Meta(HttpStatus.OK.value(), null);
        }
    }

    public static <T> BaseResponse<T> ok(final T data) {
        return new BaseResponse<>(data, Meta.ok());
    }

    public static BaseResponse<Object> error(final Integer code, final String msg) {
        final BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setMeta(new Meta(code, msg));

        return baseResponse;
    }
}
