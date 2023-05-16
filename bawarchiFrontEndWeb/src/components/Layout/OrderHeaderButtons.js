import { useContext } from "react";
import { AuthContext } from "../../store/auth-context";
import Button from "../UI/Button";
import classes from "./HeaderButtons.module.css";

const OrderHeaderButtons = props => {
  const authCtx = useContext(AuthContext);

  const logoutHandler = () => {
    authCtx.logout();
  };

  return (
    <div className={classes.actions}>
      {/* <Button message="Add Dish" buttonType="button" onPress={props.onActivate}/> */}
      <Button message="View Dishes" />
      <Button message="Logout" buttonType="button" onPress={logoutHandler} />
    </div>
  );
};

export default OrderHeaderButtons;