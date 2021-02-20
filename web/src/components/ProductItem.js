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

import React, {Component} from "react";

function ProductItem(props) {
    return (
        <div>
            {props.sku}: {props.description}
        </div>
    )
}

export default ProductItem;

//    handleDelete(props.uuid) {
//         if (window.confirm('Voce tem certeza que deseja deletar esse item?')) {
//             axios.delete("http://localhost:8080/products/remove/"+props.uuid)
//             .then(data => {
//             console.log(data)
//             })
//             .catch(error => {
//             console.log(error)
//             })
//         }
//     }