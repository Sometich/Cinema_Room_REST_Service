package purchases;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Ticket {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean available = true;
    @JsonIgnore
    private String token = null;


    public Ticket() {
    }

    public Ticket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        available = true;
        token = UUID.randomUUID().toString();
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getToken() {
        return token;
    }
}
