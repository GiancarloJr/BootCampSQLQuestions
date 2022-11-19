package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustomerNameProjections;

public class CustomerMinDTO {

     private String name;

     public CustomerMinDTO(){

     }

     public CustomerMinDTO(String name) {
          this.name = name;
     }
     public CustomerMinDTO(CustomerNameProjections projections) {
          this.name = projections.getName();
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     @Override
     public String toString() {
          return "CustomerMinDTO{" +
                  "name='" + name + '\'' +
                  '}';
     }
}
