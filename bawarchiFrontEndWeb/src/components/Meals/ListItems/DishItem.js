import { Fragment } from "react";
import Button from "../../UI/Button";
import classes from "./ListItem.module.css";

const DishItem = (props) => {
  const deleteItemHandler = () => {
    console.log(props.id);
    props.onDelete(props.id);
  };

  const price = `₹${props.price.toFixed(2)}`;

  return (
    <Fragment>
      <li className={classes.meal}>
        <div>
          <h3>{props.name}</h3>
          <div className={classes.description}>{props.category}</div>
          <div className={classes.price}>{price}</div>
        </div>
        <div className={classes.actions}>
          <Button
            message="Delete Dish"
            buttonType="button"
            alt={true}
            onPress={deleteItemHandler}
          />
        </div>
      </li>
    </Fragment>
  );
};

export default DishItem;
