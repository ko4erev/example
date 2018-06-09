package com.example.example.model;

import javax.persistence.*;

@Entity
@Table(schema = "ad", name = "example")
public class TableForExample {
    @GeneratedValue
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "value", length = 20)
    String value;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getValue() {
        return value;
    }

    public TableForExample setValue(String value) {
        this.value = value;
        return this;
    }
}
