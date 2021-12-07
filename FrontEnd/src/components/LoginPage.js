/** @jsx jsx */
import { css, jsx } from '@emotion/react';
import React from 'react';
import logo from './ucvm-logo.png';
import { NavLink } from "react-router-dom";

const LoginPage = () => {
    return (
        <div>
            <div css={css`display: flex; justify-content: center; margin-top: 20px;`} className="container">
                <React.Fragment>
                <img src={logo} alt="University of Calgary - Faculty of Veterinary Medicine" width="500"/>
                </React.Fragment>
            </div>
            <div css={css`display: flex; justify-content: center; margin-top: 30px;`}>
                <input 
                    css={css`max-width: 40%; text-align:center; border: 1px solid;`}  
                    type="text" className="input is-medium" placeholder="username / email"/>
            </div>
            <div css={css`display: flex; justify-content: center; margin-top: 10px;`}>
                <input 
                    css={css`max-width: 40%; text-align:center; border: 1px solid;`}  
                    type="text" className="input is-medium" placeholder="password"/>
            </div>
            <div css={css`display: flex; justify-content: center; margin-top: 10px`} className="container">
                <div className="nav-item">
                    <NavLink className="nav-link" to="/available_animal">
                        <button className="button is-medium is-success"><strong>Sign In</strong></button>
                    </NavLink>
                </div>
            </div>
            <div css={css`display: flex; justify-content: center; margin-top: 80px;`} className="container">
                <p css={css`margin-right: 70px`}>forgot password?</p>
                <p>contact admin</p>
            </div>
        </div>  
    );
}

export default LoginPage;