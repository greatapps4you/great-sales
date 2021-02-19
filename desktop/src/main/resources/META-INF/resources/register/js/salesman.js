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

const save_url = "http://localhost:8080/salesmen/save";
const list_url = "http://localhost:8080/salesmen/list";
const remove_url = "http://localhost:8080/salesmen/remove/";
const find_url = "http://localhost:8080/salesmen/find/";

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
            name: $("#name").val()
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

        const salesman = JSON.stringify({
            identification: identification,
            address: address
        });

        $.ajax({
            url: save_url,
            type: "POST",
            data: salesman,
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
    }).done(function (salesmen) {
        let results_table = "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>UUID</th>" +
            "<th>NOME</th>" +
            "<th>EMAIL</th>" +
            "<th>CELULAR</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < salesmen.length; i++) {
            const uuid = salesmen[i].uuid;
            results_table += "<tr>"
                + "<td>" + uuid + "</td>"
                + "<td>" + salesmen[i].identification.name + "</td>"
                + "<td>" + salesmen[i].address.email + "</td>"
                + "<td>" + salesmen[i].address.cellPhone + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if (salesmen.length == 0) {
            $("#all_salesmen").html("Nenhum Vendedor Cadastrado");
        } else {
            $("#all_salesmen").html(results_table);
        }
    });
}

function clearFields() {
    $(document).ready(function () {
        $("#name").val("");
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



