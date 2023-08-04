import React from 'react'

const BondDetail = (props) => {
  // {"id":1,"isin":"XS1988387210","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":90.0,"tradeSettlementDate":"04/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"az holdings inc","bookName":"trading_book_1"}
  return (
    <div>
      <p id="blue-alias">ISIN: {props.info.isin}</p>
      <p className="green-class">Trade Type: {props.info.tradeType}</p>
      <p className="green-class">Trade Currency: {props.info.tradeCurrency}</p>
      <p className="green-class">Quantity: {props.info.quantity}</p>
      <p className="green-class">Unit Price: {props.info.unitPrice}</p>
      <p className="green-class">Trade Settlement Date: {props.info.tradeSettlementDate}</p>
      <p className="green-class">Trade Status: {props.info.tradeStatus}</p>
      <p className="green-class">Trade Date: {props.info.tradeDate}</p>
      <p className="green-class">Counter Party: {props.info.counterParty}</p>
      <p className="green-class">Book Name: {props.info.bookName}</p>
      {/* <button className="green-class">Like</button>    */}
    </div>
  )
}

export default BondDetail