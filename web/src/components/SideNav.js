import React from 'react';

function SideNav() {

const handleClick = () => console.log('Clicked');

    return (
        <aside className="side-nav">
            <h1 className="app-name">GreatSales</h1>
            <div className="menu">
                <button
                    onClick={handleClick}
                    >
                    Pedidos
                </button>
                <button
                    onClick={handleClick}
                    >
                    Produtos
                </button>
                <button
                    onClick={handleClick}
                    >
                    Clientes
                </button>
                <button
                    onClick={handleClick}
                    >
                    Fornecedores
                </button>
                <button
                    onClick={handleClick}
                    >
                    Transportadoras
                </button>
                <button
                    onClick={handleClick}
                    >
                    Vendedores
                </button>

            </div>
        </aside>
    )
}

export default SideNav;