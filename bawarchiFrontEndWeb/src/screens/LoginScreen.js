import Card from "../components/UI/Card";
import classes from "./Login.module.css";

import LoginForm from "../components/Forms/LoginForm";
import { Fragment, useContext, useState } from "react";
import { AuthContext } from "../store/auth-context";
import Header from "../components/Layout/Header";
import LoginController_RS from "../controllers/LoginController_RS";
import LoginController_FC from "../controllers/LoginController_FC";

const LoginScreen = () => {
  const [isAuthenticating, setIsAuthenticating] = useState(false);

  const authCtx = useContext(AuthContext);

  async function loginHandler({ email, password, role }) {
    setIsAuthenticating(true);
    if(role==="ROLE_RESTAURANT"){
      try {
        const response = await LoginController_RS.GetUserLoginData(
          email,
          password,
          role
        );
        authCtx.authenticate(response.token, response.authId, role);
        console.log(response.token);
      } catch (error) {
        console.log(error);
        alert(error.response.data.message);
        setIsAuthenticating(false);
      }
    }else {
      try {
        const response = await LoginController_FC.GetUserLoginData(
          email,
          password,
          role
        );
        authCtx.authenticate(response.token, response.authId, role);
        console.log(response.token);
      } catch (error) {
        console.log(error);
        alert(error.response.data.message);
        setIsAuthenticating(false);
      }
    }
    setIsAuthenticating(false);
  }

  if (isAuthenticating) {
    return <h2>Logging you in</h2>;
  }

  return (
    <Fragment>
      <Header />
      <section className={classes.login}>
        <Card>
          <LoginForm onAuthenticate={loginHandler} />
        </Card>
      </section>
    </Fragment>
  );
};

export default LoginScreen;
