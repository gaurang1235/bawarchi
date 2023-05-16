import { Fragment, useState } from "react";
import Button from "../UI/Button";
import FormInput from "../UI/FormInput";

import classes from "./LoginForm.module.css";

const AddDishForm = (props) => {
  const [enteredName, setName] = useState("");
  const [enteredPrice, setPrice] = useState("");
  const [enteredCategory, setCategory] = useState("");

  const nameChangeHandler = (enteredText) => {
    setName(enteredText);
  };

  const priceChageHandler = (enteredText) => {
    setPrice(enteredText);
  };

  const categoryChangeHandler = (enteredText) => {
    setCategory(enteredText);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    console.log("Submit chal gya");

    props.onAddingNewDish({
      name: enteredName,
      price: enteredPrice,
      category: enteredCategory,
    });
  };

  return (
    <Fragment>
      <form onSubmit={submitHandler}>
        <section className={classes.title}>
          <h2>Add New Dish</h2>
        </section>
        <FormInput
          field="name"
          label="Name"
          type="text"
          id="name"
          onUpdate={nameChangeHandler}
        />
        <FormInput
          field="price"
          label="Price"
          type="number"
          id="price"
          onUpdate={priceChageHandler}
        />
        <FormInput
          field="category"
          label="Category"
          type="text"
          id="category"
          onUpdate={categoryChangeHandler}
        />
        <div className={classes.actions}>
          <Button message="Add" buttonType="submit" />
          <Button
            alt={true}
            message="Cancel"
            buttonType="button"
            onPress={props.onCancel}
          />
        </div>
      </form>
    </Fragment>
  );
};

export default AddDishForm;
