package com.xformation.model;

import com.xformation.enums.AdditionalRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_history")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "date")
    LocalDateTime orderHistory;
    @Column(name = "drinkName")
    String drinkName;
    @Column(name = "mainCourse")
    String mainCourse;
    @Column(name = "dessert")
    String dessert;
    @Enumerated(EnumType.STRING)
    AdditionalRequest additionalRequest;
}
