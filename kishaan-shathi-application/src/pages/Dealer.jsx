import React, { useEffect, useState } from "react";
import Base from "../layouts/Base";
import '../assets/styles/farmer.css'
import RegistrationForm from '../common/RegistrationForm';
import solutionsData from '../assets/json data/OurSolution.json';
import "react-responsive-carousel/lib/styles/carousel.min.css";
import carousel1 from "../assets/images/carousel1.png";
import carousel2 from "../assets/images/carousel2.jpg";
import carousel3 from "../assets/images/carousel3.jpg";
import axios from "axios";
import { toast } from "react-toastify";
import ImageSlider from "../common/ImageSlider.jsx";


const Dealer = () => {
  const [solutions, setSolutions] = useState([]);
  const title = "Dealer Registration";
  useEffect(() => {
    setSolutions(solutionsData.features);
  }, []);

  const carouselImages = [carousel1, carousel2, carousel3];

  const handleFormSubmit = async (formData) => {
    try {
      const authToken = localStorage.getItem('jwtToken');
      if (!authToken || authToken === 'undefined') {
        toast.error('Authentication token is missing. Please log in again.');
        return;
      }

      const fullAddress = `${formData.addressLine}, ${formData.city}, ${formData.state}, ${formData.pincode}, ${formData.country}`;
  
      const payload = {
        farmerId: formData.farmerId,
        name: formData.name,
        email: formData.email,
        phoneNumber: formData.phoneNumber,
        address: fullAddress,
      };
  
      const headers = {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${authToken}`,
      };
  
      const response = await axios.post(
        'http://localhost:2024/api/farmers/save',
        payload,
        { headers }
      );
      console.log('Response:', response.data);
    } catch (error) {
      console.error('Error saving farmer data:', error.response?.data || error.message);
      toast.error('Failed to save farmer data. Please try again.');
    }
  };

  const user=localStorage.getItem("userDetails");
  console.log("userDetails: ",user?.firstName);
  
  const initialFormData = {
    farmerId: "D003",
    name: '',
    email: '',
    phoneNumber: '',
    addressLine: '',
    city: '',
    state: '',
    pincode: '',
    country: '',
  };

  return (
    <Base>
      <div className="form-container">
        <ImageSlider images={carouselImages} />
        <RegistrationForm
        title={title}
          onSubmit={handleFormSubmit}
          initialFormData={initialFormData}
          solutions={solutions}
        />
      </div>
      <div>
        <h3>Our Vision</h3>
        <div className="solutions-container">
          {solutions.map((solution, index) => (
            <div key={index} className="solution-box">
              <h3>{solution.title}</h3>
              <p>{solution.description}</p>
            </div>
          ))}
        </div>
      </div>
    </Base>
  );
};

export default Dealer;
