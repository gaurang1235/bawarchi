import React, { useState, useContext, useEffect, Fragment } from "react";
import AddDishOverlay from "./components/Overlay/AddDishOverlay";
import Header from "./components/Layout/Header";
import Meals from "./components/Meals/Meals";
import LoginScreen from "./screens/LoginScreen";
import AuthContextProvider, { AuthContext } from "./store/auth-context";
import SuperAdminScreen from "./screens/SuperAdminScreen";
import FoodCourtScreen from "./screens/FoodCourtScreen";
import RestaurantScreen from "./screens/RestaurantScreen";

function AuthStack() {
  return (
    <Fragment>
      <LoginScreen />
    </Fragment>
  );
}

function AuthenticatedStack() {
  const authCtx = useContext(AuthContext);

  let screen = <SuperAdminScreen />;

  if (authCtx.role === "ROLE_FOOD_COURT") {
    screen = <FoodCourtScreen />;
  }

  if (authCtx.role === "ROLE_RESTAURANT") {
    screen = <RestaurantScreen />;
  }

  return (
    <Fragment>
      {/* <AddDishOverlay /> */}
      {/* <Meals /> */}
      {screen}
    </Fragment>
  );
}

function Navigation() {
  const authCtx = useContext(AuthContext);

  return (
    <Fragment>
      {!authCtx.isAuthenticated && <AuthStack />}
      {authCtx.isAuthenticated && <AuthenticatedStack />}
    </Fragment>
  );
}

function Root() {
  const [isTryingLogin, setIsTryingLogin] = useState(true);
  const authCtx = useContext(AuthContext);

  useEffect(() => {
    async function fetchToken() {
      const storedToken = await localStorage.getItem("token");

      if (storedToken) {
        const storedUserId = localStorage.getItem("userId");
        const storedUserRole = localStorage.getItem("role");
        authCtx.authenticate(storedToken, storedUserId, storedUserRole);
      }

      setIsTryingLogin(false);
    }

    fetchToken();
  }, []);

  if (isTryingLogin) {
    return <h2>Loading...</h2>;
  }

  return <Navigation />;
}

function App() {
  const [isLoggedIn, setisLoggedIn] = useState(false);

  return (
    <AuthContextProvider>
      <React.Fragment>
        <Root />
        {/* <AddDishOverlay /> */}
        {/* <Header /> */}
        {/* <main> */}
        {/* <Meals /> */}
        {/* {!isLoggedIn && <LoginScreen />}
          {isLoggedIn && <Meals />}
        </main> */}
      </React.Fragment>
    </AuthContextProvider>
  );
}

export default App;
