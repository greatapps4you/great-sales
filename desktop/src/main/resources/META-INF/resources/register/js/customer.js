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

const save_url = "http://localhost:8080/customers/save";
const list_url = "http://localhost:8080/customers/list";
const remove_url = "http://localhost:8080/customers/remove/";
const find_url = "http://localhost:8080/customers/find/";

// Init UI
$(document).ready(function () {
    list();

    $(function () {
        $("#tabs").tabs();
    });
});

$(document).ready(function () {

    $("#save").click(function () {

        const identification = {
            name: $("#name").val(),
            tradeName: $("#tradeName").val(),
            taxId: $("#taxId").val()
        };

        const address = {
            street: $("#street").val(),
            number: $("#number").val(),
            complement: $("#complement").val(),
            zip: $("#zip").val(),
            neighborhood: $("#neighborhood").val(),
            city: $("#city").val(),
            countryState: $("#countryState").val(),
            country: $("#country").val(),
            website: $("#website").val(),
            email: $("#email").val(),
            cellPhone: $("#cellPhone").val(),
            phone: $("#phone").val()
        };

        const customer = JSON.stringify({
            identification: identification,
            address: address,
            billingAddress: address
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
            "<th>RAZÃO SOCIAL</th>" +
            "<th>CNPJ</th>" +
            "<th>CLIENTE DESDE</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < customers.length; i++) {
            const uuid = customers[i].uuid;
            const registrationDate = customers[i].registrationDate[2] + "/"
                + customers[i].registrationDate[1] + "/"
                + customers[i].registrationDate[0];
            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + customers[i].identification.name + "</td>"
                + "<td>" + customers[i].identification.taxId + "</td>"
                + "<td>" + registrationDate + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if (customers.length == 0) {
            $("#all_customers").html("Nenhum Cliente Cadastrado");
        } else {
            $("#all_customers").html(results_table);
        }
    });
}

function clearFields() {
    $(document).ready(function () {
        $("#name").val("");
        $("#tradeName").val("");
        $("#taxId").val("");
        $("#street").val("");
        $("#number").val("");
        $("#complement").val("");
        $("#zip").val("");
        $("#neighborhood").val("");
        $("#city").val("");
        $("#countryState").val("");
        $("#country").val("");
        $("#website").val("");
        $("#email").val("");
        $("#cellPhone").val("");
        $("#phone").val("");
    });
}



