/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faDog } from '@fortawesome/free-solid-svg-icons';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';

const CreateAnimal = () => {
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
                                                <input class="input is-medium" type="text" placeholder="e.g. Dog" />
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
                                                <input class="input is-medium" type="text" placeholder="e.g. Beagle" />
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
                                                <input class="input is-medium" type="text" placeholder="name" />
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
                                        <select>
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
                                                <input class="input is-medium" type="text" placeholder="e.g 0.5" />
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
                                                <input class="input is-medium" type="text" placeholder="e.g. 120.58" />

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

export default CreateAnimal;