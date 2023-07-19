package com.exception;


public class FlightBookingException extends RuntimeException {
 public FlightBookingException(String message) {
     super(message);
 }

 public FlightBookingException(String message, Throwable cause) {
     super(message, cause);
 }
}
