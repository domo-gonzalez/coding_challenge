package com.db.grad.javaapi.service;


import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    private TradeRepository tradeRepository;

    @Autowired
    public TradeService(TradeRepository tradeRepo) {tradeRepository = tradeRepo;}

    public Trade addTrade(Trade trade) {return tradeRepository.save(trade);}

    public long getNoOfTrades()
    {
        return tradeRepository.count();
    }

    public List<Trade> getAllTrades() {return tradeRepository.findAll();}

    public Trade getTradeById(long id)
    {
        return tradeRepository.findById(id).get();
    }


    public List<Trade> getTradeBySettlementDate(String date)
    {
//        Trade dateToFind = new Trade();
//        dateToFind.setTradeSettlementDate(date);
//        List<Trade> dates = tradeRepository.findBySettlementDate(date);
//        List<Trade> result = null;
//
//        if( dates.size() < 1) {
////            result = dates.get(0)
//            return result;
//        }

//        return dates;

        return tradeRepository.findBySettlementDate(date);
    }



    public Trade updateTradeDetails(Trade tradeToUpdate)
    {
        return tradeRepository.save( tradeToUpdate );
    }

    public boolean removeTrade(long id)
    {
        boolean result = false;

        Optional<Trade> theTrade = tradeRepository.findById(id);
        if(theTrade.isPresent())
        {
            tradeRepository.delete(theTrade.get());
            result = true;
        }

        return  result;
    }






}
