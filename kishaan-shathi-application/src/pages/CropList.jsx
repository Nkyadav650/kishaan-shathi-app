import React, { useState, useEffect } from 'react';
import '../assets/styles/croplist.css';
import Base from '../layouts/Base';
import CropForm from './CropForm';
import SellingRequestForm from './SellingRequestForm';

const CropList = () => {
  const [crops, setCrops] = useState([]);
  const [modalVisible, setModalVisible] = useState(true); // Initially hide the modal
  const [selectedCrop, setSelectedCrop] = useState(null); // Store the selected crop

  useEffect(() => {
    const cropData = [
      {
        id: 1,
        name: 'Wheat',
        priceRange: '$10 - $15 per kg',
        image: 'https://picsum.photos/200/300/?blur',
      },
      {
        id: 2,
        name: 'Rice',
        priceRange: '$8 - $12 per kg',
        image: 'https://picsum.photos/200/300/?blur',
      },
      {
        id: 3,
        name: 'Corn',
        priceRange: '$6 - $10 per kg',
        image: 'https://picsum.photos/200/300/?blur',
      },
      {
        id: 4,
        name: 'Tomatoes',
        priceRange: '$3 - $5 per kg',
        image: 'https://picsum.photos/200/300/?blur',
      },
      {
        id: 5,
        name: 'Potatoes',
        priceRange: '$4 - $6 per kg',
        image: 'https://picsum.photos/200/300/?blur',
      },
    ];
    setCrops(cropData);
  }, []);

  const handleCropSelect = (crop) => {
    setSelectedCrop(crop);
    setModalVisible(false); // Show the modal when a crop is selected
  };

  return (
    <Base>
      {modalVisible ? (
        <div className="crop-container">
          <h1>Choose Crops to Sale</h1>
          <div className="crop-list">
            {crops.map((crop) => (
              <button
                key={crop.id}
                className="choose-crop"
                onClick={() => handleCropSelect(crop)} // Select crop on click
              >
                <div className="crop-card">
                  <img src={crop.image} alt={crop.name} className="crop-image" />
                  <div className="crop-details">
                    <h3 className="crop-name">{crop.name}</h3>
                    <p className="crop-price">{crop.priceRange}</p>
                  </div>
                </div>
              </button>
            ))}
          </div>
        </div>
      ) : (
        // <CropForm setModalVisible={setModalVisible} selectedCrop={selectedCrop} /> // Pass the selected crop to CropForm
     <SellingRequestForm setModalVisible={setModalVisible} />
      )}
    </Base>
  );
};

export default CropList;
