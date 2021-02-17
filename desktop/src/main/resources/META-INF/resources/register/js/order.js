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

const customers_list_url = "http://localhost:8080/customers/list";
const salesmen_list_url = "http://localhost:8080/salesmen/list";
const carriers_list_url = "http://localhost:8080/carriers/list";

const decimal_regex = /^\d+(?:\.\d{1,2})?$/;
let items = [];
let selected_customer = undefined;
let selected_salesman = undefined;
let selected_carrier = undefined;

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

    build_customers_dropbox();
});

function build_customers_dropbox() {

    $.ajax({
        url: customers_list_url,
        type: "GET",
        dataType: "json"
    }).done(function (customers) {
        let dropdown_content = '<input id="customer-search-box" class="text-field" type="text" placeholder="Filtrar...">';

        for (let i = 0; i < customers.length; i++) {
            dropdown_content += '<span data=\'' + JSON.stringify(customers[i]) + '\'>'
                + customers[i].identification.name + '</span>';
        }

        if (customers.length == 0) {
            $("#customer-dropdown").html("Nenhum Cliente Cadastrado");
            selected_customer = undefined;
        } else {
            $("#customer-dropdown").html(dropdown_content);

            //Only at this moment the child elements of dropdown will be in DOM
            $("#customer-dropdown span").click(function () {
                // Handle the selected item right here
                let fetched_customer = JSON.parse($(this).attr("data"));
                selected_customer = fetched_customer;
                $("#customer").val(fetched_customer.identification.name);
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
        }
    });
}

// Salesman Search Box
$(document).ready(function () {
    $("#salesman-toggle").click(function () {
        $("#salesman-dropdown").toggleClass("show");
    });

    build_salesmen_dropbox();
});

function build_salesmen_dropbox() {

    $.ajax({
        url: salesmen_list_url,
        type: "GET",
        dataType: "json"
    }).done(function (salesmen) {
        let dropdown_content = '<input id="salesman-search-box" class="text-field" type="text" placeholder="Filtrar...">';

        for (let i = 0; i < salesmen.length; i++) {
            dropdown_content += '<span data=\'' + JSON.stringify(salesmen[i]) + '\'>'
                + salesmen[i].identification.name + '</span>';
        }

        if (salesmen.length == 0) {
            $("#salesman-dropdown").html("Nenhum Vendedor Cadastrado");
            selected_salesman = undefined;
        } else {
            $("#salesman-dropdown").html(dropdown_content);

            //Only at this moment the child elements of dropdown will be in DOM
            $("#salesman-dropdown span").click(function () {
                // Handle the selected item right here
                let fetched_salesman = JSON.parse($(this).attr("data"));
                selected_salesman = fetched_salesman;
                $("#salesman").val(fetched_salesman.identification.name);
                $("#salesman-dropdown").toggleClass("show");
            });

            $("#salesman-search-box").keyup(function () {
                let input, filter, ul, li, a, i;
                input = document.getElementById("salesman-search-box");
                filter = input.value.toUpperCase();
                let div = document.getElementById("salesman-dropdown");
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
        }
    });
}

// Carrier Search Box
$(document).ready(function () {
    $("#carrier-toggle").click(function () {
        $("#carrier-dropdown").toggleClass("show");
    });

    build_carriers_dropbox();
});

function build_carriers_dropbox() {
    $.ajax({
        url: carriers_list_url,
        type: "GET",
        dataType: "json"
    }).done(function (carriers) {
        let dropdown_content = '<input id="carrier-search-box" class="text-field" type="text" placeholder="Filtrar...">';

        for (let i = 0; i < carriers.length; i++) {
            dropdown_content += '<span data=\'' + JSON.stringify(carriers[i]) + '\'>'
                + carriers[i].identification.name + '</span>';
        }

        if (carriers.length == 0) {
            $("#carrier-dropdown").html("Nenhuma Transportadora Cadastrada");
            selected_carrier = undefined;
        } else {
            $("#carrier-dropdown").html(dropdown_content);

            //Only at this moment the child elements of dropdown will be in DOM
            $("#carrier-dropdown span").click(function () {
                // Handle the selected item right here
                let fetched_carrier = JSON.parse($(this).attr("data"));
                selected_carrier = fetched_carrier;
                $("#carrier").val(fetched_carrier.identification.name);
                $("#carrier-dropdown").toggleClass("show");
            });

            $("#carrier-search-box").keyup(function () {
                let input, filter, ul, li, a, i;
                input = document.getElementById("carrier-search-box");
                filter = input.value.toUpperCase();
                let div = document.getElementById("carrier-dropdown");
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
        }
    });
}

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
            customer: selected_customer,
            salesman: selected_salesman,
            carrier: selected_carrier,
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

        //Entities
        $("#customer").val("");
        $("#salesman").val("");
        $("#carrier").val("");

        //Variables
        items = [];
        selected_customer = undefined;
        selected_salesman = undefined;
        selected_carrier = undefined;

    });
}