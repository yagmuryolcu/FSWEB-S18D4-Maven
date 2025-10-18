package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "burger")

public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    private String contents;

    public Boolean getIsVegan() {
        return isVegan;
    }

    public void setVegan(Boolean isVegan) {
        isVegan = isVegan;
    }
}