package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.BartenderModel;
import com.example.demo.Objects.ParamsRequest;
import com.example.demo.Repositories.BartenderRepository;


@Service
public class BartenderService {
    @Autowired
    BartenderRepository bartenderRespository;

    public ArrayList<BartenderModel> datosDB(){
        System.out.println((ArrayList<BartenderModel>)bartenderRespository.findAll());
        return (ArrayList<BartenderModel>)bartenderRespository.findAll();
    }

    public Optional<BartenderModel> obtenerDatos(int id){
        return bartenderRespository.findById(id);
    }
    
    public ArrayList<Integer> respuesta(ParamsRequest input){
        System.out.println("Recibe request: " + input.getIteration());
        ArrayList<Integer> P = getPrimes(input.getIteration());
        System.out.println("Devuelve primos: " + P);
        int value;
        Optional<BartenderModel> data = obtenerDatos(input.getId());
        String stringData = data.get().getInput_array();

        ArrayList<Integer> arrayA = toIntsArray(stringData);

        ArrayList<Integer> arrayB = new ArrayList<>();
        ArrayList<Integer> respuesta = new ArrayList<>() ;        
        
        for(int i= 0; i< input.getIteration(); i++){
            int aSize = arrayA.size();
            for (int j = 0; j < aSize; j++) {
                value = arrayA.get(arrayA.size()-1);
                arrayA.remove(arrayA.size()-1);
                if(value % P.get(i) == 0) {
                    arrayB.add(value);
                } else {
                    arrayA.add(0, value);
                }   
            }
            respuesta.addAll(arrayB);
            arrayB.clear();
        }

        return respuesta;
    }

    private ArrayList<Integer> getPrimes(int iteration) {
        int primesCounter = 1;
        int number = 1;
        ArrayList<Integer> primes = new ArrayList<>();
        while (primesCounter <= iteration) {
            System.out.println("Cantidad primos: " + primesCounter + " iteración " + iteration);
            int dividers = 0;
            for (int i = 1; i <= number ; i++) {
                System.out.println("numero : " + number);
                System.out.println("i : " + i);
                System.out.println("modulo : " + number % i);
                if (number % i == 0) {
                    dividers++;
                }
            }
            if (dividers == 2) {
                primes.add(number);
                primesCounter++;
            }
            number++;
        }
        return primes;
    }

    public static ArrayList<Integer> toIntsArray (String str){
        return Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }
}

