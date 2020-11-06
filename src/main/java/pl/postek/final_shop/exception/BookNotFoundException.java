package pl.postek.final_shop.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
