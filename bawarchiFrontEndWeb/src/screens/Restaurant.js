import React, { useState } from 'react'
import ShowMenu from './ShowMenu';

import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';



export default function Restaurant(props) {

    const [showMenu, setMenu] = useState(0);
    const [showOrders, setOrders] = useState(0);



    const handleMenuClick = () => {
        setMenu(1);
    };

    const handleOrderClick = () => {
        setOrders(1);
    };
    


  return (
    <div>
        {showMenu===0 && showOrders===0 && 
        <div>
        <Container>
      <Col
        md={6}
        className="offset-md-3 border rounded p-4 mt-2 shadow text-center"
      >
        <div className="py-5">
          <Button variant="primary" className="mb-3 d-block mx-auto" onClick={handleMenuClick}>
            View/Modify Menu
          </Button>
          <Button variant="primary" className="d-block mx-auto" onClick={handleOrderClick}>
            Go To View Orders Page
          </Button>
        </div>
      </Col>
    </Container>
    </div>
    }
    {showMenu===1 && <ShowMenu rest={props.rest} back={setMenu}/>
    }

    </div>
  )
}
