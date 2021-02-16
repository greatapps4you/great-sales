import React from 'react';

function CustomerItem(props) {
return (
<div>
<div>{props.name}</div>
<div>{props.cnpj}</div>
</div>
)

}

export default CustomerItem;