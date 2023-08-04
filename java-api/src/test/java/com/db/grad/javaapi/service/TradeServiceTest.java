package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {
    @Mock
    private TradeRepository repo;

    @InjectMocks
    private TradeService cut;

    @Test
    public  void    add_a_trade_return_number_of_trade_in_repo_is_twenty_nine()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTradeType("buy");
        theTrade.setTradeCurrency("USD");
        theTrade.setQuantity(60);
        theTrade.setUnitPrice(36.50);
        theTrade.setTradeSettlementDate("20/05/2023");
        theTrade.setTradeStatus("active");
        theTrade.setTradeDate("04/08/2023");
        theTrade.setCounterParty("Domo bank");
        theTrade.setBookName("trading_book_1");
        Mockito.when(repo.save(theTrade)).thenReturn(theTrade);
        Mockito.when(repo.count()).thenReturn(29L);
        cut.addTrade( theTrade );
        System.out.println(theTrade);
        System.out.println(cut.getNoOfTrades());
        int expectedResult = 29;

        // act
        long actualResult = cut.getNoOfTrades();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    update_trade_that_exists_returns_trade_id()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTradeType("buy");
        theTrade.setTradeCurrency("USD");
        theTrade.setQuantity(60);
        theTrade.setUnitPrice(36.50);
        theTrade.setTradeSettlementDate("20/05/2023");
        theTrade.setTradeStatus("active");
        theTrade.setTradeDate("04/08/2023");
        theTrade.setCounterParty("Domo bank");
        theTrade.setBookName("trading_book_1");
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTradeType("sell");
        theTrade.setTradeCurrency("GDP");
        theTrade.setQuantity(90);
        theTrade.setUnitPrice(42.50);
        theTrade.setTradeSettlementDate("19/02/2022");
        theTrade.setTradeStatus("active");
        theTrade.setTradeDate("04/08/2020");
        theTrade.setCounterParty("Domo bank");
        theTrade.setBookName("trading_book_1");
        Mockito.when(repo.save(theTrade)).thenReturn(theTrade);
        Trade expectedTrade = cut.addTrade( theTrade );
        Trade tradeToUpdate = theTrade;
        theTrade = new Trade();
        theTrade.setTradeType("sell");
        theTrade.setTradeCurrency("GDP");
        theTrade.setQuantity(90);
        theTrade.setUnitPrice(42.50);
        theTrade.setTradeSettlementDate("19/02/2022");
        theTrade.setTradeStatus("active");
        theTrade.setTradeDate("04/08/2020");
        theTrade.setCounterParty("Domo bank");
        theTrade.setBookName("trading_book_1");
        cut.addTrade( theTrade );
        Mockito.when(repo.save(tradeToUpdate)).thenReturn(tradeToUpdate);

        // act
        tradeToUpdate.setTradeStatus("buy");
        Trade actualTrade = cut.updateTradeDetails( tradeToUpdate );

        // assert
        Assertions.assertEquals( expectedTrade, actualTrade );
    }


}
