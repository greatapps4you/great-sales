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


import axios from '../node_modules/yarn/node_modules/axios';

import React, { useEffect, useState } from 'react';
import Header from './components/Header.js'
import SideNav from './components/SideNav.js'
import ProductItem from './components/ProductItem.js';
import CustomerItem from './components/CustomerItem.js';

function App() {

const [productsList, setProductsList] = useState([]);
const [customersList, setCustomersList] = useState([]);

    useEffect((products) => {
 axios.get('http://localhost:8080/products/list').then((response) => {
 setProductsList(response.data);
 });
 }, []);

    useEffect((customers) => {
 axios.get('http://localhost:8080/customers/list').then((response) => {
 setCustomersList(response.data);
 });
 }, []);

 console.log(productsList);
 console.log(customersList);

  return (
    <div>
        <Header />
        <SideNav />


        <section className="main">
        <h1>Great Sales App</h1>

        <h2>Cadastro de Produtos</h2>
        <p>...</p>

        <h2>Lista de Produtos</h2>
        <h3>Nome : Descricao</h3>
        {productsList.map((product) =>
        <ProductItem
        key={product.uuid}
        name={product.sku}
        description={product.description} /> )}

        <h2>Cadastro de Clientes</h2>
        <p>...</p>

        <h2>Lista de Clientes</h2>
        <h3>Nome : CNPJ</h3>
                {customersList.map((customer) =>
                <CustomerItem
                key={customer.identification.uuid}
                name={customer.identification.name}
                cnpj={customer.identification.taxId}
                 />
        )}
    </section>
    </div>
  );
}

export default App;




