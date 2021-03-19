package io.github.williamjesusdev.vacinaja.rest.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiErrors {

    private List<String> errors;

    public ApiErrors(String mensagemErro){
        this.errors = Collections.singletonList(mensagemErro);
    }

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}

