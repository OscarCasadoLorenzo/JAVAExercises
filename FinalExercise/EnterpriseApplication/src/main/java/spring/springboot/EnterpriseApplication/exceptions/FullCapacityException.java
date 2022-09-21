package spring.springboot.EnterpriseApplication.exceptions;

public class FullCapacityException extends  RuntimeException{
    public FullCapacityException(Integer tripID) {
        super("Couldn't book a ticket for trip with id " + tripID + " because is full of capacity.");
    }
}
