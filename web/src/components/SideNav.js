import React from 'react';
import greatapps from '../img/greatapps.png'

function SideNav() {
return (
<aside className="side-nav">
    <img className="logo" src={greatapps} alt="logo" />
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