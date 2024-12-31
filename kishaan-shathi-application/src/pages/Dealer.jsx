import React, { useState } from "react";
import Base from "../layouts/Base";
import "../assets/styles/dealer.css";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import carousel1 from "../assets/images/carousel1.png";
import carousel2 from "../assets/images/carousel2.jpg";
import carousel3 from "../assets/images/carousel3.jpg";
import axios from "axios";
import { toast } from "react-toastify";


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

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Fetch the token from localStorage
      const authToken = localStorage.getItem("jwtToken");
      console.log("Authentication token: " + authToken);

      // Check if the token exists
      if (!authToken || authToken === "undefined") {
        toast.error("Authentication token is missing. Please log in again.");
        return;
      }


      // Prepare the payload for the API request
      const payload = {
        dealerId: formData.dealerId,
        name: formData.name,
        email: formData.email,
        phoneNumber: formData.phoneNumber,
        address: formData.addressLine,
      };

      // Define the headers with Authorization Bearer token
      const headers = {
        "Content-Type": "application/json",
        Authorization: `Bearer ${authToken}`, // Using token from localStorage
      };

      // Make the API request to save the dealer data
      const response = await axios.post(
        "http://localhost:2024/api/dealers/save",
        payload,
        { headers }
      );

      console.log("Response:", response.data);
      toast.success("Dealer Registration Successful!");
    } catch (error) {
      console.error(
        "Error saving dealer data:",
        error.response?.data || error.message
      );
      toast.error("Failed to save dealer data. Please try again.");
    }
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
