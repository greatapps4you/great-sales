/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 *
 * Team:
 * José Esteves de Souza Neto (Lead Engineer)
 * Renato Magrini (Front-End Developer)
 * Nathan Parra Ramos (Designer)
 *
 * CSSML NDSMD VRS + SNMV SMQL IVB */


import React from 'react';
import Header from './components/Header.js'
import SideNav from './components/SideNav.js'
import Welcome from "./components/Welcome";
import Products from './components/Products.js'
import Costumers from './components/Customers.js'

function App() {

    return (
        <div>
            <Header/>
            <SideNav/>

            <main>
                <Products/>
            </main>
        </div>
    );
}

export default App;




