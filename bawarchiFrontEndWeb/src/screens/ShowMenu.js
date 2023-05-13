import React, { useEffect, useState } from 'react'
import FetchRestaurantList from '../controllers/FetchRestaurantList';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import NewDish from './NewDish';


export default function ShowMenu(props) {

    const [users, setUsers] = useState([]);
    const [dish, setDish] = useState(0);

    

    useEffect(() => {
        
        const loadUsers = async () => {

            console.log(props.rest);
    
            FetchRestaurantList.RestaurantList({
                authId: props.rest.restaurantAuthId,
                setRestaurants: setUsers
            });
    
            console.log(users);
            
        }

        loadUsers();
        // eslint-disable-next-line
    }, [users, dish]);

    const handleButtonClick = () => {
          props.back(0);
      };

    const handleDishClick = () => {
        setDish(1);
    };

  return (
    <div>
        {dish===0 &&
        <div><div className="Container">
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
            <div className="py-4">


            <div><h2>Current Menu Dishes</h2></div>
            <Table striped bordered hover >
            <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Category</th>
                </tr>
            </thead>
            <tbody>
                {users.map((user, index) => (
                    <tr>
                        <td>{index+1}</td>
                        <td>{user.name}</td>
                        <td>{user.price}</td>
                        <td>{user.category}</td>
                    </tr>
                ))}
            </tbody>
            </Table>
            </div>
            <Button variant="primary" className="mb-3 d-block mx-auto" onClick={handleDishClick}>
                        Add New Dish
                    </Button>
            <Button variant="primary" onClick={handleButtonClick}>
                        Go Back
                    </Button>
            </div>
        </div>
    </div>

        }

        {dish===1 && <NewDish authId= {props.rest.restaurantAuthId} back={setDish}/>

        }
    </div>
  )
}
