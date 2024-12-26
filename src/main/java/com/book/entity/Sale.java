package com.book.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @Column(name = "ord_num", length = 20)
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "stor_id")
//    @JsonBackReference // Prevents infinite recursion
    @JsonIgnore
    private Store store;

    @ManyToOne
    @JoinColumn(name = "title_id")
//    @JsonBackReference
    @JsonIgnore
    private Title title;

    @Column(name = "ord_date")
    private LocalDateTime orderDate;

    @Column(name = "qty")
    private Integer quantity;

    @Column(name = "payterms", length = 12)
    private String paymentTerms;

}