import "bulma/css/bulma.css";
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import React, { Component } from "react";
import { BrowserRouter as Router, Route, Routes , Link } from "react-router-dom";
import { 
  LoginPage,
  AdminMain,
  CreateUser,
  SearchUser,
  UserList,
  CreateAnimal,
  TeachingTechnician,
  RequestAnimal,
  SearchAnimal,
} from "./components_607project";
import Login from "./components_607project/login.component";
import Register from "./components_607project/register.component";
import Home from "./components_607project/home.component";
import EventBus from "./common/EventBus";
import AuthService from "./services/auth.service";

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showAdminBoard: false,
      currentUser: undefined,
      userLists: [],
      availableAnimals: [],
      animalsLists: []
    };
  }
  
  // state = {
  //   userLists: [],
  //   availableAnimals: []
  // };

  async componentDidMount() {
    const resUsers = await fetch('/users');
    const usersBody = await resUsers.json();
    this.setState({userLists: usersBody});

    const resAvailable = await fetch('/available_animals');
    const availBody = await resAvailable.json();
    this.setState({availableAnimals: availBody});
    
    const animalsAll = await fetch('/animals');
    const animalBody = await animalsAll.json();
    this.setState({animalLists: animalBody});

    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
    
    EventBus.on("logout", () => {
      this.logOut();
    });
  }
  componentWillUnmount() {
    EventBus.remove("logout");
  }
  logOut() {
    AuthService.logout();
    this.setState({
      // showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const {userLists, availableAnimals ,animalLists,  currentUser, /*showModeratorBoard*/ showAdminBoard} = this.state;
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            VET APP
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/home"} className="nav-link">
                Home
              </Link>
            </li>

            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin_main"} className="nav-link">
                  Admin Board
                </Link>
              </li>
            )}

            {currentUser && (
              <li className="nav-item">
                <Link to={"/user"} className="nav-link">
                  User
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
        </nav>

      {/* <Router> */}
        <Routes>
          {/* <Route path="/" element={<LoginPage />} /> */}
          <Route path="/admin_main" element={<AdminMain />} />
          <Route path="/create_user" element={<CreateUser />} />
          <Route path="/search_user" element={<SearchUser users={userLists} />} />
          <Route path="/user_list" element={<UserList users={userLists} />} />
          <Route path="/create_animal" element={<CreateAnimal />} />
          <Route path="/teaching_tech" element={<TeachingTechnician />} />
          <Route path="/search_animal" element={<SearchAnimal animals={animalLists} />} />
          <Route path="/request_animal" element={<RequestAnimal animals={availableAnimals} />} />
          <Route path="/home" element={<Login/>} />
          <Route path="/" element={<Login/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
        </Routes>
      {/* </Router> */}
      </div>
    );
  }
}

export default App;
