/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import { NavLink } from "react-router-dom";
import logo from './ucvm-logo.png';

const UserList = ({ users }) => {
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

            <div className="title" css={css` margin-top: 70px;`}>
                <div class="table-container">
                    <table className="table is-narrow is-striped is-fullwidth" css={css`margin-left: auto; margin-right: auto;`}>
                        <thead>
                            <tr className="is-size-4">
                                <th title="Animal ID">User ID</th>
                                <th title="Type">Role</th>
                                <th title="Breed">Username</th>
                                <th title="Name">Email</th>
                                <th title="Status">Status</th>
                            </tr>
                        </thead>
                        <tbody className="is-size-5">
                            {
                                users.map((item, index) => (
                                    <tr key={index}>
                                        <td>{users[index].userid}</td>
                                        <td>{users[index].role}</td>
                                        <td>{users[index].username}</td>
                                        <td>{users[index].email}</td>
                                        <td>{users[index].status}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </body>
    );
}

export default UserList;