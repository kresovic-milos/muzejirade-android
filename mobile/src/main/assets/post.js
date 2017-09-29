'use strict';

function parse() {
    document.getElementById("main-header").innerHTML = "";
    document.getElementById("main-header").outerHTML = "";

    document.getElementsByClassName("et_post_meta_wrapper")[0].innerHTML = "";
    document.getElementsByClassName("et_post_meta_wrapper")[0].outerHTML = "";

    document.getElementsByClassName("et_post_meta_wrapper")[1].innerHTML = "";
    document.getElementsByClassName("et_post_meta_wrapper")[1].outerHTML = "";

    document.getElementsByClassName("abh_box")[0].innerHTML = "";
    document.getElementsByClassName("abh_box")[0].outerHTML = "";

    document.getElementsByClassName("the_champ_sharing_container")[0].innerHTML = "";
    document.getElementsByClassName("the_champ_sharing_container")[0].outerHTML = "";

    document.getElementsByClassName("ratings")[0].innerHTML = "";
    document.getElementsByClassName("ratings")[0].outerHTML = "";

    document.getElementById("main-footer").innerHTML = "";
    document.getElementById("main-footer").outerHTML = "";
}