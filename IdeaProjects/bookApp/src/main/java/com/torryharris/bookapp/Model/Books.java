package com.torryharris.bookapp.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Books {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sNo;
    @Id
    private String bookName;
    private String author;
    private String section;
    private int price;
    private int availableBooks;
}
