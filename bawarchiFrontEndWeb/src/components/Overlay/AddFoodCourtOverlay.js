import AddFoodCourtForm from "../Forms/AddFoodCourtForm";
import Modal from "../UI/Modal";

const AddFoodCourtOverlay = (props) => {
  const FoodCourtAdditionHandler = ({ username, password, name, address }) => {
    props.onAddingNewFoodCourt(username, password, name, address);
  };

  return (
    <Modal>
      <AddFoodCourtForm
        onCancel={props.onCancel}
        onAddingNewFoodCourt={FoodCourtAdditionHandler}
      />
    </Modal>
  );
};

export default AddFoodCourtOverlay;
