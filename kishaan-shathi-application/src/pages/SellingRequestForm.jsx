import React, { useState } from 'react';
import '../assets/styles/cropform.css';
import { toast } from 'react-toastify';

const SellingRequestForm = ({ setModalVisible }) => {
    const user = localStorage.getItem("userDetails");
    const [isAddImage,setIsAddImage]= useState(false);
     const [fileName, setFileName] = useState('');
    const [formData, setFormData] = useState({
        requestId: '',
        cropId: '',
        cropType: '',
        quantity: '',
        cost: '',
        status: 'Available',
        sellerId: '',
        sellerName: '',
        pricePerUnit: '',
        unit: '',
        availableQuantity: '',
        minOrderQuantity: '',
        deliveryMethod: '',
        paymentTerms: '',
        description: '',
        sellerContact: '',
        harvestDate: '',
        isCertifiedOrganic: false,
        requestDate: '',
        expectedCompletionDate: ''
    });


    const handleInputChange = (e) => {
        const { name, value, type, checked } = e.target;

        if (type === 'checkbox') {
            setFormData({
                ...formData,
                [name]: checked
            });
            setIsAddImage(checked); // Show or hide the image input based on checkbox selection
        } else {
            setFormData({
                ...formData,
                [name]: value
            });
        }
    };

const handleImageChange = (e) => {
    setFormData({
      ...formData,
      certificate: e.target.files[0]
    });
    const file = e.target.files[0];
    if (file) {
      setFileName(file.name); // Set the file name to display
    }
  };
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form Submitted: ', formData);
       toast.success("Selling request successfully sent !")
        setModalVisible(false); // Close the modal after submission

    };

    return (
        <div className="crop-form-container">
            <h1>Submit a Selling Request</h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <input
                        type="text"
                        name="requestId"
                        placeholder="Request ID"
                        value={formData.requestId}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="cropId"
                        placeholder="Crop ID"
                        value={formData.cropId}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="cropType"
                        placeholder="Crop Type"
                        value={formData.cropType}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="number"
                        name="quantity"
                        placeholder="Quantity"
                        value={formData.quantity}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="number"
                        name="cost"
                        placeholder="Cost"
                        value={formData.cost}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="sellerId"
                        placeholder="Seller ID"
                        value={formData.sellerId}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="sellerName"
                        placeholder="Seller Name"
                        value={formData.sellerName}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="number"
                        name="pricePerUnit"
                        placeholder="Price per Unit"
                        value={formData.pricePerUnit}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="unit"
                        placeholder="Unit"
                        value={formData.unit}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="number"
                        name="availableQuantity"
                        placeholder="Available Quantity"
                        value={formData.availableQuantity}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="number"
                        name="minOrderQuantity"
                        placeholder="Min Order Quantity"
                        value={formData.minOrderQuantity}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="deliveryMethod"
                        placeholder="Delivery Method"
                        value={formData.deliveryMethod}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group">
                    <input
                        type="text"
                        name="paymentTerms"
                        placeholder="Payment Terms"
                        value={formData.paymentTerms}
                        onChange={handleInputChange}
                    />
                </div>


                <div className="form-group">
                    <input
                        type="text"
                        name="sellerContact"
                        placeholder="Seller Contact info ( email or mobile number )"
                        value={formData.sellerContact}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group-date">
                    <input
                        type="date"
                        name="harvestDate"
                        placeholder="Harvest Date"
                        value={formData.harvestDate}
                        onChange={handleInputChange}
                    />
                </div>


                <div className="form-group-date">
                    <input
                        type="date"
                        name="requestDate"
                        placeholder="Request Date"
                        value={formData.requestDate}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="form-group-date">
                    <input
                        type="date"
                        name="expectedCompletionDate"
                        placeholder="Expected Completion Date"
                        value={formData.expectedCompletionDate}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <textarea
                        name="description"
                        placeholder="Description"
                        value={formData.description}
                        onChange={handleInputChange}
                    ></textarea>
                </div>

                <div className="form-group-checkbox">   
                    <input
                        type="checkbox"
                        name="isCertifiedOrganic"
                        checked={formData.isCertifiedOrganic}
                        onChange={handleInputChange}
                    />
                    <label>Is Certified Organic?</label>
                </div>
                <div className="form-group">
                {isAddImage && (
                    <div className="form-group">
                        <input
                            type="file"
                            id="cropImage"
                            name="certificate"
                            accept="image/*"
                            onChange={handleImageChange}
                        />
                        <label htmlFor="cropImage" className="custom-file-upload">
                           Attach image
                        </label>
                        {fileName && (
                            <div className="file-name">
                                <strong>Selected file:</strong> {fileName}
                            </div>
                        )}
                    </div>
                )}
              </div>
                <button type="submit" className="submit-button">
                    Submit Request
                </button>
            </form>
        </div>
    );
};

export default SellingRequestForm;
