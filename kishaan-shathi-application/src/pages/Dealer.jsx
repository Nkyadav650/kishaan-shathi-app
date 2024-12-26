import React, { useEffect, useState } from 'react';
import Base from '../layouts/Base'
import '../assets/styles/dealer.css'



const Dealer = () => {

  const [formData, setFormData] = useState({
    dealerId: 'F002',
    name: '',
    email: '',
    phoneNumber: '',
    address: ''
  });
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };
   // Handle form submission
   const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Farmer Registration Data:', formData);

    // You can send this data to an API or server here

    alert('Registration Successful!');
  };
  return (
    <div>
      <Base>
        <div className="form-container">
          <h2>Dealer Registration</h2>
          <form onSubmit={handleSubmit}>
            {/* Farmer ID - Readonly */}
            <div className="input-group">
              <input
                type="text"
                name="dealerId"
                value={formData.dealerId}
                readOnly
                className="input-field"
                placeholder="Farmer ID"
              />
            </div>

            {/* Name */}
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

            {/* Email */}
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

            {/* Phone Number */}
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

            {/* Address Line */}
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
            {/* Submit Button */}
            <div>
              <button type="submit" className="submit-button">Register</button>
            </div>
          </form>
        </div>
        </Base>
    </div>
  )
}

export default Dealer