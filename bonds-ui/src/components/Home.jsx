import React, { useState, useEffect }from 'react'
import Card from 'react-bootstrap/Card'
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

import axios from 'axios'

const Home = () => {
  const currentDate = new Date();
  const formattedDate = currentDate.toDateString();

  const dueDateStr = '08/30/2023';
  const dueDateParts = dueDateStr.split('/');
  const dueDate = new Date(dueDateParts[2], dueDateParts[0]-1, dueDateParts[1]);
  const formattedDueDate = dueDate.toDateString();

  const msPast = currentDate - dueDate;
  const daysPast = Math.floor(msPast/(1000*60*60*24));

  const msFrom = dueDate-currentDate;
  const daysFrom = Math.floor(msFrom/(1000*60*60*24));

  const titleBGColor=()=>{
    let color;
    if(daysFrom>5){
    color = 'green';
  }else if (daysFrom<0){
    color = 'red';
  }else{
    color = 'yellow';
  }
  return color;
}
  

  const [userData, setUserData] = useState(null);
useEffect(() => {
  const fetchData = async()=>{
    try{
    const response = await axios.get('http://localhost:8080/trade');
    setUserData(response.data);
    }catch(error){
      console.error("Error fetching data:", error);
    }
  };
  fetchData();
},[]);

  return (
    <Row xs={1} md ={2} className="g-4">
      {Array.from({length:5}).map((_,idx)=>(
        <Col key = {idx}>
          <Card>
            <div class = "card-header" style={{backgroundColor:titleBGColor()}}>
              <text style=
              {{color:'white',
              fontSize:'21px'}}>
                {idx}
              </text>
            </div>
            <Card.Body>
              
              <Card.Title >it's {idx}</Card.Title>
              
              <Card.Text>some info about bonds</Card.Text>
            </Card.Body>
          </Card>
        </Col>
      ))}

    </Row>
  );
}

export default Home