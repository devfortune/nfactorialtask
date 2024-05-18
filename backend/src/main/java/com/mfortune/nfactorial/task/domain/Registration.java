package com.mfortune.nfactorial.task.domain;

import jakarta.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private int reservedSeats;


    public Registration() {}

    public Registration(User user, Event event, int reservedSeats) {
        this.user = user;
        this.event = event;
        this.reservedSeats = reservedSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", reservedSeats=" + reservedSeats +
                '}';
    }
}
