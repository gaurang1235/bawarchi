import GlobalService from "./GlobalService";

const RegisterFC = async (props) => {
    console.log(props.data);


  await GlobalService.hitPostService({
    

    childURL: "superAdmin/addFoodCourt",
    postData: props.data,
    responseDataHandler: (registerData) => {
      if (registerData.responseError === null) {
        props.success();
      } else if (registerData.responseData === null) {
        console.log("Entered in error block");
        console.log(registerData.responseError.message);
        props.failure();
      }
    },
  });
};

const RegisterFoodCourt = { RegisterFC };
export default RegisterFoodCourt;