/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

const save_url = "http://localhost:8080/customers/save";
const list_url = "http://localhost:8080/customers/list";
const remove_url = "http://localhost:8080/customers/remove/";
const find_url = "http://localhost:8080/customers/find/";

list();

$(document).ready(function () {

    $("#save").click(function () {
        const name = $("#name").val();
        const street = $("#street").val();

        const identification = {
            name: name
        };

        const address = {
            street: street
        };

        const customer = JSON.stringify({
            identification: identification,
            address: address,
        });

        $.ajax({
            url: save_url,
            type: "POST",
            data: customer,
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
    }).done(function (customers) {
        let results_table = "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>UUID</th>" +
            "<th>NOME</th>" +
            "<th>RUA</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < customers.length; i++) {
            const uuid = customers[i].uuid;
            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + customers[i].identification.name + "</td>"
                + "<td>" + customers[i].address.street + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if(customers.length == 0) {
            $("#all_customers").html("Nenhum Cliente Cadastrado");
        } else {
            $("#all_customers").html(results_table);
        }
    });
}

function clearFields() {
    $(document).ready(function () {
        $("#name").val("");
        $("#street").val("");
    });
}



