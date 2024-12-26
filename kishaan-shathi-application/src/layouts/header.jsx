import React from 'react'
import '../assets/styles/Header.css'
import logo from '../assets/images/logo.jpg'
import { Grid } from '@mui/material';
import { Link } from 'react-router-dom';
// import Container from 'react-bootstrap/Container';
// import Nav from 'react-bootstrap/Nav';
// import Navbar from 'react-bootstrap/Navbar';

const header = () => {
  return (
    <div className='navbar'>
      <Grid container alignItems='center' spacing={2}>
        <Grid item xs={8}>
        <img src={logo} alt='not-found' className='navbar-logo'></img>
        </Grid>
        <Grid item xs={4} gap='40px' display='flex'>
          <Link className='nav-link' to='/home'>Home</Link>
         
          <Link className='nav-link' to='/features'>Features</Link>
          <Link className='nav-link' to='/price'>Pricing</Link>
          <Link className='nav-link' to='/price'>Pricing</Link>
    
        </Grid>
      </Grid>


    
    
  
  </div>
  );
}

export default header;
