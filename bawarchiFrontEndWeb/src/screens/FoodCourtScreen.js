import { Fragment, useEffect, useState } from "react";
import Header from "../components/Layout/Header";
import AppSummary from "../components/Meals/AppSummary";
import RestaurantItem from "../components/Meals/ListItems/RestaurantItem";
import AddRestaurantOverlay from "../components/Overlay/AddRestaurantOverlay";
import Card from "../components/UI/Card";
import FoodCourtController from "../controllers/FoodCourtController";

import classes from "./SuperAdminScreen.module.css";

const FoodCourtScreen = () => {
  const [restaurants, setRestaurants] = useState([]);
  const [showRestaurantOverlay, setRestaurantCourtOverlay] = useState(false);

  useEffect(() => {
    async function getRestaurants() {
      try {
        const response = await FoodCourtController.fetchRestaurants();
        console.log(response);
        setRestaurants(response);
      } catch (error) {
        alert(error.response.message);
      }
    }
    getRestaurants();
  }, [showRestaurantOverlay]);

  const showRestaurantOverlayHandler = () => {
    setRestaurantCourtOverlay(true);
  };

  const removeRestaurantOverlayHandler = () => {
    setRestaurantCourtOverlay(false);
  };

  const newRestaurantAdditionHandler = async (
    username,
    password,
    name,
    contact
  ) => {
    try {
      const response = await FoodCourtController.addNewRestaurant(
        username,
        password,
        name,
        contact
      );
      console.log(response);
    } catch (error) {
      alert(error.response.message);
    }

    setRestaurantCourtOverlay(false);
    // console.log("data check kro ");
    // console.log(name);
    // console.log(price);
    // console.log(category);
  };

  const deleteRestaurantHandler = async (restaurantId) => {
    try {
      const response = await FoodCourtController.deleteRestaurant(restaurantId);
      console.log(response);
    } catch (error) {
      alert(error.response.message);
    }
  };

  const restaurantList = restaurants.map((restaurant) => (
    <RestaurantItem
      id={restaurant.authId}
      name={restaurant.name}
      contact={restaurant.contact}
      onDelete={deleteRestaurantHandler}
    />
  ));

  return (
    <Fragment>
      <Header
        role="ROLE_FOOD_COURT"
        onActivate={showRestaurantOverlayHandler}
      />
      {showRestaurantOverlay && (
        <AddRestaurantOverlay
          onCancel={removeRestaurantOverlayHandler}
          onAddingNewRestaurant={newRestaurantAdditionHandler}
        />
      )}
      <AppSummary />
      <section className={classes.meals}>
        <Card>
          <ul>{restaurantList}</ul>
        </Card>
      </section>
    </Fragment>
  );
};

export default FoodCourtScreen;
