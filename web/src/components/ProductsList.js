import React, {Component} from 'react';
import axios from 'axios';
import ProductItem from "./ProductItem";


class ProductsList extends Component {

    constructor(props) {
        super(props)

        this.state = {
            products: []
        }
    }

    componentDidMount() {
        this.listAllProducts()
    }

    listAllProducts() {
        axios.get('http://localhost:8080/products/list')
            .then(response => {
                this.setState({products: response.data})
            })
            .catch(error => {
                console.log(error)
            })
    }

    render() {

        const {products} = this.state;

        return (
            <div>
                <h1>Lista de Produtos</h1>
                {products.map((product, index) =>
                    <ProductItem
                        key={index + 1}
                        sku={product.sku}
                        description={product.description}/>
                )}
            </div>

        )
    }

}


export default ProductsList;
