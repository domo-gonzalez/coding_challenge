package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//This is the right domo-raj
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {
    private TradeService service;

    @Autowired
    public TradeController(TradeService ts) {service = ts;}

    @PostMapping("/trade")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        return service.addTrade(trade);
    }

    @GetMapping("/trade")
    public List<Trade> getAllTrades() {return service.getAllTrades();}

    @GetMapping("/trade/{id}")
    public Trade getTradeById(@PathVariable(value = "id") Long id){
//            throws ResourceNotFoundException {
        return service.getTradeById(id);
//        return ResponseEntity.ok().body(trade);
    }
//new
    @GetMapping("/tradebydate/{tradeSettlementDate}")
    public ResponseEntity<List<Trade>> getTradeBySettlementDate(@PathVariable(value = "tradeSettlementDate") String tradeSettlementDate)
        throws ResourceNotFoundException {
        List <Trade> settle = service.getTradeBySettlementDate(tradeSettlementDate);
        System.out.println("print settle: "+settle.toString());
            return ResponseEntity.ok().body(settle);
        }



//        Trade trade = service.getTradeBySettlementDate(tradeSettlementDate);
//        return ResponseEntity.ok().body(trade);

    @PutMapping("/trade/{id}")
    public ResponseEntity< Trade > updateTrade(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody Trade tradeDetails) throws ResourceNotFoundException {

        final Trade updatedTrade = service.updateTradeDetails(tradeDetails);
        return ResponseEntity.ok(updatedTrade);
    }

    @DeleteMapping("/trade/{id}")
    public Map< String, Boolean > deleteTrade(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = service.removeTrade(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }







}
