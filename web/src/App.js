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


import React, { useEffect, useState } from 'react';
import axios from '../node_modules/yarn/node_modules/axios';
import ProdItem from './components/proditem.js';

function App() {

const [productsList, setProductsList] = useState([]);

    useEffect(() => {
 axios.get('http://localhost:8080/products/list').then((response) => {
 setProductsList(response.data);
 });
 }, []);

 console.log(productsList)

  return (
    <div>
        <h1>Great Sales App</h1>
        <h2>Cadastro de Produtos</h2>
        <p>...</p>

        <h2>Products List</h2>
        {productsList.map((product) =>
        <ProdItem
        key={product.uuid}
        name={product.sku}
        description={product.description} />
        )}

    </div>
  );
}

export default App;




