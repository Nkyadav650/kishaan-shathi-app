// src/components/RegistrationForm.js
import React, { useState } from 'react';
import { toast } from 'react-toastify';


const RegistrationForm = ({ onSubmit, initialFormData,title }) => {
  const [formData, setFormData] = useState(initialFormData);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Handle submit using onSubmit prop
    try {
      await onSubmit(formData);
      toast.success("Registration Successful!");
    } catch (error) {
      toast.error("Failed to save farmer data. Please try again.");
    }
  };

  return (
    <div className="form-section">
      <h2>{title}</h2>
      <form onSubmit={handleSubmit}>
        {/* Farmer ID - Readonly */}
        <div className="input-group">
          <input
            type="text"
            name="farmerId"
            value={formData.farmerId}
            readOnly
            className="input-field"
            placeholder="User ID"
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
          <button type="submit" className="submit-button">
            Register
          </button>
        </div>
      </form>
    </div>
  );
};

export default RegistrationForm;
