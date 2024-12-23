import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import '../assets/styles/signup.css';
import validate from '../utils/validations';
import { saveStudentApi } from '../utils/ApiServices';
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';

const Signup = () => {
    const initialValues = { userId: "", email: "", name: "", password: "", phoneNumber: "" };
    const [formValues, setFormValues] = useState(initialValues);
    const [formErrors, setFormErrors] = useState({});
    const [errorMessage, setErrorMessage] = useState(null);

    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("inside handle submit")
        const errors = validate(formValues, 'signup');
        setFormErrors(() => errors)
        console.log("formerror- ", formErrors);
        if (Object.keys(errors).length === 0) {
            console.log("if block in signup ")
            saveStudentApi(formValues) //api invoking
                .then((response) => {
                    console.log("RES: ", response)
                    if (response.data.status === 'SUCCESS' && response.data.statusCode === 201) {
                        console.log("Student saved successfully:", response.data);
                        toast.success("registration successfull")
                        navigate("/login");
                    } else {
                        setErrorMessage("Registration failed. Please try again.");
                    }
                })
                .catch((error) => {
                    console.error("Error saving student:", error);
                    setErrorMessage("Registration failed. Please try again.");
                });
        }
    };

    return (

        <div className='container1'>

            <div className='one'>f</div>

            <div className='sinup'>

                <h1 className='text-center'>SIGN UP</h1>
                <form className='addUserForm' onSubmit={handleSubmit}>
                    <div className='inputGroup'>
                        {/* <label htmlFor='userId'>User ID</label> */}
                        <input
                            type="text"
                            name="userId"
                            id="userId"
                            autoComplete='off'
                            placeholder='Enter UserId'
                            onChange={handleChange}
                            className='input-field'
                        />
                        <p className='error-display'>{formErrors.userId}</p>
                        {/* <label htmlFor='email'>Email</label> */}
                        <input
                            type="text"
                            name="email"
                            id="email"
                            autoComplete='off'
                            placeholder='Enter Email'
                            onChange={handleChange}
                        />
                        <p className='error-display'>{formErrors.email}</p>
                        {/* <label htmlFor='name'>Name</label> */}
                        <input
                            type="text"
                            name="name"
                            id="name"
                            autoComplete='off'
                            placeholder='Enter Name'
                            onChange={handleChange}
                        />
                        <p className='error-display'>{formErrors.name}</p>
                        {/* <label htmlFor='password'>Password</label> */}
                        <input
                            type="password"
                            name="password"
                            id="password"
                            autoComplete='off'
                            placeholder='Enter Password'
                            onChange={handleChange}
                        />
                        <p className='error-display'>{formErrors.password}</p>
                        {/* <label htmlFor='phoneNumber'>Phone Number</label> */}
                        <input
                            type="text"
                            name="phoneNumber"
                            id="phoneNumber"
                            autoComplete='off'
                            placeholder='Enter Phone Number'
                            onChange={handleChange}
                        />
                        <p className='error-display'>{formErrors.phoneNumber}</p>
                        <Button variant="success" type="submit" className='mt-2'>
                            Submit
                        </Button>
                    </div>

                </form>

                <div className='login d-flex justify-content-center p-0'>
                    <p className='mt-2'>Already have account?</p>
                    <button type='submit' className='login-btn ' onClick={() => navigate('/login')}>login</button>

                </div>
                {errorMessage && <p style={{ color: "red", marginTop: "20px" }}>{errorMessage}</p>}
            </div>
        </div>
    );
};

export default Signup;
