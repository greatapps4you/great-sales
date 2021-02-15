import React from 'react';

function ProdItem(props) {
return (
    <div>
    {props.name} : {props.description}
    </div>
);

}

export default ProdItem;