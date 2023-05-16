import GlobalService from "../util/GlobalService_RS";

const fetchDishes = async (props) => {
  const restaurantId = localStorage.getItem("userId");
  const childURL = `restaurant/${restaurantId}/fetchDishes`;
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

const fetchOrders = async (props) => {
    const restaurantId = localStorage.getItem("userId");
    const childURL = `restaurant/${restaurantId}/fetchPendingOrders`;
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

const addNewDish = async (name, price, category) => {
  const restaurantId = localStorage.getItem("userId");
  const childURL = `restaurant/${restaurantId}/addDish`;
  const token = localStorage.getItem("token");

  const postData = {
    name: name,
    price: price,
    category: category,
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

const deleteDish = async (dishId) => {
    const childURL = `restaurant/deleteDish/${dishId}`;
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

  const placeOrder = async (orderId) => {
    const childURL = `restaurant/completeOrder/${orderId}`;
    const token = localStorage.getItem("token");
  
    console.log("Sending token");
    console.log(token);
  
    const header = {
      headers: { Authorization: `Bearer ${token}` },
    };
  
    const response = await GlobalService.hitPutService({
      childURL: childURL,
      postData: {},
      header: header,
    });
  
    console.log("Is the response correct");
    console.log(response);
  
    return response.data;
  };

const RestaurantController = { fetchDishes, addNewDish, fetchOrders, deleteDish, placeOrder };
export default RestaurantController;
