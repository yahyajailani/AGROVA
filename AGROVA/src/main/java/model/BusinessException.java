package model;

//Pengelolaan error(error handling)
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }
    
}
