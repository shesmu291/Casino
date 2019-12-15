$(document).ready(function () {
    alert("test");
    $.ajax({
        url: '/api/products/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (products) {
            for (let i = 0; i < products.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + products[i].id + "</td>" +
                    "<td>" + products[i].name + "</td>" +
                    "<td>" + products[i].price + "</td>" +
                    "<td>" + products[i].amount + "</td>" +
                    "<td>" +
                    "<a class=\"btn btn-info\" onclick=''>Edit</a>" +
                    "<a class=\"btn btn-danger\" href=\"/products/deleteProduct?id=" + products[i].id+"\">Delete</a>" +
                    "</td>" +
                    "</tr>")
            }
        }
    })




})