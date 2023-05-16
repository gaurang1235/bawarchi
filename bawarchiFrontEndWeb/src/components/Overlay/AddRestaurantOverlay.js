import AddRestaurantForm from "../Forms/AddRestaurantForm";
import Modal from "../UI/Modal";

const AddRestaurantOverlay = (props) => {
  const RestaurantAdditionHandler = ({ username, password, name, contact }) => {
    props.onAddingNewRestaurant(username, password, name, contact);
  };

  return (
    <Modal>
      <AddRestaurantForm
        onCancel={props.onCancel}
        onAddingNewRestaurant={RestaurantAdditionHandler}
      />
    </Modal>
  );
};

export default AddRestaurantOverlay;
