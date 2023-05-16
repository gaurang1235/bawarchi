import classes from "./SuperAdminScreen.module.css";

import Card from "../components/UI/Card";
import { Fragment, useEffect, useState } from "react";
import AppSummary from "../components/Meals/AppSummary";
import SuperAdminController from "../controllers/SuperAdminController";
import FoodCourtItem from "../components/Meals/ListItems/FoodCourtItem";
import Header from "../components/Layout/Header";
import AddFoodCourtOverlay from "../components/Overlay/AddFoodCourtOverlay";

const SuperAdminScreen = () => {
  const [foodCourts, setFoodCourts] = useState([]);
  const [showFoodCourtOverlay, setFoodCourtOverlay] = useState(false);

  useEffect(() => {
    async function getFoodCourts() {
      try {
        const response = await SuperAdminController.fetchFoodCourts();
        console.log(response);
        setFoodCourts(response);
      } catch (error) {
        alert(error.response.message);
      }
    }
    getFoodCourts();
  }, [showFoodCourtOverlay]);

  const showFoodCourtOverlayHandler = () => {
    setFoodCourtOverlay(true);
  };

  const removeFoodCourtOverlayHandler = () => {
    setFoodCourtOverlay(false);
  };

  const newFoodCourtAdditionHandler = async (
    username,
    password,
    name,
    address
  ) => {
    try {
      const response = await SuperAdminController.addNewFoodCourt(
        username,
        password,
        name,
        address
      );
      console.log(response);
    } catch (error) {
      alert(error.response.message);
    }

    setFoodCourtOverlay(false);
    // console.log("data check kro ");
    // console.log(name);
    // console.log(price);
    // console.log(category);
  };

  const deleteFoodCourtHandler = async (foodCourtId) => {
    try {
      const response = await SuperAdminController.deleteFoodCourt(foodCourtId);
      console.log(response);
    } catch (error) {
      alert(error.response.message);
    }
  };

  const foodCourtList = foodCourts.map((foodCourt) => (
    <FoodCourtItem
      id={foodCourt.authId}
      name={foodCourt.name}
      description={foodCourt.address}
      onDelete={deleteFoodCourtHandler}
    />
  ));

  return (
    <Fragment>
      <Header
        role="ROLE_SUPER_ADMIN"
        onActivate={showFoodCourtOverlayHandler}
      />
      {showFoodCourtOverlay && (
        <AddFoodCourtOverlay
          onCancel={removeFoodCourtOverlayHandler}
          onAddingNewFoodCourt={newFoodCourtAdditionHandler}
        />
      )}
      <AppSummary />
      <section className={classes.meals}>
        <Card>
          <ul>{foodCourtList}</ul>
        </Card>
      </section>
    </Fragment>
  );
};

export default SuperAdminScreen;
