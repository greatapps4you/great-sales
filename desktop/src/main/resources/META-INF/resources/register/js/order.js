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
const list_url = "http://localhost:8080/orders/list";
const remove_url = "http://localhost:8080/orders/remove/";
const find_url = "http://localhost:8080/orders/find/";

list();

$(document).ready(function () {
    $("#save").click(function () {
        const order = JSON.stringify({
            orderNumber: Math.floor(Math.random() * 10000) + 1,
            customer: {uuid: "0eeb4f40-c26b-41a7-8198-86bdfe926906"},
            items: [],
            totalAmount: "150000.00",
            salesman: {uuid: "8e1b7b24-461e-4fa7-a824-7718b7fcf6b3"},
            deliveryAddress: null,
            billingAddress: null,
            mailMessage: "",
            mailOrderTo: "",
            mailInvoiceTo: "",
            deliveryDate: "2021-03-25",
            deliveryFee: "150.00",
            carrier: {uuid: "8df71274-5709-41ee-adc0-a56727bdd34c"},
            commissionInCurrency: "2000.00",
            commissionInPercentage: "2.00",
            taxInPercentage: "12.00",
            customerOrderNumber: "9999",
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
            "<th>NÚMERO PEDIDO</th>" +
            "<th>DATA PEDIDO</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < orders.length; i++) {
            const uuid = orders[i].uuid;
            const orderDate = orders[i].orderDate[2] + "/"
                + orders[i].orderDate[1] + "/"
                + orders[i].orderDate[0];

            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + orders[i].orderNumber + "</td>"
                + "<td>" + orderDate + "</td>"
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