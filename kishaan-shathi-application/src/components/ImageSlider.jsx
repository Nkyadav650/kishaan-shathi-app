import React from "react";
import Slider from "react-slick";
import crop from "../assets/images/crop-sky.jpeg";
import wheatimg from "../assets/images/wheat.jpeg";
import farmer from "../assets/images/farmer.jpeg";
import grains from "../assets/images/grains.jpeg";
import yellowsky from "../assets/images/yellowsky.jpeg";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import '../assets/styles/imageSlider.css'

const ImageSlider = () => {
  const images = [crop, wheatimg, farmer, grains, yellowsky];
  const settings = {
    dots: true,
    infinite: true,
    speed: 1500,
    slidesToShow: 2,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
  };

  return (
    <div className="imageSlider">
    
        <Slider className='imageSlider'{...settings}>
        {images.map((image, index) => (
          <div key={index}>
            <img
              src={image}
              alt={`slide-${index}`}
              style={{ outline: 'none', border: 'none' }}
            />
          </div>
        ))}
        </Slider>
    </div>
  );
};

export default ImageSlider;
