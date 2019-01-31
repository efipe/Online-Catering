package com.brokul.cateringonline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Catering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @ManyToOne
//    private AppUser customer;
    private int durationDays;

    private String cateringType;

    private int calories;
    private int cateringPrice;
    private int deliveryCost;
    private int totalPrice;
    private String deliveryAddress;
    private String deliveryCity;
    private String deliveryPostalCode;
    private String note;

    // todo data rozpoczecia i zakonczenia cateringu


}
