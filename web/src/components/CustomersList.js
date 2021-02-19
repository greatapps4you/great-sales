import React from 'react';
import axios from '../../node_modules/yarn/node_modules/axios';


class CustomersList extends React.Component {
    render() {
        return (
        <div>
            <h1>Lista de Clientes</h1>
        </div>

        )
    }

}


export default CustomersList;

/*
Customers() {

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
*/