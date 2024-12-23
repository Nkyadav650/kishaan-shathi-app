import Base from '../layouts/Base'
import React, { useState } from 'react';
import '../assets/styles/farmer.css'
const Farmer = () => {

    // Initialize state for form fields
    const [formData, setFormData] = useState({
        farmerId: 'F002',
        name: '',
        email: '',
        phoneNumber: '',
        address: ''
    });

    // Handle change in form input fields
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
            <h2>Farmer Registration</h2>
            <form onSubmit={handleSubmit}>
              {/* Farmer ID - Readonly */}
              <div className="input-group">
                <input
                  type="text"
                  name="farmerId"
                  value={formData.farmerId}
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
      
              {/* City and State in the same row */}
              <div className="input-group-row">
                <div className="input-group-left">
                  <input
                    type="text"
                    name="city"
                    value={formData.city}
                    onChange={handleChange}
                    placeholder="Enter city"
                    required
                    className="input-field"
                  />
                </div>
                <div className="input-group-right">
                  <input
                    type="text"
                    name="state"
                    value={formData.state}
                    onChange={handleChange}
                    placeholder="Enter state"
                    required
                    className="input-field"
                  />
                </div>
              </div>
      
              {/* Pincode and Country in the same row */}
              <div className="input-group-row">
                <div className="input-group-left">
                  <input
                    type="text"
                    name="pincode"
                    value={formData.pincode}
                    onChange={handleChange}
                    placeholder="Enter pincode"
                    required
                    className="input-field"
                  />
                </div>
                <div className="input-group-right">
                  <input
                    type="text"
                    name="country"
                    value={formData.country}
                    onChange={handleChange}
                    placeholder="Enter country"
                    required
                    className="input-field"
                  />
                </div>
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

export default Farmer