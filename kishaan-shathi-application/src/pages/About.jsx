import React, { useEffect, useState } from 'react'
import Base from '../layouts/Base'
import AboutData from "../assets/json data/About.json"
import { Key } from '@mui/icons-material';
const About = () => {
const [aboutData,setAboutData] = useState([]);
useEffect(()=>{
    setAboutData(AboutData.about)
})
  return (
    <div>
    <Base>
    <div>
    {aboutData.map((data, index) => (
        <div key={index} className="solution-box">
          <h3>{data.title}</h3>
          <p>{data.description}</p>
        </div>
      ))}
    </div>
    </Base>
    </div>
  )
}

export default About