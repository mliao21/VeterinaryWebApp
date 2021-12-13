/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faDog, faUser } from '@fortawesome/free-solid-svg-icons';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';

const AdminMain = () => {
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
                            <NavLink className="nav-link" to="/">
                                <button class="button is-info">Log out</button>
                            </NavLink>
                        </div>
                    </div>
                </div>
            </nav>
            <section class="section mt-6">
                <div class="container mt-4">
                    <div class="tile is-ancestor">
                        <div class="tile is-parent">
                            <div class="tile is-child box">
                                <p class="title has-text-centered has-text-weight-bold">ANIMAL</p>
                                {/* <i class="fas fa-dog"></i> */}
                                <FontAwesomeIcon icon={faDog} size="4x" css={css`display: block; margin: auto;`} />
                                <NavLink className="nav-link" to="/create_animal">
                                    <button class="button is-rounded is-medium is-fullwidth mt-5">Create Animal</button>
                                </NavLink>
                                <button class="button is-rounded is-medium is-fullwidth mt-3">Search / Modify Animal</button>
                                <button class="button is-rounded is-medium is-fullwidth mt-3">Daily Report</button>
                            </div>
                        </div>
                        <div class="tile is-parent">
                            <div class="tile is-child box">
                                <p class="title has-text-centered has-text-weight-bold">USER</p>
                                {/* <i class="fa fa-user"></i> */}
                                <FontAwesomeIcon icon={faUser} size="4x" css={css`display: block; margin: auto;`} />
                                <NavLink className="nav-link" to="/create_user">
                                    <button class="button is-rounded is-medium is-fullwidth mt-5">Create User</button>
                                </NavLink>
                                <NavLink className="nav-link" to="/search_user">
                                <button class="button is-rounded is-medium is-fullwidth mt-3">Search / Modify User</button>
                                </NavLink>
                                <NavLink className="nav-link" to="/user_list">
                                    <button class="button is-rounded is-medium is-fullwidth mt-3">List of Users</button>
                                </NavLink>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </body>
    );
}

export default AdminMain;