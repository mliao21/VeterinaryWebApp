/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';
import { useState } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch, faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import axios from "axios";

const SearchAnimal = ({ animals }) => {

    const [filteredData, setFilteredData] = useState([]);

    const handleFilter = (event) => {
        const searchWord = event.target.value;
        const newFilter = animals.filter((value) => {
            return value.name.toLowerCase().includes(searchWord.toLowerCase());
        });
        if (searchWord === "") {
            setFilteredData([]);
        } else {
            setFilteredData(newFilter);
        }
    };

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
                                <button class="button is-info mr-2">Back</button>
                            </NavLink>
                            {/* <NavLink className="nav-link" to="/">
                                <button class="button is-info">Log out</button>
                            </NavLink> */}
                        </div>
                    </div>
                </div>
            </nav>

            <div className="title" css={css` margin-top: 70px;`}>
                <div className="searchInputs ml-5 mr-5">
                    <p class="control has-icons-right">
                        <input class="input" type="text" placeholder="Find by Username" onChange={handleFilter} />
                        <span class="icon is-medium is-right">
                            <FontAwesomeIcon icon={faSearch} />
                        </span>
                    </p>
                </div>
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
                            </tr>
                        </thead>
                        {filteredData.length != 0 && (
                            <tbody className="dataResults is-size-5">
                                {filteredData.map((value) => {
                                    return (
                                        <tr key={value.animalid}>
                                            <td>{value.animalid}</td>
                                            <td>{value.species}</td>
                                            <td>{value.breed}</td>
                                            <td>{value.name}</td>
                                            <td>{value.sex}</td>
                                            <td>{value.age}</td>
                                            <td>{value.weight}</td>
                                            <button class="button is-primary mb-1 mr-1" >
                                                <span class="icon is-medium is-right">
                                                    <FontAwesomeIcon icon={faEdit} />
                                                </span>
                                            </button>
                                            <button class="button is-danger mb-1" >
                                                <span class="icon is-medium is-right">
                                                    <FontAwesomeIcon icon={faTrash} />
                                                </span>
                                            </button>
                                        </tr>
                                    );
                                })}
                            </tbody>
                        )}
                    </table>
                </div>
            </div>
        </body>
    );
}

export default SearchAnimal;