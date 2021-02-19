import React from 'react';

function SideNav() {

const handleClick = () => console.log('Clicked');

    return (
        <aside className="side-nav">
            <h1 className="app-name">GreatSales</h1>
            <div className="menu">
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Pedidos
                </button>
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Produtos
                </button>
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Estoque
                </button>
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Clientes
                </button>
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Fornecedores
                </button>
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Transportadoras
                </button>
                <button
                    className="button-sidenav"
                    onClick={handleClick}
                    >
                    Vendedores
                </button>

            </div>
        </aside>
    )
}

export default SideNav;