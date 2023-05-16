import GlobalService from "../util/GlobalService_FC";

const fetchRestaurants = async (props) => {
  const foodCourtId = localStorage.getItem("userId");
  const childURL = `foodCourt/${foodCourtId}/allRestaurants`;
  const token = localStorage.getItem("token");

  console.log("Sending token");
  console.log(token);

  const header = {
    headers: { Authorization: `Bearer ${token}` },
  };

  const response = await GlobalService.hitGetService({
    childURL: childURL,
    header: header,
  });

  console.log("Is the response correct");
  console.log(response);

  return response.data;
};

const addNewRestaurant = async (username, password, name, contact) => {
  const foodCourtId = localStorage.getItem("userId");
  const childURL = `foodCourt/${foodCourtId}/addRestaurant`;
  const token = localStorage.getItem("token");

  const postData = {
    username: username,
    password: password,
    name: name,
    contact: contact,
  };

  const header = {
    headers: { Authorization: `Bearer ${token}` },
  };

  const response = await GlobalService.hitPostService({
    childURL: childURL,
    postData: postData,
    header: header,
  });

  console.log("Is the response correct");
  console.log(response);

  return response.data;
};

const deleteRestaurant = async (restaurantId) => {
    const childURL = `foodCourt/deleteRestaurant/${restaurantId}`;
    const token = localStorage.getItem("token");
  
    console.log("Sending token");
    console.log(token);
  
    const header = {
      headers: { Authorization: `Bearer ${token}` },
    };
  
    const response = await GlobalService.hitDeleteService({
      childURL: childURL,
      header: header,
    });
  
    console.log("Is the response correct");
    console.log(response);
  
    return response.data;
  };

const FoodCourtController = { fetchRestaurants, addNewRestaurant, deleteRestaurant };
export default FoodCourtController;
