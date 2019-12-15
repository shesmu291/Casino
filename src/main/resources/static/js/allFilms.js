function test() {

    $.ajax({
        url: '/api/film/get?id=1',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (film) {
            console.log(film);
            alert("title:" + film.title);
            alert('success');
        },
        error: function (response) {
            alert('error');
        }
    });


}

$(document).ready(function () {
    $.ajax({
        url: '/api/film/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (films) {
            console.log(films);
            for (var i = 0; i < films.length; i++) {
                $("#forAdd").before(
                    "<tr>" +
                    "<td>" + films[i].id + "</td>" +
                    "<td>" + films[i].title + "</td>" +
                    "<td>" + films[i].rating + "</td>" +
                    "<td>" + films[i].age + "</td>" +
                    "<td>" +
                    "            <a class=\"btn btn-primary\" href=\"/film/editFilm?id=" + films[i].id + "\"  >Редактировать</a>" +
                    "            <a class=\"btn btn-danger\" href=\"/film/deleteFilm?id=" + films[i].id + "\"  >Удалить</a>" +
                    "        </td>" +
                    "</tr>")
            }

        },
        error: function (response) {
            alert('error');
        }
    });


});