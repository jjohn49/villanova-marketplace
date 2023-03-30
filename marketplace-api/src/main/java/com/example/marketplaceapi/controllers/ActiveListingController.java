package com.example.marketplaceapi.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.marketplaceapi.MarketplaceApiApplication;
import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.database.ActiveListingRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ActiveListingController {

    @GetMapping(value="/active-listings")
    public String getMethodName() {

        List<ActiveListing> allActiveListings = MarketplaceApiApplication.visableActiveListingRepo.findAll();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        //System.out.println(formatter.format(date));  

        String ret = "\n\n----------------------------ALL ACTIVE LISTINGS AS OF " + formatter.format(date) + "---------------------------\n\n";

        for(ActiveListing x: allActiveListings){
            ret = ret.concat("\n\n" + allActiveListings.toString());
        }

        ret = ret.concat("\n\n----------------------------------END OF ALL ACTIVE LISTINGS-----------------------------------------------------");

        return ret;
    }
    
}
