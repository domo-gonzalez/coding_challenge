import '../App.css'
import React, { useState, useEffect }from 'react'
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-alpine.css';




const AllBonds = () => {
  // const bond = {"id":1,"isin":"XS1988387210","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":90.0,"tradeSettlementDate":"04/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"az holdings inc","bookName":"trading_book_1"}
  const bonds = [{"id":1,"isin":"XS1988387210","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":90.0,"tradeSettlementDate":"04/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"az holdings inc","bookName":"trading_book_1"},{"id":2,"isin":"XS1988387210","tradeType":"sell","tradeCurrency":"GBP","quantity":40,"unitPrice":89.56,"tradeSettlementDate":"04/08/2021","tradeStatus":"open","tradeDate":"04/02/2021","counterParty":"az holdings inc","bookName":"trading_book_1"},{"id":3,"isin":"USN0280EAR64","tradeType":"buy","tradeCurrency":"USD","quantity":1000,"unitPrice":105.775,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"acme co","bookName":"trading_book_2"},{"id":4,"isin":"USN0280EAR64","tradeType":"sell","tradeCurrency":"GBP","quantity":900,"unitPrice":105.775,"tradeSettlementDate":"10/09/2021","tradeStatus":"open","tradeDate":"04/02/2021","counterParty":"acme co","bookName":"trading_book_2"},{"id":5,"isin":"A12356111","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":90.0,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"sovereign investments","bookName":"trading_book_3"},{"id":6,"isin":"USN0280EAR64","tradeType":"buy","tradeCurrency":"USD","quantity":1000,"unitPrice":105.775,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"astra trading ltd","bookName":"trading_book_2"},{"id":7,"isin":"A12356111","tradeType":"sell","tradeCurrency":"USD","quantity":50,"unitPrice":90.0,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"13/05/2021","counterParty":"sovereign investments","bookName":"trading_book_2"},{"id":8,"isin":"USU02320AG12","tradeType":"buy","tradeCurrency":"GBP","quantity":60,"unitPrice":98.56,"tradeSettlementDate":"27/09/2021","tradeStatus":"open","tradeDate":"04/02/2021","counterParty":"muncipal gov of orange county","bookName":"trading_book_4"},{"id":9,"isin":"USU02320AG12","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":98.56,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"23/08/2021","counterParty":"muncipal gov of orange county","bookName":"trading_book_4"},{"id":10,"isin":"GB00B6460505","tradeType":"buy","tradeCurrency":"GBP","quantity":1100,"unitPrice":110.35,"tradeSettlementDate":"27/09/2021","tradeStatus":"open","tradeDate":"27/09/2021","counterParty":"goldman sachs","bookName":"trading_book_6"},{"id":11,"isin":"GB00B6460506","tradeType":"sell","tradeCurrency":"GBP","quantity":900,"unitPrice":110.35,"tradeSettlementDate":"28/09/2021","tradeStatus":"open","tradeDate":"28/09/2021","counterParty":"goldman sachs","bookName":"trading_book_6"},{"id":12,"isin":"GB00B6460507","tradeType":"buy","tradeCurrency":"GBP","quantity":2000,"unitPrice":110.35,"tradeSettlementDate":"29/09/2021","tradeStatus":"open","tradeDate":"29/09/2021","counterParty":"ubs","bookName":"trading_book_6"},{"id":13,"isin":"GB00B6460508","tradeType":"sell","tradeCurrency":"GBP","quantity":2000,"unitPrice":110.35,"tradeSettlementDate":"30/09/2021","tradeStatus":"open","tradeDate":"30/09/2021","counterParty":"ubs","bookName":"trading_book_6"},{"id":14,"isin":"GB00B6460509","tradeType":"buy","tradeCurrency":"GBP","quantity":1000,"unitPrice":110.35,"tradeSettlementDate":"01/10/2021","tradeStatus":"open","tradeDate":"01/10/2021","counterParty":"barclays","bookName":"trading_book_6"},{"id":15,"isin":"GB00B6460510","tradeType":"buy","tradeCurrency":"GBP","quantity":900,"unitPrice":110.35,"tradeSettlementDate":"02/10/2019","tradeStatus":"open","tradeDate":"02/10/2019","counterParty":"barclays","bookName":"trading_book_6"},{"id":16,"isin":"GB00B6460511","tradeType":"sell","tradeCurrency":"GBP","quantity":1900,"unitPrice":110.35,"tradeSettlementDate":"03/10/2019","tradeStatus":"open","tradeDate":"03/10/2019","counterParty":"barclays","bookName":"trading_book_6"},{"id":17,"isin":"GB00B6460512","tradeType":"buy","tradeCurrency":"GBP","quantity":600,"unitPrice":110.35,"tradeSettlementDate":"04/10/2018","tradeStatus":"open","tradeDate":"04/10/2018","counterParty":"british telecom","bookName":"trading_book_6"},{"id":18,"isin":"GB00B6460513","tradeType":"buy","tradeCurrency":"GBP","quantity":600,"unitPrice":110.35,"tradeSettlementDate":"05/10/2019","tradeStatus":"open","tradeDate":"05/10/2019","counterParty":"pension holdings","bookName":"trading_book_6"},{"id":19,"isin":"GB00B6460514","tradeType":"buy","tradeCurrency":"GBP","quantity":700,"unitPrice":110.35,"tradeSettlementDate":"06/06/2021","tradeStatus":"open","tradeDate":"06/06/2021","counterParty":"pension holdings","bookName":"trading_book_6"},{"id":20,"isin":"GB00B6460515","tradeType":"sell","tradeCurrency":"GBP","quantity":1300,"unitPrice":110.35,"tradeSettlementDate":"07/10/2021","tradeStatus":"open","tradeDate":"07/10/2011","counterParty":"pension holdings","bookName":"trading_book_6"},{"id":21,"isin":"US87973RAA86","tradeType":"buy","tradeCurrency":"USD","quantity":60,"unitPrice":100.13,"tradeSettlementDate":"27/09/2021","tradeStatus":"open","tradeDate":"04/02/2012","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":22,"isin":"US87973RAA86","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":100.13,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"23/08/2012","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":23,"isin":"US87973RAA86","tradeType":"buy","tradeCurrency":"USD","quantity":75,"unitPrice":100.13,"tradeSettlementDate":"27/09/2021","tradeStatus":"open","tradeDate":"04/02/2013","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":24,"isin":"US87973RAA86","tradeType":"buy","tradeCurrency":"USD","quantity":50,"unitPrice":100.13,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"23/08/2014","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":25,"isin":"IE00B29LNP31","tradeType":"buy","tradeCurrency":"USD","quantity":300,"unitPrice":98.76,"tradeSettlementDate":"27/09/2021","tradeStatus":"open","tradeDate":"04/02/2016","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":26,"isin":"IE00B29LNP31","tradeType":"buy","tradeCurrency":"USD","quantity":300,"unitPrice":98.76,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"23/08/2012","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":27,"isin":"IE00B29LNP31","tradeType":"buy","tradeCurrency":"USD","quantity":300,"unitPrice":98.76,"tradeSettlementDate":"27/09/2021","tradeStatus":"open","tradeDate":"04/02/2013","counterParty":"zurich pension fund 4","bookName":"trading_book_4"},{"id":28,"isin":"IE00B29LNP31","tradeType":"sell","tradeCurrency":"USD","quantity":300,"unitPrice":98.76,"tradeSettlementDate":"23/08/2021","tradeStatus":"open","tradeDate":"23/08/2015","counterParty":"zurich pension fund 4","bookName":"trading_book_4"}]

//   const [rowData] = useState([
//     {id:1,isin:"XS1988387210",tradeType:"buy",tradeCurrency:"USD",quantity:50,unitPrice:90.0,tradeSettlementDate:"04/08/2021",tradeStatus:"open",tradeDate:"13/05/2021",counterParty:"az holdings inc",bookName:"trading_book_1"}
// ]);

// const [columnDefs] = useState([
//     { field: 'id' },
//     { field: 'isin' },
//     { field: 'tradeType' }
// ]);
const [rowData, setRowData] = useState(); // Set rowData to Array of Objects, one Object per Row

  // Each Column Definition results in one Column.
  const [columnDefs, setColumnDefs] = useState([
    {field: 'id', filter: true},
    {field: 'isin', filter: true},
    {field: 'tradeType'},
    {field: 'tradeCurrency'},
    {field: 'quantity'},
    {field: 'unitPrice'},
    {field: 'tradeSettlementDate', filter: true},
    {field: 'tradeStatus'},
    {field: 'tradeDate'},
    {field: 'counterParty'},
    {field: 'bookName'}
    
    




  ]);

  // findBonds()
  //           .then(({data}) => {
  //           setBook(data);
  //           });

  useEffect(() => {
    fetch('http://localhost:8080/trade')
    // console.log(fetch('http://localhost:8080/trade'))
    .then(result => result.json())
    .then(rowData => setRowData(rowData))
  }, []);

  return (
  
    // bonds.map(bond=>(
    //   <BondDetail info={bond} key={bond.isin.toString()} />
    //  ))
    
    <div id = "grid" className="ag-theme-alpine">
    <AgGridReact
        rowData={rowData}
        columnDefs={columnDefs}>
    </AgGridReact>
    </div>
    
  )
}

export default AllBonds