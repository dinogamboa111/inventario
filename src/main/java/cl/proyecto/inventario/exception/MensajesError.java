package cl.proyecto.inventario.exception;

/*import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler; */
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class MensajesError {

    // Maneja excepciones de tipo NoSuchElementException
    //@ExceptionHandler(NoSuchElementException.class)
    //public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        // Retorna un mensaje con codigo de error 404
      //  return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    //}

    
}

