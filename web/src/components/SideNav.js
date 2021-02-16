import React from 'react';
import logo from '../img/greatapps4you_logo.png'

function SideNav() {
    return (
        <aside className="side-nav">
            <img className="logo" src={logo} alt="GreatApps4you"/>
            <div className="menu">
                <a href="#">Pedidos</a>
                <a href="#">Produtos</a>
                <a href="#">Clientes</a>
                <a href="#">Fornecedores</a>
                <a href="#">Transportadoras</a>
                <a href="#">Vendedores</a>
            </div>
        </aside>
    )
}

export default SideNav;