import axios from '../../node_modules/yarn/node_modules/axios';

import React, { useEffect, useState } from 'react';
import CustomerItem from './CustomerItem.js';

function Customers() {

    const [customersList, setCustomersList] = useState([]);

    useEffect((customers) => {
        axios.get('http://localhost:8080/customers/list').then((response) => {
            setCustomersList(response.data);
        });
    }, []);

    return (
        <div>
        <h3>Lista de Clientes</h3>
        <h3>Nome : CNPJ</h3>
                {customersList.map((customer) =>
                <CustomerItem
                key={customer.identification.uuid}
                name={customer.identification.name}
                cnpj={customer.identification.taxId}
                 />
        )}
        </div>
)

}

export default Customers;