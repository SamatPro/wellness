
$(document).ready(function(){
    $("#search-id").on('input', function postinput(){
        var name = $(this).val();
        if (name.length > 1){
            $.ajax({
                url: '/wellness/findByName',
                type: 'POST',
                data: {
                    'name': name
                },
                success: function (responseData) {
                    var contentUlHTML = "<ul>";
                    for (var i = 0; i < responseData.length; i++) {
                        if (responseData[i].photoSrc!=null){
                            contentUlHTML += "<li><img src='/wellness/uploads/" + responseData[i].photoSrc + "' width='30px'> ";
                        } else{
                            contentUlHTML += "<li><img src='/wellness/uploads/default.png' width='30px'> ";
                        }
                        contentUlHTML += "<a href='users/"+responseData[i].id+"'>" + responseData[i].firstName+ " ";
                        contentUlHTML += "" + responseData[i].lastName + "</a> ";
                        contentUlHTML += "<button onclick='subscribe("+responseData[i].id+")'>Подписаться</button>" + "</li> ";

                    }
                    contentUlHTML += "</ul>";
                    document.getElementById('inner').innerHTML = contentUlHTML;
                }
            }).done(function(responseData) {

            }).fail(function() {
                alert("Ошибка")
            });
        } else {
            $("#inner").innerHTML = "";
        }

    });
});

function subscribe(id) {
    $.ajax({
        url: '/wellness/addToFriend',
        type: 'POST',
        data: {
            'id': id
        }
    }).done(function() {
        alert("Добавлено")
    }).fail(function() {
        alert("Уже есть в друзьях")
    });
}