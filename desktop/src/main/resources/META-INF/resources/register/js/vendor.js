/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

const save_url = "http://localhost:8080/vendors/save";
const list_url = "http://localhost:8080/vendors/list";
const remove_url = "http://localhost:8080/vendors/remove/";
const find_url = "http://localhost:8080/vendors/find/";

list();

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

        const vendor = JSON.stringify({
            identification: identification,
            address: address
        });

        $.ajax({
            url: save_url,
            type: "POST",
            data: vendor,
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
    }).done(function (vendors) {
        let results_table = "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>RAZÃO SOCIAL</th>" +
            "<th>CNPJ</th>" +
            "<th>CIDADE</th>" +
            "<th></th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>";

        for (let i = 0; i < vendors.length; i++) {
            const uuid = vendors[i].uuid;
            results_table += "<tr>"
                + "<td>" + vendors[i].identification.name + "</td>"
                + "<td>" + vendors[i].identification.taxId + "</td>"
                + "<td>" + vendors[i].address.city + "</td>"
                + "<td><a class='button-link-remove' href='" + remove_url + uuid + "'>X</a></td>"
                + "</tr>";
        }
        results_table += "</tbody>" +
            "</table>";

        if (vendors.length == 0) {
            $("#all_vendors").html("Nenhum Fornecedor Cadastrado");
        } else {
            $("#all_vendors").html(results_table);
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



