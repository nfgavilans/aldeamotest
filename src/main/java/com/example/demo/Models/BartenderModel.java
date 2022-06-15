package com.example.demo.Models;

import javax.persistence.*;

@Entity
@Table (name = "arrays")
public class BartenderModel {

    @Id
    @Column(name="id")
    private Integer id;
    
    @Column(name="input_array")
    private String input_array;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setInput_array(String input_array) {
        this.input_array = input_array;
    }

    public String getInput_array() {
        return input_array;
    }
}
