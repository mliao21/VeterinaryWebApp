/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import React, { useReducer } from "react";

const Technician = ({animals}) => {
    const editSaveReducer = (state, action) => {
        return !state;
      }

    const [inEditMode, editDispatch] = useReducer(editSaveReducer, false);

    return (
        <header className="title">
            <div className="is-size-2 has-text-link-dark has-background-link-light" css={css`display: flex; align-items: center;`}>
                <div css={css`margin-left: 40px;`}>
                    Animal Requests
                </div>
                <div className="column has-text-right">
                    <button
                        onClick={ () => editDispatch({ currentState: inEditMode })} 
                        className={`button is-medium ${inEditMode ? "is-info" : "is-link"}`}>
                            {inEditMode ? "Save" : "Approve | Reject"}
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
                                {inEditMode ? (
                                    <div class="buttons has-addons" css={css`margin-left: 40px;`}>
                                        <button className="button">
                                            <span className="icon">
                                                <i className="fa fa-check"></i>
                                            </span>
                                            <span>approve</span>
                                        </button>
                                        <button className="button" css={css`margin-left: 20px;`}>
                                            <span className="icon">
                                                <i className="fa fa-times"></i>
                                            </span>
                                            <span>reject</span>
                                        </button>
                                    </div>)
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

export default Technician;