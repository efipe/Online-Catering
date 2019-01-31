package com.brokul.cateringonline.model.dto;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.CateringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CateringDto {
    private int durationDays;

    private String cateringType;

    private String calories;
    private int cateringPrice;
    private int deliveryCost;
    private int totalPrice;
    private String deliveryAddress;
    private String deliveryCity;
    private String deliveryPostalCode;
    private String note;

}
