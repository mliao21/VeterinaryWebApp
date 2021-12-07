import "bulma/css/bulma.css";
import './App.css';
import React, { Component } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import {
  Technician,
  Admin,
  AvailableAnimal,
  CancelRequest,
  LoginPage,
} from "./components";

class App extends Component {
  state = {
    availableAnimals: [],
    newRequests: [],
    pendingRequests: [],
    approvedByAdminRequests: []
  };

  async componentDidMount() {
    const resAvailable = await fetch('/animals/available');
    const resNew = await fetch('/animals/new_animal_requests');
    const resPending = await fetch('/animals/pending_animal_requests');
    const resAdmin = await fetch('/animals/approved_by_admin_requests');

    const availBody = await resAvailable.json();
    const newBody = await resNew.json();
    const pendingBody = await resPending.json();
    const adminBody = await resAdmin.json();

    this.setState({availableAnimals: availBody});
    this.setState({newRequests: newBody});
    this.setState({pendingRequests: pendingBody});
    this.setState({approvedByAdminRequests: adminBody});
  }

  render() {
    const {availableAnimals, newRequests, pendingRequests, approvedByAdminRequests} = this.state;
    return (
      <Router>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/available_animal" element={<AvailableAnimal animals={availableAnimals} />} />
          <Route path="/cancel_requests" element={<CancelRequest animals={pendingRequests} />} />
          <Route path="/admin" element={<Admin animals={newRequests} />} />
          <Route path="/technician" element={<Technician animals={approvedByAdminRequests} />} />
        </Routes>
      </Router>
    );
  }
}

export default App;
