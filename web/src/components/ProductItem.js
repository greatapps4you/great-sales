import React from 'react';

function ProductItem(props) {
return (
    <div>
    <div>{props.name}</div>
    <div>{props.description}</div>
    </div>
);

}

export default ProductItem;