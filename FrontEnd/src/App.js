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
  TeachingTechnician,
  RequestAnimal,
} from "./components_607project";

class App extends Component {
  state = {
    userLists: [],
    availableAnimals: []
  };

  async componentDidMount() {
    const resUsers = await fetch('/users');
    const usersBody = await resUsers.json();
    this.setState({userLists: usersBody});

    const resAvailable = await fetch('/available_animals');
    const availBody = await resAvailable.json();
    this.setState({availableAnimals: availBody});
  }

  render() {
    const {userLists, availableAnimals} = this.state;
    return (
      <Router>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/admin_main" element={<AdminMain />} />
          <Route path="/create_user" element={<CreateUser />} />
          <Route path="/search_user" element={<SearchUser users={userLists} />} />
          <Route path="/user_list" element={<UserList users={userLists} />} />
          <Route path="/create_animal" element={<CreateAnimal />} />
          <Route path="/teaching_tech" element={<TeachingTechnician />} />
          <Route path="/request_animal" element={<RequestAnimal animals={availableAnimals} />} />
        </Routes>
      </Router>
    );
  }
}

export default App;
