// NEW FILE: src/main/java/com/aarogyaNet/exception/ResourceNotFoundException.java
package com.aarogyaNet.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}