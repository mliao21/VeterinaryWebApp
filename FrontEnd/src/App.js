import "bulma/css/bulma.css";
import './App.css';
import React, { Component } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { 
  LoginPage,
  AdminMain,
  CreateUser,
  SearchUser,
  UserList,
  CreateAnimal,
} from "./components_607project";

class App extends Component {
  state = {
    userLists: []
  };

  async componentDidMount() {
    const resUsers = await fetch('/users');
    const usersBody = await resUsers.json();
    this.setState({userLists: usersBody});
  }

  render() {
    const {userLists} = this.state;
    return (
      <Router>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/admin_main" element={<AdminMain />} />
          <Route path="/create_user" element={<CreateUser />} />
          <Route path="/search_user" element={<SearchUser users={userLists} />} />
          <Route path="/user_list" element={<UserList users={userLists} />} />
          <Route path="/create_animal" element={<CreateAnimal />} />
        </Routes>
      </Router>
    );
  }
}

export default App;
