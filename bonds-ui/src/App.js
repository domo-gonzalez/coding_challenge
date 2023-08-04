import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import BondDetail from './components/BondDetail';
import AllBonds from './components/AllBonds';
import { Routes, Route } from 'react-router';
import Home from './components/Home';

function App() {
  return (
    <>
    
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="/home">Home</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/allbonds">All Bonds</Nav.Link>
            <Nav.Link href="#link">Login</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    
    <Routes>
      <Route path="home" element={<Home/>} />
      <Route path="allbonds" element={<AllBonds/>} />
    </Routes>
    </>

  );
}

export default App;
