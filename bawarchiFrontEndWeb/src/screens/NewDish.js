import React, { useState } from 'react';
import AddNewDish from '../controllers/AddNewDish';

export default function NewDish(props) {
  const [name, setName] = useState('');
  const [price, setPrice] = useState();
  const [category, setCategory] = useState('');

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handlePriceChange = (event) => {
    setPrice(event.target.value);
  };

  const handleCategoryChange = (event) => {
    setCategory(event.target.value);
  };

  const handleFailure = () => {
    alert('Registration failed.');
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log('Name:', name);
    console.log('Price:', price);
    console.log('Category:', category);

    const data = {
      "name": name,
      "price": price,
      "category": category
    };

    AddNewDish.NewDish({
      authId: props.authId,
      data: data,
      success: props.back,
      fail: handleFailure
    });

    // Reset form fields
    setName('');
    setPrice();
    setCategory('');
  };

  return (
    <div>
      <div className="Container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Dish Registration</h2>
            <form onSubmit={handleSubmit}>
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
                  autoComplete="off"
                />
              </div>
              <div className="mb-4">
                <label htmlFor="price" className="form-label">
                  Price
                </label>
                <input
                  type="number"
                  className="form-control"
                  placeholder="Enter Price"
                  name="price"
                  value={price}
                  onChange={handlePriceChange}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="category" className="form-label">
                  Category
                </label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Category"
                  name="category"
                  value={category}
                  onChange={handleCategoryChange}
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
