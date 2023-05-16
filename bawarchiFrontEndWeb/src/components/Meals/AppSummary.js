import classes from "./MealsSummary.module.css";

const AppSummary = () => {
  return (
    <section className={classes.summary}>
      <h2>Food Court Management System</h2>
      <p>
        Bawarchi makes the fulfillment of orders by Restaurants under a Food
        Court hassle-free and smooth for both the customers and the Restaurant.
      </p>
      <p>
        All the orders which are made through QR Codes on the tables appear
        here. Food Courts can also manage the restaurants registered with it.
      </p>
    </section>
  );
};

export default AppSummary;
