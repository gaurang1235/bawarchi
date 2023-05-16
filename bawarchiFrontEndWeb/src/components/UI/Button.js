import classes from "./Button.module.css";

const Button = (props) => {
  return (
    <button
      className={props.alt ? classes["button--alt"] : classes.button}
      type={props.buttonType}
      onClick={props.onPress}
    >
      {props.message}
    </button>
  );
};

export default Button;
