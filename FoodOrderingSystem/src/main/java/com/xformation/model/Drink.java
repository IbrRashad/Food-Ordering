package com.xformation.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
@Data
@Entity
@Table(name = "drink")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    Long price;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

}
