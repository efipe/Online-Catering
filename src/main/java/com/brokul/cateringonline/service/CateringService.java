package com.brokul.cateringonline.service;

import com.brokul.cateringonline.model.AppUser;
import com.brokul.cateringonline.model.Catering;
import com.brokul.cateringonline.model.dto.CateringDto;
import com.brokul.cateringonline.repository.AppUserRepository;
import com.brokul.cateringonline.repository.CateringRepository;
import com.brokul.cateringonline.repository.CateringTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CateringService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private CateringRepository cateringRepository;

    @Autowired
    private CateringTypeRepository cateringTypeRepository;


    public boolean createOrder(Long id, CateringDto cateringDto) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        String cateringTypeAndCalories;

        if (optionalAppUser.isPresent()) {
            AppUser customer = optionalAppUser.get();
            Catering cateringOrdered = new Catering();

            cateringTypeAndCalories = cateringDto.getCateringType();


            String[] typeAndCalories = cateringTypeAndCalories.split(" ");
            int cateringPrice = calculatePrice(cateringDto.getDurationDays(), typeAndCalories[0], typeAndCalories[1]);

            if (typeAndCalories[0].equals("W")) {
                cateringOrdered.setCateringType("WEGE");
                switch (typeAndCalories[1]) {
                    case "15":
                        cateringOrdered.setCalories(1500);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "30":
                        cateringOrdered.setCalories(3000);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                }
            } else if (typeAndCalories[0].equals("N")) {
                cateringOrdered.setCateringType("NORMAL");
                switch (typeAndCalories[1]) {
                    case "12":
                        cateringOrdered.setCalories(1200);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "15":
                        cateringOrdered.setCalories(1500);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "20":
                        cateringOrdered.setCalories(2000);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "25":
                        cateringOrdered.setCalories(2500);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "30":
                        cateringOrdered.setCalories(3000);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "35":
                        cateringOrdered.setCalories(3500);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                }
            } else if (typeAndCalories[0].equals("G")) {
                cateringOrdered.setCateringType("GAIN");
                switch (typeAndCalories[1]) {
                    case "2":
                        cateringOrdered.setCalories(2);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "3":
                        cateringOrdered.setCalories(3);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "4":
                        cateringOrdered.setCalories(4);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                    case "5":
                        cateringOrdered.setCalories(5);
                        cateringOrdered.setCateringPrice(cateringPrice);
                        cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                        cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                        cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
                        break;
                }

            } else if (typeAndCalories[0].equals("Z")) {
                cateringOrdered.setCateringType("ZDROWE_OBIADKI");
                cateringOrdered.setCateringPrice(cateringPrice);
                cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());

            } else if (typeAndCalories[0].equals("ZO")) {
                cateringOrdered.setCateringType("WEGE_ZDROWE_OBIADKI");
                cateringOrdered.setCateringPrice(cateringPrice);
                cateringOrdered.setDurationDays(cateringDto.getDurationDays());
                cateringOrdered.setDeliveryCost(cateringDto.getDurationDays() * 6);
                cateringOrdered.setTotalPrice(cateringOrdered.getCateringPrice() + cateringOrdered.getDeliveryCost());
            }
            customer.getListOfUserOrders().add(cateringOrdered);



            if (cateringDto.getDeliveryAddress().isEmpty() || cateringDto.getDeliveryCity().isEmpty() || cateringDto.getDeliveryPostalCode().isEmpty()) {
                cateringOrdered.setDeliveryAddress(customer.getAddress());
                cateringOrdered.setDeliveryCity(customer.getCity());
                cateringOrdered.setDeliveryPostalCode(customer.getPostalCode());

            } else {
                cateringOrdered.setDeliveryAddress(cateringDto.getDeliveryAddress());
                cateringOrdered.setDeliveryCity(cateringDto.getDeliveryCity());
                cateringOrdered.setDeliveryPostalCode(cateringDto.getDeliveryPostalCode());
            }


            cateringOrdered.setNote(cateringDto.getNote());
            cateringRepository.saveAndFlush(cateringOrdered);
            appUserRepository.saveAndFlush(customer);


        }
        return false;

    }

    private int calculatePrice(int durationDays, String cateringType, String calories) {
        switch (durationDays) {

            case 1:
                switch (cateringType) {
                    case "N":
                        switch (calories) {
                            case "12":
                                return 40;
                            case "15":
                                return 40;
                            case "20":
                                return 40;
                            case "25":
                                return 45;
                            case "30":
                                return 45;
                            case "35":
                                return 50;
                        }
                    case "W":
                        switch (calories) {
                            case "15":
                                return 40;
                            case "30":
                                return 50;
                        }
                    case "G":
                        switch (calories) {
                            case "2":
                                return 40;
                            case "3":
                                return 50;
                            case "4":
                                return 60;
                            case "5":
                                return 65;

                        }

                    case "Z":
                        return 40;

                    case "WZ":
                        return 40;
                }

            case 5:
                switch (cateringType) {
                    case "N":
                        switch (calories) {
                            case "12":
                                return 180;
                            case "15":
                                return 180;
                            case "20":
                                return 200;
                            case "25":
                                return 225;
                            case "30":
                                return 245;
                            case "35":
                                return 260;
                        }
                    case "W":
                        switch (calories) {
                            case "15":
                                return 180;
                            case "30":
                                return 260;
                        }
                    case "G":
                        switch (calories) {
                            case "2":
                                return 150;
                            case "3":
                                return 200;
                            case "4":
                                return 250;
                            case "5":
                                return 300;
                        }

                    case "Z":
                        return 110;

                    case "WZ":
                        return 110;
                }


            case 20:
                switch (cateringType) {
                    case "N":
                        switch (calories) {
                            case "12":
                                return 550;
                            case "15":
                                return 580;
                            case "20":
                                return 680;
                            case "25":
                                return 780;
                            case "30":
                                return 832;
                            case "35":
                                return 880;
                        }
                    case "W":
                        switch (calories) {
                            case "15":
                                return 580;
                            case "30":
                                return 880;
                        }
                    case "G":
                        switch (calories) {
                            case "2":
                                return 480;
                            case "3":
                                return 700;
                            case "4":
                                return 880;
                            case "5":
                                return 990;
                        }

                    case "Z":
                        return 300;

                    case "WZ":
                        return 300;
                }


        }
        return 0;
    }



}
