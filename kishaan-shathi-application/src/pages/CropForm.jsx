import React, { useState } from 'react';
import '../assets/styles/cropform.css';
import { toast } from 'react-toastify';

const CropForm = ({ setModalVisible,selectedCrop }) => {
  const crop=selectedCrop
  const [formData, setFormData] = useState({
    cropId: crop.id,
    cropName: crop.name,
    cropType: '',
    cropImage: null,
    qualityGrade: '',
    cropSeason: '',
    soilType: '',
    irrigationType: '',
    description: ''
  });
  
  const [fileName, setFileName] = useState('');

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });

  };

  const handleImageChange = (e) => {
    setFormData({
      ...formData,
      cropImage: e.target.files[0]
    });
    const file = e.target.files[0];
    if (file) {
      setFileName(file.name); // Set the file name to display
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission, such as sending the data to an API or backend.
    console.log('Form Submitted: ', formData);
    toast.success("your crop added sucessfully!")
    setModalVisible(true);
  };

  return (
    <div className="crop-form-container">
      <h1>Add your crop</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <input
            type="text"
            name="cropId"
            placeholder='Crop ID'
            value={formData.cropId}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">
          <input
            type="text"
            name="cropName"
            placeholder='Crop Name'
            value={formData.cropName}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">
          <input
            type="text"
            name="cropType"
            placeholder='Crop Type'
            value={formData.cropType}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">
          <input
            type="text"
            name="qualityGrade"
            placeholder='Quality Grade'
            value={formData.qualityGrade}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">

          <input
            type="text"
            name="cropSeason"
            placeholder='Crop Season'
            value={formData.cropSeason}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">

          <input
            type="text"
            name="soilType"
            placeholder='Soil Type ( Optional )'
            value={formData.soilType}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">
          <input
            type="text"
            name="irrigationType"
            placeholder='Irrigation Type ( Optional )'
            value={formData.irrigationType}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">
          <textarea
            name="description"
            placeholder='Discribe your crop'
            value={formData.description}
            onChange={handleInputChange}
            required
          ></textarea>
        </div>
        <div className="form-group">
          <input
            type="file"
            id="cropImage"
            name="cropImage"
            accept="image/*"
            onChange={handleImageChange}
          />
          <label htmlFor="cropImage" className="custom-file-upload">
            Choose an image
          </label>
          {fileName && (
            <div className="file-name">
              <strong>Selected file:</strong> {fileName}
            </div>
          )}
        </div>
        <button type="submit" className="submit-button">
          Add Crop
        </button>
      </form>
    </div>
  );
};

export default CropForm;
