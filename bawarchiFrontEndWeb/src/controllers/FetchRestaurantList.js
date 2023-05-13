import GlobalService from "./GlobalService";

const RestaurantList = async (props) => {

  await GlobalService.hitGetService({

    childURL: "restaurant/" + props.authId + "/fetchDishes",
    responseDataHandler: (registerData) => {
      if (registerData.responseError === null) {
        props.setRestaurants(registerData.responseData.data);
      } else if (registerData.responseData === null) {
        console.log("Entered in error block");
        console.log(registerData.responseError.message);
      }
    },
  });
};

const FetchRestaurantList = { RestaurantList };
export default FetchRestaurantList;