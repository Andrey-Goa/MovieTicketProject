package ru.movietickets.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movieTicket;

    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "hall")
    private Integer hall;

    @Column(name = "row")
    private Integer row;

    @Column(name = "space")
    private Integer space;

    @Column(name = "status")
    private Integer status;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMovieTicket(Movie movieTicket) {
        this.movieTicket = movieTicket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Movie getMovieTicket() {
        return movieTicket;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public Integer getHall() {
        return hall;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getSpace() {
        return space;
    }

    public Integer getStatus() {
        return status;
    }
}
