/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { NavLink } from "react-router-dom";
import React, { useReducer } from "react";
import axios from "axios";
import logo from './ucvm-logo.png';

const RequestAnimal = ({ animals }) => {
    const saveEndpoint = "http://localhost:8080/animals/{id}"

    const editSaveReducer = (state, action) => {
        if (state) {
            // we want to save changes
            axios.put(saveEndpoint,
                JSON.stringify({

                }),
                {
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            ).then(response => console.log(response))
                .catch(error => console.log(error))
        }
        return !state;
    }

    // const [newStatus, setNewStatus] = useState("");
    const [inEditMode, editDispatch] = useReducer(editSaveReducer, false);

    // const changeHandler = (animalStatus) => {
    //     if (animalStatus === "Available") {
    //         return "New";
    //     }
    //     if (animalStatus === "New") {
    //         return "Accepted_by_admin";
    //     }
    //     if (animalStatus === "Accepted_by_admin") {
    //         return "Approved";
    //     } 
    //     return setNewStatus("New");
    // }

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
                            <NavLink className="nav-link" to="/teaching_tech">
                                <button class="button is-info mr-2">Back</button>
                            </NavLink>
                            <NavLink className="nav-link" to="/">
                                <button class="button is-info">Log out</button>
                            </NavLink>
                        </div>
                    </div>
                </div>
            </nav>
            <header className="title mt-6">
                <section class="hero is-small is-success has-text-centered">
                    <div class="hero-body">
                        <p class="title">
                        Available Animals
                        </p>
                    </div>
                </section>
                <div class="table-container ml-6">
                    <table className="table is-narrow is-striped is-fullwidth" css={css`margin-left: auto; margin-right: auto;`}>
                        <thead>
                            <tr className="is-size-4">
                                <th title="Animal ID">Animal ID</th>
                                <th title="Species">Species</th>
                                <th title="Breed">Breed</th>
                                <th title="Name">Name</th>
                                <th title="Sex">Sex</th>
                                <th title="Age">Age</th>
                                <th title="Weight">Weight</th>
                                {/* <th title="Status">Status</th> */}
                            </tr>
                        </thead>
                        <tbody className="is-size-5">
                            {
                                animals.map((item, index) => (
                                    <tr key={index}>
                                        <td>{animals[index].animalid}</td>
                                        <td>{animals[index].species}</td>
                                        <td>{animals[index].breed}</td>
                                        <td>{animals[index].name}</td>
                                        <td>{animals[index].sex}</td>
                                        <td>{animals[index].age}</td>
                                        <td>{animals[index].weight}</td>
                                        {/* <td>{animals[index].status}</td> */}
                                        <button
                                            // onClick={changeHandler(animals[index].status)}
                                            css={css`margin-left: 40px;`}
                                            className="button is-small is-success has-text-weight-medium is-uppercase">
                                            Request
                                        </button>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                </div>
            </header>
        </body>
    );
}

export default RequestAnimal;