import React, { useState } from 'react';
import RegisterFoodCourt from '../controllers/RegisterFoodCourt';

export default function FoodCourtRegistrationForm(props) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [name, setName] = useState('');
  const [address, setAddress] = useState('');

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handleAddressChange = (event) => {
    setAddress(event.target.value);
  };

  const handleFailure = () => {
    alert('Registration failed.');
  };

  const handleSuccess = () => {
    alert('Registration Success.');
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log('Username:', username);
    console.log('Password:', password);
    console.log('Name:', name);
    console.log('Address:', address);


    const data = {
        "username": username,
        "password": password,
        "name": name,
        "address": address
    };

    RegisterFoodCourt.RegisterFC({
        data: data,
        success: handleSuccess,
        fail: handleFailure
    });

    // Reset form fields
    setUsername('');
    setPassword('');
    setName('');
    setAddress('');
  };

  return (
    <div>
      <div className="Container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Food Court Registration</h2>
            <form onSubmit={handleSubmit}>
              <div className="mb-4">
                <label htmlFor="username" className="form-label">
                  Username
                </label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter UserName"
                  name="username"
                  value={username}
                  onChange={handleUsernameChange}
                  autoComplete="off"
                />
              </div>
              <div className="mb-4">
                <label htmlFor="password" className="form-label">
                  Password
                </label>
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter Password"
                  name="password"
                  value={password}
                  onChange={handlePasswordChange}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="name" className="form-label">
                  Name
                </label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Name"
                  name="name"
                  value={name}
                  onChange={handleNameChange}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="address" className="form-label">
                  Address
                </label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Address"
                  name="address"
                  value={address}
                  onChange={handleAddressChange}
                />
              </div>
              <button type="submit" className="btn btn-outline-primary">
                Register
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
