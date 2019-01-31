package com.brokul.cateringonline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CateringType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Normal, Vege, Gain, Lunch
    private String typeOfCatering;


}
