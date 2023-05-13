import { useState } from 'react'
import './App.css';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Login from './screens/Login.js'
import SuperAdmin from './screens/SuperAdmin';
import FoodCourt from './screens/FoodCourt';
import Restaurant from './screens/Restaurant';

function App() {

  const [user, setUser] = useState(null);

  const loginHandler = (userObject) => {
    console.log("hi i executed it");
    console.log(userObject.role);
    setUser(userObject);
  };

  return (
    <div className="App">
      {user===null && (
        <Login onLogin = {loginHandler}/>
      )}
      {user!==null && user.role==="ROLE_SUPER_ADMIN" && (
        <SuperAdmin/>
      )}
      {user!==null && user.role==="ROLE_FOOD_COURT" && (
        <FoodCourt user = {user}/>
      )}
      {user!==null && user.role==="ROLE_RESTAURANT" && (
        <Restaurant rest = {user}/>
      )}
    </div>
  );
}

export default App;
