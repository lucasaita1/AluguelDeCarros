package lucas.AluguelDeCarros.Service;

public class CarroInvalidoException extends RuntimeException{

    public CarroInvalidoException(String mensagem) {
            super(mensagem);
    }
}
