import React from 'react'
import Base from '../layouts/Base'
import ImageSlider from '../components/ImageSlider'
import '../assets/styles/Home.css'


const Home = () => {
  return (
    <Base>
      <div className='base-container'>
        <div>
          <ImageSlider />
        </div>
        <div className='btn'>
          <button className='btn1'>Farmer</button>
          <button className='btn2'>Dealer</button>
        </div>


        <div className='content'>
          <p>
            Kishaan Shathi is dedicated to uplifting farmers by providing innovative solutions and a comprehensive support system. From crop management to market access, we are here to assist you every step of the way.
            Our goal is to make agriculture profitable and rewarding for all.
          </p>
          <p>
            Meet the farmers who have transformed their livelihoods with Kishaan Shathi. From small-scale growers to large-scale producers, their stories of success are a testament to the power of innovation and support.
          </p>
          <p>
            Explore our extensive library of resources designed to educate and inform. Learn about sustainable farming, crop care techniques, and government subsidies to make informed decisions.
          </p>
          <p>
            Stay ahead with the latest news in agriculture. From new government schemes to breakthroughs in farming technology, Kishaan Shathi keeps you informed and inspired.
          </p>
          <p>
            Have questions? Need assistance? Reach out to our dedicated support team. Whether it’s technical help or farming advice, we’re here to serve you.
          </p>

        </div>
      </div>
    </Base>

  )
}

export default Home