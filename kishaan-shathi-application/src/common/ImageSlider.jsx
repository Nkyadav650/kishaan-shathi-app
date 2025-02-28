// src/components/CarouselComponent.js
import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import '../assets/styles/farmer.css'
const ImageSlider = ({ images }) => {
  return (
    <div className="carousel-section">
      <Carousel showThumbs={false} infiniteLoop autoPlay>
        {images.map((image, index) => (
          <div key={index}>
            <img src={image} alt={`Carousel Image ${index + 1}`} />
          </div>
        ))}
      </Carousel>
    </div>
  );
};

export default ImageSlider;
