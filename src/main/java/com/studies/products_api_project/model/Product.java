/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studies.products_api_project.model;

import lombok.*;
/**
 *
 * @author Cauan
 */

 @Getter
 @Setter
public class Product {
    private long id;
    private String name;
    private double price;
    
    public Product(){
    }
    
    public Product(long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
   
}
