import React from 'react';
import axios from 'axios';


class ProductsList extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            products: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8080/products/list')
            .then(response => {
                console.log(response)
                this.setState({products: response.data})
            })
            .catch(error => {
                console.log(error)
            })
    }

    render() {

        const {products} = this.state

        return (
            <div>
                <h1>Lista de Produtos</h1>
                {products.map(product => <div>{product.uuid}: {product.sku}: {product.description}</div>)}
            </div>

        )
    }

}


export default ProductsList;
