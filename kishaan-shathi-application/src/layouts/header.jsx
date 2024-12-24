import React from 'react';
import '../assets/styles/header.css'; // Add your custom styles
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';


const Header = () => {
  return (
    <div>
      <Navbar bg="success" variant="dark" expand="lg" fixed="top">
        <Container>
          <Navbar.Brand href="#home">FarmTrade</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbar-nav" />
          {/* Search Bar */}
         
          <input
            type="search"
            placeholder="Search"
            className="search-bar"
            italic-label="Search"
          />
         
     
          <Navbar.Collapse id="navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link href="#home" icon='home' >Home</Nav.Link>
              <Nav.Link href="#buy">Buy Crops</Nav.Link>
              <Nav.Link href="#sell">Sell Crops</Nav.Link>
              <Nav.Link href="#contact">Contact</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}

export default Header;
