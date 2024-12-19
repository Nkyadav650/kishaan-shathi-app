import React from 'react';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import '../assets/styles/signup.css';
import { FaUserAlt, FaLock, FaHome } from 'react-icons/fa';
import { MdEmail } from 'react-icons/md';

const Signup = () => {
    return (
        <div className='container1'>

            <div className='one'>f</div>
            <div className='sinup'>
                <h1 className='text-center'>SIGN UP</h1>
                <form className='addUserForm'>
                    <div className='inputGroup'>
                        <label htmlFor='usedId'>User ID</label>
                        <input
                            type="text"
                            id="userid"
                            autoComplete='off'
                            placeholder='Enter UserId'
                        />
                        
                        <label htmlFor='usedId'>Email</label>
                        <input
                            type="text"
                            id="email"
                            autoComplete='off'
                            placeholder='Enter Email'
                        />
                        <label htmlFor='usedId'>Name</label>
                        <input
                            type="text"
                            id="name"
                            autoComplete='off'
                            placeholder='Enter Name'
                        />
                        <label htmlFor='usedId'>Password</label>
                        <input
                            type="password"
                            id="password"
                            autoComplete='off'
                            placeholder='Enter Password'
                        />
                        <label htmlFor='usedId'>Phone Number</label>
                        <input
                            type="text"
                            id="phonenumber"
                            autoComplete='off'
                            placeholder='Enter Phone Number'
                        />
                        <Button variant="success" type="submit" className='mt-2'>
                            Submit
                        </Button>
                    </div>

                </form>
              
                <div className='login d-flex justify-content-center p-0'>
                    <p className='mt-2'>Already have account?</p>
                    <Button variant="" type="submit" className=' loginbutton mb-2 p-1 text-color:red'>
                            Login
                        </Button>

                </div>

            </div>
            

        </div>
    );
};

export default Signup;
