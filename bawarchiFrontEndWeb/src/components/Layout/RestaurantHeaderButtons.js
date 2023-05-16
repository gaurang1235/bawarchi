import { useContext } from "react";
import { AuthContext } from "../../store/auth-context";
import Button from "../UI/Button";
import classes from "./HeaderButtons.module.css";

const RestaurantHeaderButtons = (props) => {
  const authCtx = useContext(AuthContext);

  const logoutHandler = () => {
    authCtx.logout();
  };

  return (
    <div className={classes.actions}>
      <Button
        message="Add Dish"
        buttonType="button"
        onPress={props.onActivate}
      />
      {props.switchHeaderButtons && (
        <Button message="View Orders" onPress={props.onSwitch} />
      )}
      {!props.switchHeaderButtons && (
        <Button message="View Dishes" onPress={props.onSwitch} />
      )}
      <Button message="Logout" buttonType="button" onPress={logoutHandler} />
    </div>
  );
};

export default RestaurantHeaderButtons;
