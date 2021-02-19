import React from 'react';
import axios from '../../node_modules/yarn/node_modules/axios';


class ProductsList extends React.Component {

    constructor(props){
        super(props)

        this.state = {
            products: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8080/products/list')
        .then(response => {
            console.log(response)
            } )
        .catch(error => {
            console.log(error)
            } )
    }

    render() {
        return (
        <div>
            <h1>Lista de Produtos</h1>
        </div>

        )
    }

}


export default ProductsList;