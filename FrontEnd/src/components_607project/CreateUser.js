/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faUser, faKey } from '@fortawesome/free-solid-svg-icons';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';

const CreateUser = () => {
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
                                        <select>
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
                                                <input class="input is-medium" type="text" placeholder="name" />
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
                                                <input class="input is-medium" type="text" placeholder="example@ucalgary.ca" />
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
                                                <input class="input is-medium" type="text" placeholder="at least 8 characters" />
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
                                        <select>
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
                                    <NavLink className="nav-link" to="/admin_main">
                                        <button class="button is-success">
                                            Submit
                                        </button>
                                    </NavLink>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </body>
    );
}

export default CreateUser;