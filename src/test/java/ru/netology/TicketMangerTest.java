package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketMangerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(10, 3000, "AAA", "PPP", 145);  // одно направление 3000р
    Ticket ticket2 = new Ticket(48, 1111, "WWW", "QQQ", 145);
    Ticket ticket3 = new Ticket(54, 5000, "AAA", "PPP", 145);  // одно направление 5000р
    Ticket ticket4 = new Ticket(39, 1111, "RRR", "EEE", 145);
    Ticket ticket5 = new Ticket(20, 1000, "AAA", "PPP", 145);  // одно направление 1000р
    Ticket ticket6 = new Ticket(67, 1111, "YYY", "RRR", 145);
    Ticket ticket7 = new Ticket(81, 4000, "AAA", "PPP", 145);  // одно направление 4000р
    Ticket ticket8 = new Ticket(57, 1111, "VVV", "YYY", 145);
    Ticket ticket9 = new Ticket(41, 1111, "NNN", "UUU", 145);
    Ticket ticket10 = new Ticket(30, 2000, "AAA", "PPP", 145);  // одно направление 2000р



    @Test
    public void findAllTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket5, ticket10, ticket1, ticket7, ticket3};
        Ticket[] actual = manager.findAll("AAA", "PPP");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTestNoMatches() {
        manager.add(ticket2);
        manager.add(ticket4);
        manager.add(ticket6);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("AAA", "PPP");

        Assertions.assertArrayEquals(expected, actual);
    }



}
