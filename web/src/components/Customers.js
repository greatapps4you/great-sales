import React from 'react';
import axios from 'axios';
import CustomersList from './CustomersList.js';


class Customers extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "",
            tradeName: "",
            taxId: ""
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
        axios.post("http://localhost:8080/customers/save", this.state)
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
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Razao Social:
                        <input
                            name="name"
                            type="text"
                            placeholder="Razao Social"
                            value={this.state.name}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <label>
                        Nome Fantasia:
                        <input
                            name="tradeName"
                            type="text"
                            placeholder="Nome Fantasia"
                            value={this.state.description}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <label>
                        CNPJ:
                        <input
                            name="taxId"
                            type="number"
                            placeholder="CNPJ"
                            value={this.state.description}
                            onChange={this.handleInputChange}/>
                    </label>
                    <br/>
                    <input
                        type="submit"
                        value="Cadastrar"/>
                </form>

                <div>
                    <CustomersList/>
                </div>
            </div>

        );
    }
}

export default Customers;
