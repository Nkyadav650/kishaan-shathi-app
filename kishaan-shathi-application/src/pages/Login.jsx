import React from 'react'
import Button from 'react-bootstrap/Button';
import '../assets/styles/login.css'
import { FaHome } from "react-icons/fa";
import { TbPasswordUser } from "react-icons/tb";

const Login = () => {
    return (


        <div className='login-container'>
            <div className='one'>
            
            </div>
            <div className='login'>
                <h3 className='text-center'>LOG IN</h3>
                <form className="addUserForm">
                    <div className="inputGroup">

                        <input
                            type="text"
                            id="email"
                            autoComplete="off"
                            placeholder="Enter Email"
                        />
                        <FaHome className="form-control-icon" />
                    </div>

                    <div className="inputGroup">

                        <input
                            type="password"
                            id="password"
                            autoComplete="off"
                            placeholder="Enter Password"
                        />
                        <TbPasswordUser className="form-control-icon" />
                    </div>

                    <Button variant="success" type="submit" className="mt-2">
                        Login
                    </Button>
                </form>

                <div className='login d-flex justify-content-center p-0'>
                    <p className='mt-2'>Not Register?</p>
                    <Button variant="" type="submit" className=' loginbutton mb-2 p-1 text-color:red'>
                        Sign up
                    </Button>

                </div>


            </div>

        </div>


    )
}

export default Login