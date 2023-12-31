package com.balikesoft.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @SequenceGenerator(
            name="customer_id_sequence",
            sequenceName="customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    @Column(name="id")
    private Integer id;
@Column(name="first_name")
    private String  firstName;
@Column(name="last_name")
    private String lastName;
@Column(name="email")
    private String email;
}
