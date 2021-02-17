import axios from '../../node_modules/yarn/node_modules/axios';

import React, { useEffect, useState } from 'react';
import ProductItem from './ProductItem.js';

function Products() {

const [productsList, setProductsList] = useState([]);

    useEffect((products) => {
        axios.get('http://localhost:8080/products/list').then((response) => {
            setProductsList(response.data);
        });
    }, []);

const handleClick = (event) => {
    event.preventDefault();
}

return (
    <div>
        <h1>Cadastro de Produtos</h1>
        <form className="new_product" onSubmit={handleClick}>
            <label>SKU: </label>
            <input />
            <label>Descricao: </label>
            <input />
            <button type="submit">Cadastrar</button>
        </form>

        <h3>Lista de Produtos</h3>
        <h3>Nome : Descricao</h3>
        {productsList.map((product) =>
        <ProductItem
        key={product.uuid}
        name={product.sku}
        description={product.description} /> )}

</div>
)
}

export default Products;