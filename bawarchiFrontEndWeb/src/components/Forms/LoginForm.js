import { Fragment, useState } from "react";
import Button from "../UI/Button";
import Dropdown from "../UI/Dropdown";
import FormInput from "../UI/FormInput";
import classes from "./LoginForm.module.css";

const LoginForm = (props) => {
  const [enteredUserType, setUserType] = useState("");
  const [enteredEmail, setEmail] = useState("");
  const [enteredPassword, setPassword] = useState("");

  const emailChangeHandler = (enteredText) => {
    setEmail(enteredText);
  };

  const passwordChangeHandler = (enteredText) => {
    setPassword(enteredText);
  };

  const userTypeChangeHandler = (enteredText) => {
    setUserType(enteredText);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    props.onAuthenticate({
      email: enteredEmail,
      password: enteredPassword,
      role: enteredUserType,
    });
  };

  return (
    <Fragment>
      <form onSubmit={submitHandler}>
        <section className={classes.title}>
          <h2>Login</h2>
        </section>
        <FormInput
          field="email"
          label="Email"
          type="text"
          id="email"
          onUpdate={emailChangeHandler}
        />
        <FormInput
          field="password"
          label="Password"
          type="password"
          id="password"
          onUpdate={passwordChangeHandler}
        />
        <Dropdown
          field="userType"
          label="User Type"
          id="userType"
          onUpdate={userTypeChangeHandler}
        />
        <div className={classes.actions}>
          <Button message="Login" buttonType="submit" />
        </div>
      </form>
    </Fragment>
  );
};

export default LoginForm;
