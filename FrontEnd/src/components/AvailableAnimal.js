/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { NavLink } from "react-router-dom";
import React, { useReducer } from "react";
import axios from "axios";

const AvailableAnimal = ({animals}) => {
    const saveEndpoint = "https://saveendpoint/"

    const editSaveReducer = (state, action) => {
        if (state) {
            // we want to save changes
            axios.post(saveEndpoint, 
              JSON.stringify ({
                
              }),
              {
                headers: {
                  "Content-Type" : "application/json"
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
        <header className="title">
            <div className="is-size-2 has-text-success-dark has-background-success-light" css={css`display: flex; align-items: center;`}>
                <div css={css`margin-left: 40px;`}>
                    Available Animals
                </div>
                <div className="column has-text-right">
                    <button
                        onClick={ () => editDispatch({ currentState: inEditMode })} 
                        className={`button is-medium ${inEditMode ? "is-info" : "is-success"}`}>
                            {inEditMode ? "Save" : "Request"}
                    </button>
                    <NavLink className="nav-link" to="/cancel_requests">
                        <button className="button is-medium is-danger" css={css`margin-left: 10px;`}>
                            Cancel
                        </button>
                    </NavLink>
                </div>
            </div>
            <div class="table-container">
                <table className="table is-narrow is-striped is-fullwidth" css={css`margin-left: auto; margin-right: auto;`}>
                    <thead>
                        <tr className="is-size-4">
                            <th title="Animal ID">Animal ID</th>
                            <th title="Type">Type</th>
                            <th title="Breed">Breed</th>
                            <th title="Name">Name</th>
                            <th title="Status">Status</th>
                            <th title="Weight">Weight</th>                            
                        </tr>
                    </thead>
                    <tbody className="is-size-5">
                        {
                        animals.map((item, index) => (
                            <tr key={index}>
                                <td>{animals[index].id}</td>
                                <td>{animals[index].type}</td>
                                <td>{animals[index].breed}</td>
                                <td>{animals[index].name}</td>
                                <td>{animals[index].status}</td>
                                <td>{animals[index].weight}</td>
                                {inEditMode ?
                                    <button
                                        // onClick={changeHandler(animals[index].status)}
                                        css={css`margin-left: 40px;`}
                                        className="button is-small is-success has-text-weight-medium is-uppercase">
                                            Request
                                    </button>
                                : null}
                            </tr>
                        ))
                        }
                    </tbody>
                </table>
            </div>
        </header>  
    );
}

export default AvailableAnimal;