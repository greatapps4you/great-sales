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

const decimal_regex = /^\d+(?:\.\d{1,2})?$/;
let items = [];

// Init View
$(document).ready(function () {
    list();
    updateItems();
});

// Customer Search Box
$(document).ready(function () {
    $("#customer-toggle").click(function () {
        $("#customer-dropdown").toggleClass("show");
    });

    $("#customer-dropdown").click(function () {
        // Handle the selected item right here
        $("#customer-dropdown").toggleClass("show");
    });

    $("#customer-search-box").keyup(function () {
        let input, filter, ul, li, a, i;
        input = document.getElementById("customer-search-box");
        filter = input.value.toUpperCase();
        let div = document.getElementById("customer-dropdown");
        a = div.getElementsByTagName("span");
        let value;
        for (i = 0; i < a.length; i++) {
            value = a[i].textContent || a[i].innerText;
            if (value.toUpperCase().indexOf(filter) > -1) {
                a[i].style.display = "";
            } else {
                a[i].style.display = "none";
            }
        }
    });
});

// Add Order Items
$(document).ready(function () {
    $("#include").click(function () {
        let item = {
            uuid: UUID_random(),
            product: $("#product").val(),
            unValue: $("#unValue").val(),
            productQuantity: $("#productQuantity").val(),
            total: $("#unValue").val() * $("#productQuantity").val()
        };

        items.push(item);
        clear_item_fields();

        updateItems();
    });
});

function clear_item_fields() {
    $("#product").val("");
    $("#unValue").val("");
    $("#productQuantity").val("");
}


function updateItems() {
    let results_table = "<table>" +
        "<thead>" +
        "<tr>" +
        "<th>UUID</th>" +
        "<th>Descrição</th>" +
        "<th>Quantidade</th>" +
        "<th>Vlr. Un.</th>" +
        "<th>Total</th>" +
        "<th></th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";

    for (let i = 0; i < items.length; i++) {

        results_table += "<tr>"
            + "<td>" + items[i].uuid + "</td>"
            + "<td>" + items[i].product + "</td>"
            + "<td>" + items[i].productQuantity + "</td>"
            + "<td>" + items[i].unValue + "</td>"
            + "<td>" + items[i].total + "</td>"
            + "<td><a class='button-link-remove'>X</a></td>"
            + "</tr>";
    }
    results_table += "</tbody>" +
        "</table>";

    if (items.length == 0) {
        $("#order_items").html("Nenhum Produto adicionado...");
    } else {
        $("#order_items").html(results_table);
    }
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

$(document).ready(function () {
    $("#save").click(function () {
        const order = JSON.stringify({
            customer: {uuid: "0eeb4f40-c26b-41a7-8198-86bdfe926906"},
            salesman: {uuid: "8e1b7b24-461e-4fa7-a824-7718b7fcf6b3"},
            carrier: {uuid: "8df71274-5709-41ee-adc0-a56727bdd34c"},
            items: items,

            totalAmount: $("#totalAmount").val(),
            deliveryAddress: {
                street: $("#deliveryStreet").val(),
                number: $("#deliveryStreetNumber").val(),
                zip: $("#deliveryZip").val(),
                neighborhood: $("#deliveryNeighborhood").val(),
                city: $("#deliveryCity").val(),
                countryState: $("#deliveryState").val(),
            },
            mailMessage: $("#mailMessage").val(),
            mailOrderTo: $("#mailOrderTo").val(),
            mailInvoiceTo: $("#mailInvoiceTo").val(),
            deliveryDate: $("#deliveryDate").val(),
            deliveryFee: $("#deliveryFee").val(),
            commissionInCurrency: $("#totalAmount").val() * $("#commissionInPercentage").val(),
            commissionInPercentage: $("#commissionInPercentage").val(),
            taxInPercentage: $("#taxInPercentage").val(),
            customerOrderNumber: $("#customerOrderNumber").val(),
            paymentConditions: $("#paymentConditions").val(),
            observations: $("#observations").val()
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
            "<th>CLIENTE</th>" +
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
                + "<td>" + orders[i].customer.identification.name + "</td>"
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
        /* Delivery Address*/
        $("#deliveryStreet").val("");
        $("#deliveryStreetNumber").val("");
        $("#deliveryZip").val("");
        $("#deliveryNeighborhood").val("");
        $("#deliveryCity").val("");
        $("#deliveryState").val("");

        //Decimal Fields
        $("#totalAmount").val("0.00");
        $("#deliveryFee").val("0.00")
        $("#commissionInPercentage").val("2.00")

        //Sales Fields
        items = [];

    });
}