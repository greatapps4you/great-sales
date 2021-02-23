import React from 'react';
import axios from 'axios';
import ProductsList from './ProductsList.js';
import ProductRegister from "./ProductRegister";

class Products extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            sku: "",
            description: "",
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state);
        axios.post("http://localhost:8080/products/save", this.state)
            .then(response => {
                console.log(response)
                const { data: { description } } = response;
                alert(`${description} cadastrado com sucesso.`);
            })
            .catch(error => {
                console.log(error)
            })
    }


    render() {
        return (
                <div>
                    <ProductRegister />
                    <ProductsList />
                </div>

        );
    }
}

export default Products;