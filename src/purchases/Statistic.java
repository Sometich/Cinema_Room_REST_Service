package purchases;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Statistic {
    @JsonIgnore
    private List<Ticket> ticketsForStat;
    private int current_income;
    private long number_of_available_seats;
    private long number_of_purchased_tickets;


    public Statistic(List<Ticket> ticketsForStat) {
        this.ticketsForStat = ticketsForStat;
        current_income = ticketsForStat.stream()
                .filter(a -> !a.isAvailable())
                .map(Ticket::getPrice)
                .reduce(0, Integer::sum);
        number_of_available_seats = ticketsForStat.stream()
                .filter(Ticket::isAvailable)
                .count();
        number_of_purchased_tickets = ticketsForStat.stream()
                .filter(a -> !a.isAvailable())
                .count();
    }

    public List<Ticket> getTicketsForStat() {
        return ticketsForStat;
    }

    public void setTicketsForStat(List<Ticket> ticketsForStat) {
        this.ticketsForStat = ticketsForStat;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public void setNumber_of_available_seats(long number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public void setNumber_of_purchased_tickets(long number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public long getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public long getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }
}
