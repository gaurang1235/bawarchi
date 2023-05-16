import classes from "./FormInput.module.css";

const FormInput = (props) => {
  const onChangeHandler = (event) => {
    props.onUpdate(event.target.value);
  };

  return (
    <div className={classes.control}>
      <label htmlFor={props.field}>{props.label}</label>
      <input type={props.type} id={props.id} onChange={onChangeHandler} />
    </div>
  );
};

export default FormInput;
