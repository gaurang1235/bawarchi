import AddDishForm from "../Forms/AddDishForm";
import Modal from "../UI/Modal";

const AddDishOverlay = (props) => {
  const dishAdditionHandler = ({ name, price, category }) => {
    props.onAddingNewDish(name, price, category);
  };

  return (
    <Modal>
      <AddDishForm
        onCancel={props.onCancel}
        onAddingNewDish={dishAdditionHandler}
      />
    </Modal>
  );
};

export default AddDishOverlay;
