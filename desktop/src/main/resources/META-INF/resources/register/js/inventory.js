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

const products_list_url = "http://localhost:8080/products/list";
const vendors_list_url = "http://localhost:8080/vendors/list";

const decimal_regex = /^\d+(?:\.\d{1,2})?$/;
let selected_product = undefined;
let selected_vendor = undefined;

// Init UI
$(document).ready(function () {
    list();

    $(function () {
        $("#buyingDate").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });

    $(function () {
        $("#tabs").tabs();
    });
});

// Product Search Box
$(document).ready(function () {
    $("#product-toggle").click(function () {
        $("#product-dropdown").toggleClass("show");
    });

    build_products_dropbox();
});

function build_products_dropbox() {

    $.ajax({
        url: products_list_url,
        type: "GET",
        dataType: "json"
    }).done(function (products) {
        let dropdown_content = '<input id="product-search-box" class="text-field" type="text" placeholder="Filtrar...">';

        for (let i = 0; i < products.length; i++) {
            dropdown_content += '<span data=\'' + JSON.stringify(products[i]) + '\'>'
                + products[i].description + '</span>';
        }

        if (products.length == 0) {
            $("#product-dropdown").html("Nenhum Produto Cadastrado");
            selected_product = undefined;
        } else {
            $("#product-dropdown").html(dropdown_content);

            //Only at this moment the child elements of dropdown will be in DOM
            $("#product-dropdown span").click(function () {
                // Handle the selected item right here
                let fetched_product = JSON.parse($(this).attr("data"));
                selected_product = fetched_product;
                $("#product").val(fetched_product.description);
                $("#product-dropdown").toggleClass("show");
            });

            $("#product-search-box").keyup(function () {
                let input, filter, ul, li, a, i;
                input = document.getElementById("product-search-box");
                filter = input.value.toUpperCase();
                let div = document.getElementById("product-dropdown");
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

// Vendor Search Box
$(document).ready(function () {
    $("#vendor-toggle").click(function () {
        $("#vendor-dropdown").toggleClass("show");
    });

    build_vendors_dropbox();
});

function build_vendors_dropbox() {

    $.ajax({
        url: vendors_list_url,
        type: "GET",
        dataType: "json"
    }).done(function (vendors) {
        let dropdown_content = '<input id="vendor-search-box" class="text-field" type="text" placeholder="Filtrar...">';

        for (let i = 0; i < vendors.length; i++) {
            dropdown_content += '<span data=\'' + JSON.stringify(vendors[i]) + '\'>'
                + vendors[i].identification.name + '</span>';
        }

        if (vendors.length == 0) {
            $("#vendor-dropdown").html("Nenhum Fornecedor Cadastrado");
            selected_vendor = undefined;
        } else {
            $("#vendor-dropdown").html(dropdown_content);

            //Only at this moment the child elements of dropdown will be in DOM
            $("#vendor-dropdown span").click(function () {
                // Handle the selected item right here
                let fetched_vendor = JSON.parse($(this).attr("data"));
                selected_vendor = fetched_vendor;
                $("#vendor").val(fetched_vendor.identification.name);
                $("#vendor-dropdown").toggleClass("show");
            });

            $("#vendor-search-box").keyup(function () {
                let input, filter, ul, li, a, i;
                input = document.getElementById("vendor-search-box");
                filter = input.value.toUpperCase();
                let div = document.getElementById("vendor-dropdown");
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

// Save
$(document).ready(function () {

    $("#save").click(function () {
        let inventoryItem = JSON.stringify({
            vendor: selected_vendor,
            product: selected_product,
            unit: $("#unit").val(),
            quantity: $("#quantity").val(),
            minimalThreshold: $("#minimalThreshold").val(),
            buyingPrice: $("#buyingPrice").val(),
            sellingPrice: $("#sellingPrice").val(),
            buyingDate: $("#buyingDate").val()
        });

        $.ajax({
            url: save_url,
            type: "POST",
            data: inventoryItem,
            contentType: "application/json",
            dataType: "json"
        }).done(function (savedInventoryItem) {
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
    }).done(function (inventoryItems) {
        let results_table = "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>UUID</th>" +
            "<th>PRODUTO</th>" +
            "<th>QUANTIDADE</th>" +
            "<th>PREÇO VENDA</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < inventoryItems.length; i++) {
            const uuid = inventoryItems[i].uuid;
            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + inventoryItems[i].product.description + "</td>"
                + "<td>" + inventoryItems[i].quantity + "</td>"
                + "<td>" + inventoryItems[i].sellingPrice + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if (inventoryItems.length == 0) {
            $("#all_inventory").html("Estoque Vazio");
        } else {
            $("#all_inventory").html(results_table);
        }
    });
}

function clearFields() {
    $(document).ready(function () {

        // Values
        $("#sku").val("");
        $("#description").val("");
        $("#quantity").val("0.00");
        $("#minimalThreshold").val("0.00");
        $("#buyingPrice").val("0.00");
        $("#sellingPrice").val("0.00");
        $("#buyingDate").val("");

        // Entities
        $("#unit").val("KG");
        $("#product").val("");
        $("#vendor").val("");

        selected_product = undefined;
        selected_vendor = undefined;
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


