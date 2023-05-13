import GlobalService from "./GlobalService";

const GetUserLoginData = async (props) => {
    console.log(props.userData);

    var url;

    if(props.userData.role==="ROLE_SUPER_ADMIN" || props.userData.role==="ROLE_FOOD_COURT")
    {
        url = "slogin/"
    }else{
        url = "rlogin/"
    }


  await GlobalService.hitPostService({
    

    childURL: url,
    postData: props.userData,
    responseDataHandler: (loginServiceData) => {
      if (loginServiceData.responseError === null) {
        props.loginHandler(loginServiceData.responseData.data);
      } else if (loginServiceData.responseData === null) {
        console.log("Entered in error block");
        console.log(loginServiceData.responseError.message);
        props.fail();
      }
    },
  });
};

const LoginController = { GetUserLoginData };
export default LoginController;