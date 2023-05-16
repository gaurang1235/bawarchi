import GlobalService from "../util/GlobalService_FC";

const fetchFoodCourts = async (props) => {
  const childURL = "superAdmin/allFoodCourts";
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

const addNewFoodCourt = async (username, password, name, address) => {
  const childURL = `superAdmin/addFoodCourt`;
  const token = localStorage.getItem("token");

  const postData = {
    username: username,
    password: password,
    name: name,
    address: address,
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

const deleteFoodCourt = async (foodCourtId) => {
    const childURL = `superAdmin/deleteFoodCourt/${foodCourtId}`;
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

const SuperAdminController = { fetchFoodCourts, addNewFoodCourt, deleteFoodCourt };
export default SuperAdminController;
