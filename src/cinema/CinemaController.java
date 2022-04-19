package cinema;

import purchases.Purchase;
import purchases.Statistic;
import purchases.Ticket;
import exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@ControllerAdvice
public class CinemaController {
    Cinema cinema = new Cinema();

    @GetMapping("/seats")
    Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    Purchase purchaseSeat(@RequestBody Ticket seat) {
        int a = seat.getRow();
        int b = seat.getColumn();
        if (a <= 9 && b <= 9 && a >= 1 && b >= 1) {
            for (int i = 0; i < cinema.getAvailable_seats().size(); i++) {
                if (cinema.getAvailable_seats().get(i).getRow() == a &&
                        cinema.getAvailable_seats().get(i).getColumn() == b) {
                    if (cinema.getAvailable_seats().get(i).isAvailable()) {
                        cinema.getAvailable_seats().get(i).setAvailable(false);
                        return new Purchase(cinema.getAvailable_seats().get(i).getToken(),
                                cinema.getAvailable_seats().get(i));
                    }
                    break;
                }
            }
            throw new RuntimeException("The ticket has been already purchased!");
        } else {
            throw new RuntimeException("The number of a row or a column is out of bounds!");
        }
    }

    @PostMapping("/return")
    Map<String, Ticket> returnTicket(@RequestBody Token token) {
        String uuid = token.getToken();
        for (int i = 0; i < cinema.getAvailable_seats().size(); i++) {
            if (uuid.equals(cinema.getAvailable_seats().get(i).getToken())) {
                cinema.getAvailable_seats().get(i).setAvailable(true);
                return Map.of("returned_ticket", cinema.getAvailable_seats().get(i));
            }
        }
        throw new RuntimeException("Wrong token!");
    }


    @PostMapping("/stats")
    ResponseEntity<Object> postStat(@RequestParam(value = "password", required = false) String password) {
        if (Objects.equals("super_secret", password)){
            return new ResponseEntity<>(new Statistic(cinema.getAvailable_seats()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomException("The password is wrong!"), HttpStatus.valueOf(401));
    }



    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleApiRequestException(RuntimeException e) {
        return new ResponseEntity<>(new CustomException(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
