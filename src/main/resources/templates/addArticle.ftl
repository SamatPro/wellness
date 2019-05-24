<!DOCTYPE html>
<html lang="en">
<head>
    <title>Wellness - лучший сервис для похудения! Добавление статьи</title>
    <meta name="keywords" content="Похудение, wellness, здоровье, питание, еда, сервис">
    <meta name="description" content="Wellness - лучший сервис для похудения! С его помощью вы быстро и легко достигните своей цели!">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link href="https://fonts.googleapis.com/css?family=Damion|Dancing+Script|Oswald|Caveat" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <link href="${springMacroRequestContext.contextPath}/server.img/logo.png" rel="icon" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand navbar-light bg-light fixed-top">
        <a class="navbar-brand" href="${springMacroRequestContext.contextPath}/articles" >
            <i class="fa fa-reply back-button"></i>
            <span class="back-button ml-3" >Назад</span>
        </a>
</nav>
<div class="container article-form" >
    <div class="row justify-content-center">
        <form method="post" class="col-10" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Введите заголовок статьи:</label>
                <input type="text" class="form-control" name="title" id="title" placeholder="Заголовок статьи">
            </div>
            <div class="form-group">
                <label for="text">Введите текст статьи:</label>
                <textarea class="form-control" name="text" id="text" rows="5"></textarea>
            </div>
            <div class="form-group">
                <label for="file">Загрузите главную фотографию статьи:</label>
                <input type="file" id="file" name="file">
            </div>
            <button type="submit" class="btn btn-success">Опубликовать</button>
        </form>
    </div>
</div>
</body>
</html>

