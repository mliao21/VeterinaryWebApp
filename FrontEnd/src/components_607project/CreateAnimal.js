/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faDog } from '@fortawesome/free-solid-svg-icons';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';
import axios from 'axios';
import { Component } from "react";

export default class CreateAnimal extends Component {
    constructor(props) {
        super(props);
        this.handleRegister = this.handleRegister.bind(this);
        this.onChangeName = this.onChangeName.bind(this);
        this.onChangeSex = this.onChangeSex.bind(this);
        this.onChangeAge = this.onChangeAge.bind(this);
        this.onChangeWeight = this.onChangeWeight.bind(this);
        this.onChangeSpecies = this.onChangeSpecies.bind(this);
        this.onChangeBreed = this.onChangeBreed.bind(this);
        this.state = this.initialState;
    }

    initialState = {
        name: "",
        sex: "",
        age: "",
        weight: "",
        species: "",
        breed: "",
        successful: false,
        message: ""
    };

    onChangeName(e) {
        this.setState({
            name: e.target.value
        });
    }

    onChangeSex(e) {
        this.setState({
            sex: e.target.value
        });
    }

    onChangeAge(e) {
        this.setState({
            age: e.target.value
        });
    }

    onChangeWeight(e) {
        this.setState({
            weight: e.target.value
        });
    }

    onChangeSpecies(e) {
        this.setState({
            species: e.target.value
        });
    }

    onChangeBreed(e) {
        this.setState({
            breed: e.target.value
        });
    }

    register(name, sex, age, weight, species, breed) {
        return axios.post("http://localhost:8080/animals", {
            name,
            sex,
            age,
            weight,
            species,
            breed
        });
    }

    handleRegister(e) {
        e.preventDefault();

        this.setState({
            message: "",
            successful: false
        });

        this.register(
            this.state.name,
            this.state.sex,
            this.state.age,
            this.state.weight,
            this.state.species,
            this.state.breed
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
                                {/* <NavLink className="nav-link" to="/admin_main"> */}
                                {/* <button class="button is-primary mr-2">Back</button> */}
                                {/* </NavLink> */}
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

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Species</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-6">
                                                    <p class="control is-expanded has-icons-left">
                                                        <input
                                                            class="input is-medium"
                                                            type="text"
                                                            placeholder="e.g. Dog"
                                                            name="species"
                                                            value={this.state.species}
                                                            onChange={this.onChangeSpecies} />
                                                        <span class="icon is-small is-left">
                                                            <FontAwesomeIcon icon={faDog} />
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
                                    <label class="label">Breed</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-6">
                                                    <p class="control is-expanded has-icons-left">
                                                        <input
                                                            class="input is-medium"
                                                            type="text"
                                                            placeholder="e.g. Beagle"
                                                            name="breed"
                                                            value={this.state.breed}
                                                            onChange={this.onChangeBreed} />
                                                        <span class="icon is-small is-left">
                                                            <FontAwesomeIcon icon={faDog} />
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
                                    <label class="label">Name</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-5">
                                                    <p class="control is-expanded has-icons-left">
                                                        <input
                                                            class="input is-medium"
                                                            type="text"
                                                            placeholder="name"
                                                            name="name"
                                                            value={this.state.name}
                                                            onChange={this.onChangeName} />
                                                        <span class="icon is-small is-left">
                                                            <FontAwesomeIcon icon={faDog} />
                                                        </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal mt-4">
                                <div class="field-label is-medium">
                                    <label class="label">Sex</label>
                                </div>
                                <div class="field-body">
                                    <div class="field is-narrow">
                                        <div class="control">
                                            <div class="select is-fullwidth is-medium">
                                                <select type="text"
                                                    name="sex"
                                                    value={this.state.sex}
                                                    onChange={this.onChangeSex}>
                                                    <option>F</option>
                                                    <option>M</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Age (yrs)</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-2">
                                                    <p class="control is-expanded">
                                                        <input
                                                            class="input is-medium"
                                                            type="number"
                                                            placeholder="e.g 0.5"
                                                            name="age"
                                                            value={this.state.age}
                                                            onChange={this.onChangeAge} />
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="field is-horizontal">
                                <div class="field-label is-medium">
                                    <label class="label">Weight (lbs)</label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <div class="container">
                                            <div class="columns">
                                                <div class="column is-3">
                                                    <p class="control is-expanded">
                                                        <input
                                                            class="input is-medium"
                                                            type="weight"
                                                            placeholder="e.g. 120.58"
                                                            name="weight"
                                                            value={this.state.weight}
                                                            onChange={this.onChangeWeight} />

                                                    </p>
                                                </div>
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
            </body>
        );
    }
}