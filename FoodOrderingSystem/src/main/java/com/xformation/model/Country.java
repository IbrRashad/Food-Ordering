package com.xformation.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "country")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Food> foods;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Drink> drink;

    // Constructor to initialize the list
    public Country() {
        this.foods = new ArrayList<>();
        this.drink = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foods=" + foods.size() + // Avoid calling toString on the entire foods collection
                ", drink=" + drink.size() + // Avoid calling toString on the entire drink collection
                '}';
    }
}
