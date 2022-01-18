package com.torryharris.bookapp.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Cart {

    @Id
    private int bookCode;
    private String bookName;
    private String author;
    private String section;
    private int price;
    private int availableBooks;
    private int totalNumberOfBooks;


    @ManyToOne
    @JoinColumn(name = "userUniqueId", nullable = true)
    private User user;
}
