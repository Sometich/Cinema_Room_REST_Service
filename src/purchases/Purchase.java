package purchases;

public class Purchase {
    String token;
    Ticket ticket;

    public Purchase(String token, Ticket seat) {
        this.token = token;
        this.ticket = seat;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setSeat(Ticket seat) {
        this.ticket = seat;
    }
}
