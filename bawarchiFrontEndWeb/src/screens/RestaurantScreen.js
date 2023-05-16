import { Fragment, useEffect, useState } from "react";
import Header from "../components/Layout/Header";
import AppSummary from "../components/Meals/AppSummary";
import DishItem from "../components/Meals/ListItems/DishItem";
import OrderItem from "../components/Meals/ListItems/OrderItem";
import AddDishOverlay from "../components/Overlay/AddDishOverlay";
import Card from "../components/UI/Card";
import RestaurantController from "../controllers/RestaurantController";

import classes from "./SuperAdminScreen.module.css";

const RestaurantScreen = (props) => {
  const [dishes, setDishes] = useState([]);
  const [orders, setOrders] = useState([]);
  const [showDishOverlay, setDishOverlay] = useState(false);
  const [showOrders, setShowOrders] = useState(false);

  let displayList = "";

  useEffect(() => {
    async function getDishes() {
      try {
        const response = await RestaurantController.fetchDishes();
        console.log(response);
        setDishes(response);
      } catch (error) {
        alert(error.response.message);
      }
    }
    async function getPendingOrders() {
      try {
        const response = await RestaurantController.fetchOrders();
        console.log(response);
        setOrders(response);
      } catch (error) {
        alert(error.response.message);
      }
    }
    getDishes();
    getPendingOrders();
  }, [showDishOverlay]);

  const deleteDishHandler = async (dishId) => {
    try {
        const response = await RestaurantController.deleteDish(dishId);
        console.log(response);
      } catch (error) {
        alert(error.response.message);
      }
  }

  const placeOrderHandler = async (orderId) => {
    try {
        const response = await RestaurantController.placeOrder(orderId);
        console.log(response);
      } catch (error) {
        alert(error.response.message);
      }
  }

  const dishList = dishes.map((dish) => (
    <DishItem
      id={dish.dishId}
      name={dish.name}
      price={dish.price}
      category={dish.category}
      onDelete={deleteDishHandler}
    />
  ));

  const orderList = orders.map((order) => (
    <OrderItem
      id={order.orderId}
      dishes={order.dishList}
      price={order.totalPrice}
      tableNumber={order.tableNumber}
      onPlace={placeOrderHandler}
    />
  ));

  const switchScreenHandler = () => {
    setShowOrders(!showOrders);
  };

  //   displayList = dishList;
  const showDishOverlayHandler = () => {
    setDishOverlay(true);
  };

  const removeDishOverlayHandler = () => {
    setDishOverlay(false);
  };

  const newDishAdditionHandler = async (name, price, category) => {
    try {
      const response = await RestaurantController.addNewDish(
        name,
        price,
        category
      );
      console.log(response);
    } catch (error) {
      alert(error.response.message);
    }

    setDishOverlay(false);
    // console.log("data check kro ");
    // console.log(name);
    // console.log(price);
    // console.log(category);
  };

  if (!showOrders) {
    displayList = dishList;
  }
  if (showOrders) {
    displayList = orderList;
  }

  return (
    <Fragment>
      <Header
        role="ROLE_RESTAURANT"
        onActivate={showDishOverlayHandler}
        onSwitch={switchScreenHandler}
        switchHeaderButtons={!showOrders}
      />
      {showDishOverlay && (
        <AddDishOverlay
          onCancel={removeDishOverlayHandler}
          onAddingNewDish={newDishAdditionHandler}
        />
      )}
      <AppSummary />
      <section className={classes.meals}>
        <Card>
          <ul>{displayList}</ul>
        </Card>
      </section>
    </Fragment>
  );
};

export default RestaurantScreen;
