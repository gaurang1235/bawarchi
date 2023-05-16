import GlobalService from "../util/GlobalService_RS";

const GetUserLoginData = async (email, password, role) => {
  const postData = {
    username: email,
    password: password,
    role: role,
  };

  var childURL = "login/";

  const response = await GlobalService.hitPostService({
    childURL: childURL,
    postData: postData,
  });

  console.log("Is the response correct");
  console.log(response);

  return response.data;
};

const LoginController_RS = { GetUserLoginData };
export default LoginController_RS;
