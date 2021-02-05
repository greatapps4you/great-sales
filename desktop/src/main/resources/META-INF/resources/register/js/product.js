/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

const save_url = "http://localhost:8080/products/save";

$(document).ready(function () {
    $("#save").click(function () {
        const sku = $("#sku").val();
        const description = $("#description").val();

        const product =  JSON.stringify({
            sku: sku,
            description: description
        })

        $.ajax({
            url:save_url,
            type:"POST",
            data:product,
            contentType:"application/json",
            dataType:"json",
            success: function(response){
                $("#result").html(response);
            }
        })
    });
});
