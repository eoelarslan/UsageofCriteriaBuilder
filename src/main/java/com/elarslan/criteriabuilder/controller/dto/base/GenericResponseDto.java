package com.elarslan.criteriabuilder.controller.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenericResponseDto<T> {

    private String message;
    private HttpStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> results;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object singleResult;

    public GenericResponseDto(HttpStatus status, String message, List<T> results) {
        this.status = status;
        this.message = message;

        if (results != null) {
            this.results = results;
        } else {
            this.results = new ArrayList<>();
        }
    }

    public GenericResponseDto(HttpStatus status, String message, Object singleResult) {
        this.status = status;
        this.message = message;

        if (singleResult != null) {
            this.singleResult = singleResult;
        } else {
            this.singleResult = new ArrayList<>();
        }
    }
}
