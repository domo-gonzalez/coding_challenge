import React, { useState, useEffect }from 'react'
import Card from 'react-bootstrap/Card'
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
const Home = () => {
  return (
    <Row xs={1} md ={2} className="g-4">
      {Array.from({length:4}).map((_,idx)=>(
        <Col key = {idx}>
          <Card>
            <Card.Body>
              <Card.Title></Card.Title>
              <Card.Text>some info about bonds</Card.Text>
            </Card.Body>
          </Card>
        </Col>
      ))}

    </Row>
  );
}

export default Home