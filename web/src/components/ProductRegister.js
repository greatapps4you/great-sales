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
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

import React from "react";
import axios from "axios";

class ProductRegister extends React.Component {

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
                <h1>Cadastro de Produtos</h1>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Código de Barras:
                        <input
                            name="sku"
                            type="text"
                            placeholder="Codigo de Barras"
                            value={this.state.name}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <label>
                        Produto:
                        <input
                            name="description"
                            type="text"
                            placeholder="Descricao Detalhada do Produto"
                            value={this.state.description}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <input
                        type="submit"
                        value="Cadastrar"/>
                </form>
            </div>

        );
    }
}

export default ProductRegister;