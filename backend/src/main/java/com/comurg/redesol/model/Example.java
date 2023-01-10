package com.comurg.redesol.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 80, nullable = false)
    private String name;
}
