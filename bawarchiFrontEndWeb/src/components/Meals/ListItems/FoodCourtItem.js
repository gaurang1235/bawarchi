import { Fragment } from "react";
import Button from "../../UI/Button";
import classes from "./ListItem.module.css";

const FoodCourtItem = (props) => {
  // const price = `₹${props.price.toFixed(2)}`;
  const deleteItemHandler = () => {
    console.log(props.id);
    props.onDelete(props.id);
  };

  return (
    <Fragment>
      <li className={classes.meal}>
        <div>
          <div>
            <h3>{props.name}</h3>
            {/* <div className={classes.description}>{props.description}</div> */}
            <div className={classes.description}>{props.description}</div>
          </div>
        </div>
        <div className={classes.actions}>
          <Button
            message="Delete Food Court"
            buttonType="button"
            alt={true}
            onPress={deleteItemHandler}
          />
        </div>
      </li>
    </Fragment>
  );
};

export default FoodCourtItem;
