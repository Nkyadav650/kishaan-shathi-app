import React from 'react';
import '../assets/styles/header.css'; // Add your custom styles
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import logo from '../assets/images/logo.jpg'


const Header = () => {
  return (
    <div>
      <Navbar bg="success" variant="dark" expand="lg" fixed="top">

      <img src={logo} alt='not-found' width='50px' height='40px' style={{objectFit:'contain'}}></img>
        <Container  className="d-flex justify-content-between">
          <Navbar.Brand href="#home">FarmTrade</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbar-nav" />
          {/* Search Bar */}
         
          <input
            type="search"
            placeholder="Search"
            className="search-bar"
            italic-label="Search"
          />
         
     
          <Navbar.Collapse >
            <Nav id="navbar-nav">
            <Nav.Link href="#home" icon='home' >Home</Nav.Link>
            <Nav.Link href="#buy">About</Nav.Link>
            <Nav.Link href="#sell">Service</Nav.Link>
            <Nav.Link href="#contact">Contact</Nav.Link>
            <Nav.Link href="#contact">Profile</Nav.Link>
            <Nav.Link href="#contact">LogOut</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}

export default Header;
