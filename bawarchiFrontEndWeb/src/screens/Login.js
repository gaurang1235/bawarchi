import React, { useState } from 'react'
import LoginController from '../controllers/LoginController';

export default function Login(props) {

    const [userType, setUserType] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleUserTypeChange = (event) => {
    setUserType(event.target.value);
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLoginFailure = () => {
    alert('Login failed. Please check your credentials.');
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Perform login logic here
    console.log('User type:', userType);
    console.log('Username:', username);
    console.log('Password:', password);

    const userData = {
        "role": userType,
        "username": username,
        "password": password,
    };


  
    LoginController.GetUserLoginData({
        userData: userData,
        loginHandler: props.onLogin,
        fail: handleLoginFailure
    });

    
    // Reset form fields
    setUserType('');
    setUsername('');
    setPassword('');


  };





    return (

        <div>
            <div className='Container'>
                <div className='row'>
                    <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                        <h2 className='text-center m-4'>Login</h2>
                        <form onSubmit={handleSubmit}>
                            <div className='mb-4'>
                                <label htmlFor="userType"  className='form-label'>User Type</label>
                                <select className="form-control" id="userType" value={userType} onChange={handleUserTypeChange}>
                                <option value="">Select User Type</option>
                                <option value="ROLE_SUPER_ADMIN">SuperAdmin</option>
                                <option value="ROLE_FOOD_COURT">FoodCourt</option>
                                <option value="ROLE_RESTAURANT">Restaurant</option>
                                </select>
                            </div>
                            <div className='mb-4'>
                                <label htmlFor='username' className='form-label'>
                                    Username
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Enter Your UserName"
                                    name="username"
                                    value={username}
                                    onChange={handleUsernameChange}
                                    autoComplete="off"
                                />
                            </div>
                            <div className='mb-4'>
                                <label htmlFor='password' className='form-label'>
                                    Password
                                </label>
                                <input
                                    type="password"
                                    className="form-control"
                                    placeholder="Enter Your Password"
                                    name="password"
                                    value={password}
                                    onChange={handlePasswordChange}
                                />
                            </div>
                            <button type="Login" className="btn btn-outline-primary">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
  );
}
