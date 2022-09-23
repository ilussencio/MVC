package com.ilussencio.monitor.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "MONITOR")
@Data
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private double preco;

}
