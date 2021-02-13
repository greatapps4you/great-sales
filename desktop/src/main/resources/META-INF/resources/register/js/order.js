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

const save_url = "http://localhost:8080/orders/save";
const list_url = "http://localhost:8080/customers/list";
const remove_url = "http://localhost:8080/customers/remove/";
const find_url = "http://localhost:8080/customers/find/";

list();

$(document).ready(function () {
    $("#save").click(function () {
        const order = JSON.stringify({
            orderNumber: "",
            orderTime: "",
            customer: {},
            items: [],
            totalAmount: "",
            salesman: {},
            deliveryAddress: "",
            billingAddress: "",
            mailMessage: "",
            mailOrderTo: "",
            mailInvoiceTo: "",
            deliveryDate: "",
            deliveryFee: "",
            carrier: {},
            commissionInCurrency: "",
            commissionInPercentage: "",
            taxInPercentage: "",
            customerOrderNumber: "",
            paymentConditions: "",
            observations: ""
        });

        $.ajax({
            url: save_url,
            type: "POST",
            data: order,
            contentType: "application/json",
            dataType: "json"
        }).done(function (savedOrder) {
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
    }).done(function (orders) {
        let results_table = "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>UUID</th>" +
            "<th>DATA PEDIDO</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < orders.length; i++) {
            const uuid = orders[i].uuid;
            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + orders[i].orderTime + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if (orders.length == 0) {
            $("#all_orders").html("Nenhum Pedido Lançado");
        } else {
            $("#all_orders").html(results_table);
        }
    });
}

function clearFields() {
    $(document).ready(function () {

    });
}