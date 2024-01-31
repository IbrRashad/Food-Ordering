package com.xformation.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "food")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "main_course")
    String mainCourse;
    @Column(name = "dessert")
    String dessert;
    @Column(name = "price")
    Long price;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", mainCourse='" + mainCourse + '\'' +
                ", dessert='" + dessert + '\'' +
                ", price=" + price +
                ", country=" + (country != null ? country.getName() : null) + // Avoid circular reference
                '}';
    }
}
