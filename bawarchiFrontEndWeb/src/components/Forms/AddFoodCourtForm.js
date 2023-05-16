import { Fragment, useState } from "react";
import Button from "../UI/Button";
import FormInput from "../UI/FormInput";

import classes from "./LoginForm.module.css";

const AddFoodCourtForm = (props) => {
  const [enteredUsername, setUsername] = useState("");
  const [enteredPassword, setPassword] = useState("");
  const [enteredName, setName] = useState("");
  const [enteredAddress, setAddress] = useState("");

  const usernameChangeHandler = (enteredText) => {
    setUsername(enteredText);
  };

  const passwordChangeHandler = (enteredText) => {
    setPassword(enteredText);
  };

  const nameChangeHandler = (enteredText) => {
    setName(enteredText);
  };

  const addressChangeHandler = (enteredText) => {
    setAddress(enteredText);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    console.log("Submit chal gya");

    props.onAddingNewFoodCourt({
      username: enteredUsername,
      password: enteredPassword,
      name: enteredName,
      address: enteredAddress,
    });
  };

  return (
    <Fragment>
      <form onSubmit={submitHandler}>
        <section className={classes.title}>
          <h2>Add New Food Court</h2>
        </section>
        <FormInput
          field="username"
          label="Username"
          type="text"
          id="username"
          onUpdate={usernameChangeHandler}
        />
        <FormInput
          field="password"
          label="Password"
          type="password"
          id="password"
          onUpdate={passwordChangeHandler}
        />
        <FormInput
          field="name"
          label="Name"
          type="text"
          id="name"
          onUpdate={nameChangeHandler}
        />
        <FormInput
          field="address"
          label="Address"
          type="text"
          id="address"
          onUpdate={addressChangeHandler}
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

export default AddFoodCourtForm;
