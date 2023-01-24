package exceptions;

public class LaptopNotFoundException extends RuntimeException{
    public LaptopNotFoundException(){
        super();
    }
    public LaptopNotFoundException(String message){
        super(message);
    }
}
