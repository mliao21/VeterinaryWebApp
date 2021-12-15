/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';
import axios from 'axios';
import React, { Component } from "react";

export default class CreateUser extends Component {
    constructor(props) {
        super(props);
        this.handleRegister = this.handleRegister.bind(this);
        this.onChangeRole = this.onChangeRole.bind(this);
        this.onChangeUsername = this.onChangeUsername.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.onChangePassword = this.onChangePassword.bind(this);
        this.onChangeStatus = this.onChangeStatus.bind(this);
        this.state = this.initialState;
    }

    initialState = {
        role: "",
        username: "",
        email: "",
        password: "",
        status: "",
        successful: false,
        message: ""
    };

    onChangeRole(e) {
        this.setState({
            role: e.target.value
        });
    }

    onChangeUsername(e) {
        this.setState({
            username: e.target.value
        });
    }

    onChangeEmail(e) {
        this.setState({
            email: e.target.value
        });
    }

    onChangePassword(e) {
        this.setState({
            password: e.target.value
        });
    }

    onChangeStatus(e) {
        this.setState({
            status: e.target.value
        });
    }

    register(role, username, email, password, status) {
        return axios.post("http://localhost:8080/users", {
            role,
            username,
            email,
            password,
            status
        });
    }

    handleRegister(e) {
        e.preventDefault();

        this.setState({
            message: "",
            successful: false
        });

        this.register(
            this.state.role,
            this.state.username,
            this.state.email,
            this.state.password,
            this.state.status
        ).then(
            response => {
                this.setState(this.initialState);
                this.setState({
                    message: response.data.message,
                    successful: true
                });
            },
            error => {
                const resMessage =
                    (error.response &&
                        error.response.data &&
                        error.response.data.message) ||
                    error.message ||
                    error.toString();

                this.setState({
                    successful: false,
                    message: resMessage
                });
            }
        );
    }


    render() {
        return (
            <body>
                <nav class="navbar is-fixed-top">
                    <div class="navbar-brand">
                        <a class="navbar-start ml-3">
                            <img src={logo} alt="University of Calgary - Faculty of Veterinary Medicine" width="300" />
                        </a>
                    </div>
                    <div class="navbar-end">
                        <div class="navbar-item">
                            <div class="buttons">
                                <NavLink className="nav-link" to="/admin_main">
                                    <button class="button is-primary mr-2">Back</button>
                                </NavLink>
                                <NavLink className="nav-link" to="/">
                                    <button class="button is-info">Log out</button>
                                </NavLink>
                            </div>
                        </div>
                    </div>
                </nav>

                <form onSubmit={this.handleRegister}>
                    <div css={css` margin-left: 270px;`} className="container">
                        <div class="section mt-6 ml-6">

                            <div class="field is-horizontal mt-4">
                                <div class="field-label is-medium">
                                    <label class="label">Role</label>
                                </div>
                                <div class="field-body">
                                    <div class="field is-narrow">
                                        <div class="control">
                                            <div class="select is-fullwidth is-medium">
                                                <select type="text" name="role" value={this.state.role} onChange={this.onChangeRole}>
                                                    <option>Administrator</option>
                                                    <option>Care Attendant</option>
                                                    <option>Health Technician</option>
                                                    <option>Teaching Technician</option>
                                                    <option>Student</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Username</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-5">
                                                    <p class="control is-expanded has-icons-left">
                                                        <input class="input is-medium" type="username" placeholder="name" name="username" value={this.state.username} onChange={this.onChangeUsername} />
                                                        <span class="icon is-small is-left">
                                                            <FontAwesomeIcon icon={faUser} />
                                                        </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Email</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-6">
                                                    <p class="control is-expanded has-icons-left">
                                                        <input class="input is-medium" type="email" placeholder="example@ucalgary.ca" name="email" value={this.state.email} onChange={this.onChangeEmail} />
                                                        <span class="icon is-small is-left">
                                                            <FontAwesomeIcon icon={faEnvelope} />
                                                        </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Password</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-6">
                                                    <p class="control is-expanded has-icons-left">
                                                        <input class="input is-medium" type="password" placeholder="at least 8 characters" name="password" value={this.state.password} onChange={this.onChangePassword} />
                                                        <span class="icon is-small is-left">
                                                            <FontAwesomeIcon icon={faKey} />
                                                        </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Status</label>
                                </div>
                                <div class="field-body">
                                    <div class="field is-narrow">
                                        <div class="control">
                                            <div class="select is-fullwidth is-medium">
                                                <select type="status" name="status" value={this.state.status} onChange={this.onChangeStatus}>
                                                    <option>Active</option>
                                                    <option>Blocked</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label">
                                    {/* <!-- Left empty for spacing --> */}
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="control">
                                            <button class="button is-success" type="submit">
                                                Submit
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </body >
        );
    };
}
// export default CreateUser;