package com.customer.backend.shared.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result <T> {

    private String messagee;

    public Result(String messagee) {

        this.messagee = messagee;
    }

}
