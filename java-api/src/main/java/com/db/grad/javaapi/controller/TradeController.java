package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {
    private TradeService service;

    @Autowired
    public TradeController(TradeService ts) {service = ts;}









}
