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

const save_url = "http://localhost:8080/inventory/save";
const list_url = "http://localhost:8080/inventory/list";
const remove_url = "http://localhost:8080/inventory/remove/";
const find_url = "http://localhost:8080/inventory/find/";

const decimal_regex = /^\d+(?:\.\d{1,2})?$/;
let selected_product = undefined;

// Init Screen
$(document).ready(function () {
    list();

    $(function () {
        $("#buyingDate").datepicker({
            dateFormat:"yy-mm-dd"
        });
    });
});

$(document).ready(function () {

    $("#save").click(function () {
        const sku = $("#sku").val();
        const description = $("#description").val();

        const product = JSON.stringify({
            sku: sku,
            description: description
        });

        $.ajax({
            url: save_url,
            type: "POST",
            data: product,
            contentType: "application/json",
            dataType: "json"
        }).done(function (savedProduct) {
            clearFields();
            list();
        });
    });
});

function list() {
    $.ajax({
        url: list_url,
        type: "GET",
        dataType: "json"
    }).done(function (products) {
        let results_table = "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>UUID</th>" +
            "<th>SKU</th>" +
            "<th>DESCRIÇÃO</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < products.length; i++) {
            const uuid = products[i].uuid;
            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + products[i].sku + "</td>"
                + "<td>" + products[i].description + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if(products.length == 0) {
            $("#all_products").html("Nenhum Produto Cadastrado");
        } else {
            $("#all_products").html(results_table);
        }
    });
}

function clearFields() {
    $(document).ready(function () {
        $("#sku").val("");
        $("#description").val("");
    });
}

$(document).ready(function () {
    $(":input[type='number']").blur(function () {
        let value = $(this).val();
        let input = $(this);
        if (decimal_regex.test(value)) {
            input.css('background-color', 'white');
        } else {
            input.css('background-color', 'red');
        }
    });
});


