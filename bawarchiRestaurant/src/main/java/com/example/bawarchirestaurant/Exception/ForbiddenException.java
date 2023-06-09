package com.example.bawarchirestaurant.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(ForbiddenException.class);

    public ForbiddenException(String message) {

        super(message);

        logger.error("Forbidden Access");



    }
}