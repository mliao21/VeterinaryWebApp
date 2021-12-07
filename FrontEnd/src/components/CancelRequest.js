/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { NavLink } from "react-router-dom";
import React, { useReducer } from "react";

const CancelRequest = ({animals}) => {
    const editSaveReducer = (state, action) => {
        return !state;
      }

    const [inEditMode, editDispatch] = useReducer(editSaveReducer, false);

    return (
        <header className="title">
            <div className="is-size-2 has-text-danger-dark has-background-danger-light" css={css`display: flex; align-items: center;`}>
                <div css={css`margin-left: 40px;`}>
                    Requested Animals
                </div>
                <div className="column has-text-right">
                    <NavLink className="nav-link" to="/available_animal">
                        <button className="button is-medium is-success" css={css`margin-right: 10px;`}>
                            Request
                        </button>
                    </NavLink>
                    <button
                        onClick={ () => editDispatch({ currentState: inEditMode })} 
                        className={`button is-medium ${inEditMode ? "is-info" : "is-danger"}`}>
                            {inEditMode ? "Save" : "Cancel"}
                    </button>
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
                                        css={css`margin-left: 40px;`}
                                        className="button is-small is-danger has-text-weight-medium is-uppercase">
                                            Cancel
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

export default CancelRequest;