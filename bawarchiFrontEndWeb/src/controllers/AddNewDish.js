import GlobalService from "./GlobalService";

const NewDish = async (props) => {
    console.log(props.data);


  await GlobalService.hitPostService({
    

    childURL: "restaurant/" + props.authId + "/addDish",
    postData: props.data,
    responseDataHandler: (registerData) => {
      if (registerData.responseError === null) {
        props.success(0);
      } else if (registerData.responseData === null) {
        console.log("Entered in error block");
        console.log(registerData.responseError.message);
        // props.failure();
      }
    },
  });
};

const AddNewDish = { NewDish };
export default AddNewDish;