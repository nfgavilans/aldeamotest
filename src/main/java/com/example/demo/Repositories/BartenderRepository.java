package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.BartenderModel;

@Repository
public interface BartenderRepository extends CrudRepository<BartenderModel, Integer>{
    
}
