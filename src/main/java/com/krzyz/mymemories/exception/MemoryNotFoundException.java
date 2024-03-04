package com.krzyz.mymemories.exception;


public class MemoryNotFoundException extends RuntimeException{
    public MemoryNotFoundException(String message){
        super(message);
    }
}
