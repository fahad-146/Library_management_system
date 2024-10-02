package com.whiteBin.student_library_management_system.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.whiteBin.student_library_management_system.enums.TransactionName;
import com.whiteBin.student_library_management_system.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transaction")
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="name")
    @Enumerated(value = EnumType.STRING)
    private TransactionName transactionName; // purchase or return

    @Column(name="status")
    @Enumerated(value= EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column
    private double fine;

    @Column(name="transaction_date")
    @CreationTimestamp
    private Date transactionDate;

    @Column(name="due_date")
    private Date dueDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;
}
