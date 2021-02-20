import React from 'react';
import axios from 'axios';
import ProductsList from './ProductsList.js';


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
            })
            .catch(error => {
                console.log(error)
            })
    }

    render() {
        return (
            <div>
                <h1>Cadastro de Produtos</h1>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Codigo de Barras:
                        <input
                            name="sku"
                            type="text"
                            placeholder="Codigo de Barras"
                            value={this.state.name}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <label>
                        Descricao:
                        <input
                            name="description"
                            type="text"
                            placeholder="Descricao Detalhada"
                            value={this.state.description}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <input
                        type="submit"
                        value="Cadastrar"/>
                </form>

                <div>
                    <ProductsList/>
                </div>
            </div>

        );
    }
}

export default Products;