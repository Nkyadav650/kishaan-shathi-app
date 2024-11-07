import React from 'react'
import Navbar from './Navbar'
import Footer from './Footer'

const Base = ({ children }) => {
    return (
        <>
            <div><Navbar /></div>
            <div>{children}</div>
            <div><Footer/></div>
        </>
    )
}

export default Base