import { Fragment } from "react";
import Button from "../../UI/Button";
import classes from "./ListItem.module.css";

const OrderItem = (props) => {
  const placeOrderHandler = () => {
    props.onPlace(props.id);
  };
  const price = `₹${props.price.toFixed(2)}`;

  return (
    <Fragment>
      <li className={classes.meal}>
        <div>
          {props.dishes.map((dish) => (
            <h3>{dish.name}</h3>
          ))}
          <div className={classes.price}>Table: {props.tableNumber}</div>
        </div>
        <div className={classes.actions}>
          <Button
            message="Complete Order"
            buttonType="button"
            onPress={placeOrderHandler}
          />
        </div>
      </li>
    </Fragment>
  );
};

export default OrderItem;
