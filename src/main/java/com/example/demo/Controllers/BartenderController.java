package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.BartenderModel;
import com.example.demo.Objects.ParamsRequest;
import com.example.demo.Services.BartenderService;


@RestController
@RequestMapping()
public class BartenderController {
    @Autowired
    BartenderService bartenderService;

    @GetMapping("solution")
    public ArrayList<Integer> solucion(@RequestBody ParamsRequest input){
        return bartenderService.respuesta(input);
    }   

    @GetMapping()
    public ArrayList<BartenderModel> obtenerData(){
        return bartenderService.datosDB();
    }   

    @GetMapping(path = "/{id}")
    public Optional<BartenderModel> obtenerArray(@PathVariable("id") int id){
        return bartenderService.obtenerDatos(id);
    }
}