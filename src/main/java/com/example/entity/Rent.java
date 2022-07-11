package com.example.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer", length = 100, nullable = false)
        private String customer;

    @Column(name = "contanct", length = 100, nullable = false)
    private String contanct;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "book_id")
    @NotNull(message = "*Please select Book")
    private Book books;

    @Column(name = "dateOfRent", nullable = false)
    String dateOfRent;
    @Column(name = "period", nullable = false)
    Integer period;

    @Column(name = "dateOfRetern")
    String dateOfRetern;




    public Rent(String customer, String contanct, String dateOfRent, int period,Book book) {
        this.customer = customer;
        this.contanct = contanct;
        this.dateOfRent = dateOfRent;
        this.period = period;
        this.books=book;


    }



    public String getDateOfRent() {
            return dateOfRent;
        }
    public void setDateOfRent(String dateOfRent) {
            this.dateOfRent = dateOfRent;
        }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getContanct() {
        return contanct;
    }

    public void setContanct(String contanct) {
        this.contanct = contanct;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public String getDateOfRetern() {
        return dateOfRetern;
    }

    public void setDateOfRetern(String dateOfRetern) {
        this.dateOfRetern = dateOfRetern;
    }
}
