import classes from "./FormInput.module.css";

const Dropdown = (props) => {
  const onChangeHandler = (event) => {
    props.onUpdate(event.target.value);
  };

  return (
    <div className={classes.control}>
      <label htmlFor={props.field}>{props.label}</label>
      <select
        id={props.id}
        // value={userType}
        onChange={onChangeHandler}
      >
        <option value="">Select User Type</option>
        <option value="ROLE_SUPER_ADMIN">SuperAdmin</option>
        <option value="ROLE_FOOD_COURT">FoodCourt</option>
        <option value="ROLE_RESTAURANT">Restaurant</option>
      </select>
    </div>
  );
};

export default Dropdown;
