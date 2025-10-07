import java.io.IOException;

class BadRequestException extends IOException {

    public BadRequestException(String message) {
        super(message);
    }
}

class Task {
    public static void main(String[] args) throws BadRequestException {
        throw new BadRequestException("Pizda");
    }
}