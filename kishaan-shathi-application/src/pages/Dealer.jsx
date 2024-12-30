import React, { useState } from "react";
import Base from "../layouts/Base";
import "../assets/styles/dealer.css";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import carousel1 from "../assets/images/carousel1.png";
import carousel2 from "../assets/images/carousel2.jpg";
import carousel3 from "../assets/images/carousel3.jpg";



const Dealer = () => {
  const [formData, setFormData] = useState({
    dealerId: "D001",
    name: "",
    email: "",
    phoneNumber: "",
    addressLine: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Dealer Registration Data:", formData);
    alert("Registration Successful!");
  };

  const carouselImages = [
    carousel1,
    carousel2,
    carousel3,
  ];

  return (
    <div>
      <Base>
        <div className="dealer-container">
          {/* Carousel Section */}
          <div className="carousel-section">
            <Carousel showThumbs={false} infiniteLoop autoPlay>
              {carouselImages.map((image, index) => (
                <div key={index}>
                  <img src={image} alt={`Carousel Image ${index + 1}`} />
                </div>
              ))}
            </Carousel>
          </div>

          {/* Dealer Registration Form Section */}
          <div className="form-section">
            <h2>Dealer Registration</h2>
            <form onSubmit={handleSubmit}>
              <div className="input-group">
                <input
                  type="text"
                  name="dealerId"
                  value={formData.dealerId}
                  readOnly
                  className="input-field"
                  placeholder="Dealer ID"
                />
              </div>
              <div className="input-group">
                <input
                  type="text"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                  placeholder="Enter your name"
                  required
                  className="input-field"
                />
              </div>
              <div className="input-group">
                <input
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  placeholder="Enter your email"
                  required
                  className="input-field"
                />
              </div>
              <div className="input-group">
                <input
                  type="tel"
                  name="phoneNumber"
                  value={formData.phoneNumber}
                  onChange={handleChange}
                  placeholder="Enter your phone number"
                  required
                  className="input-field"
                />
              </div>
              <div className="input-group">
                <input
                  type="text"
                  name="addressLine"
                  value={formData.addressLine}
                  onChange={handleChange}
                  placeholder="Enter address line"
                  required
                  className="input-field"
                />
              </div>
              <div>
                <button type="submit" className="submit-button">
                  Register
                </button>
              </div>
            </form>
          </div>
        </div>
      </Base>
    </div>
  );
};

export default Dealer;
