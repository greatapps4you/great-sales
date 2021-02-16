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

/*Generate UUID*/
function UUID_random() {
    let current_time = new Date().getTime();
    const uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        const r = (current_time + Math.random() * 16) % 16 | 0;
        current_time = Math.floor(current_time / 16);
        return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
    return uuid;
}

/*Dropdown SearchBox*/
function filter(search_field, dropdown_button) {
    let input, filter, ul, li, a, i;
    input = search_field;
    filter = input.value.toUpperCase();
    let div = dropdown_button;
    a = div.getElementsByTagName("a");
    let value;
    for (i = 0; i < a.length; i++) {
        value = a[i].textContent || a[i].innerText;
        if (value.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}
