import React from 'react'
import '../assets/styles/base.css'
import Footer from "./footer";
import Header from './header';

const Base = ({children}) => {
  return (
   <div className='base-layout'>
       <Header/>
      <div className='children'>
        {children}
      </div>
       <Footer/>  
   </div>
  )
}

export default Base
