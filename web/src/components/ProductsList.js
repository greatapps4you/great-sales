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
        this.listAllProducts();
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

    deleteProduct = (productId) => {
        console.log(productId);
            axios.get('http://localhost:8080/products/remove/'+productId)
                .then(response => {
                    if (response.data != null) {
                        this.setState({
                            products: this.state.products.filter(product => product.uuid !== productId )  })
                    }
                })

    }

    render() {

        const {products} = this.state;

        return (
            <div>
                <h1>Lista de Produtos</h1>
                {products.map((product, index) => (
                    <div key={index + 1}>
                    <ProductItem
                        key={index + 1}
                        sku={product.sku}
                        description={product.description}/>
                        <button onClick={this.deleteProduct.bind(this, product.uuid)}>Excluir</button>
                    </div>
                    )
                )}
            </div>

        )
    }

}


export default ProductsList;

