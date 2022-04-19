package cinema;

import purchases.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Ticket> available_seats = new ArrayList<>();


    {
        total_columns = 9;
        total_rows = 9;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i <= 4) {
                    available_seats.add(new Ticket(i, j, 10));
                } else {
                    available_seats.add(new Ticket(i, j, 8));
                }
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }


    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Ticket> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Ticket> available_seats) {
        this.available_seats = available_seats;
    }
}
