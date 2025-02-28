


import React from 'react';
import '../assets/styles/Header.css'; // Add your custom styles
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import logo from '../assets/images/logo.jpg';
import { useThemeContext } from "../utils/ThemeContext";
import { IconButton } from "@mui/material";
import {
  WbSunny,
  NightsStay,
} from "@mui/icons-material";
import { Link, useNavigate } from 'react-router-dom';




const Header = () => {
  const { toggleTheme, darkMode } = useThemeContext();
  const navigate = useNavigate();
  const logout = () => {
    navigate("/");
  }
  return (

    <div>
      <Navbar bg="success" variant="dark" expand="lg" fixed="top">

        <img src={logo} alt='not-found' width='50px' height='40px' style={{ objectFit: 'contain' }}></img>
        <Container className="d-flex justify-content-between">
          <Navbar.Brand as={Link} to="/home">FarmTrade</Navbar.Brand>
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
              <Nav.Link as={Link} to="/home" icon='home' >Home</Nav.Link>
              <Nav.Link as={Link} to="/about">About</Nav.Link>
              <Nav.Link as={Link} to="/croplist">Sell</Nav.Link>
              <Nav.Link as={Link} to="/service">Buy</Nav.Link>
              <Nav.Link as={Link} to="/contact">Contact</Nav.Link>
              <Nav.Link as={Link} to="/profile">Profile</Nav.Link>
              <Nav.Link onClick={() => logout()}>Logout</Nav.Link>
              {/* Theme Toggle */}
              <IconButton color="inherit" onClick={toggleTheme}>
                {darkMode ? <WbSunny /> : <NightsStay />}
              </IconButton>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>

  );
}

export default Header;
