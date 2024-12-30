import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import '../assets/styles/login.css'
import validate from '../utils/validations';
import { loginApi } from '../service/ApiServices';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import { IoMdEye } from "react-icons/io";  //open eye
import { IoIosEyeOff } from "react-icons/io";// close eye

const Login = () => {
    const initialValues = { username: "", password: "" };
    const [formValues, setFormValues] = useState(initialValues);
    const [formErrors, setFormErrors] = useState({});
    const [errorMessage, setErrorMessage] = useState(null);
    const [passwordVisible, setPasswordVisible] = useState(false);
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
    };

    // Handle form submission
    const handleSubmit = async (e) => {

        e.preventDefault();
        setFormErrors(validate(formValues, 'login'));
        console.log("inside handlesubmit")

        if (Object.keys(formErrors).length === 0) {
            console.log("if block ")
            try {
                const response = await loginApi(formValues); //api invoking
                console.log("res: ", response)
                if (response.data.error || ![200, 201].includes(response.status)) {
                    setErrorMessage("Login failed. Please try again.");
                } else {
                    const { jwtToken, refreshToken } = response.data.result[0];
                    console.log("token: ", jwtToken)

                    localStorage.setItem('jwtToken', jwtToken);
                    localStorage.setItem('refreshToken', refreshToken);
                    toast.success("Login successful!");

                    console.log("Login successful!");
                    navigate('/home');

                }
            } catch (error) {
                setErrorMessage(
                    error.response?.data?.message || "Login falied"
                );
            }
        }
        //  setIsSubmit(true);
    };


    return (

        <div className='login-container'>
            <div className='one'>
            
            </div>
            <div className='login'>
                <h3 className='text-center'>LOG IN</h3>
                <form className="addUserForm" onSubmit={handleSubmit}>
                    <div className="inputGroup">

                        <input
                            type="text"
                            name="username"
                            id="email"
                            autoComplete="off"
                            placeholder="Enter Email"
                            onChange={handleChange}
                        />

                    </div>
                    <p className='error-display'>{formErrors.username}</p>

                    <div className="inputGroup">

                        <input
                            type={passwordVisible ? "text" : "password"}
                            name="password"
                            id="password"
                            autoComplete="off"
                            placeholder="Enter Password"
                            onChange={handleChange}
                        />
                        <span className='password-eye'
                            onClick={() => setPasswordVisible(!passwordVisible)}>
                            {passwordVisible ? <IoMdEye /> : <IoIosEyeOff />}
                        </span>

                    </div>
                    <p className='error-display'>{formErrors.password}</p>
                    {errorMessage && <p className="error-display">{errorMessage}</p>}
                    <Button variant="success" type="submit" className="mt-2 w-100">
                        Login
                    </Button>
                </form>

                <div className='login d-flex justify-content-center p-0'>
                    <p className='mt-2'>Register?</p>
                    <button type='submit' className='signup-btn ' onClick={() => navigate('/signup')}
                    >Sign up</button>

                </div>


            </div>

        </div>


    )
}

export default Login