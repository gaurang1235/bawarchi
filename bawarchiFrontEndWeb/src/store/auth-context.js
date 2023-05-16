import { createContext, useEffect, useState } from "react";

export const AuthContext = createContext({
  token: "",
  isAuthenticated: false,
  userId: "",
  role: "",
  authenticate: () => {},
  logout: () => {},
});

function AuthContextProvider({ children }) {
  const [authToken, setAuthToken] = useState();
  const [loggedEmail, setLoggedEmail] = useState();
  const [loggedRole, setLoggedRole] = useState();

  function authenticate(token, userId, role) {
    setAuthToken(token);
    setLoggedEmail(userId);
    setLoggedRole(role);
    localStorage.setItem("token", token);
    localStorage.setItem("userId", userId);
    localStorage.setItem("role", role);
  }

  function logout() {
    setAuthToken(null);
    localStorage.removeItem("token");
    localStorage.removeItem("userId");
    localStorage.removeItem("role");
  }

  const value = {
    token: authToken,
    isAuthenticated: !!authToken,
    userId: loggedEmail,
    role: loggedRole,
    authenticate: authenticate,
    logout: logout,
  };
  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

export default AuthContextProvider;
