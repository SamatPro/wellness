<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Wellness - лучший сервис для похудения! ${article.title}</title>
    <meta name="keywords" content="Похудение, wellness, здоровье, питание, еда, сервис">
    <meta name="description" content="Wellness - лучший сервис для похудения! С его помощью вы быстро и легко достигните своей цели!">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link href="https://fonts.googleapis.com/css?family=Damion|Dancing+Script|Oswald|Caveat|Merriweather" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <link href="${springMacroRequestContext.contextPath}/server.img/logo.png" rel="icon" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="${springMacroRequestContext.contextPath}/articles" >
        <i class="fa fa-reply back-button"></i>
        <span class="back-button ml-3" >Назад</span>
    </a>
    <form method="post" action="${springMacroRequestContext.contextPath}/articles/addfavorite" >
        <span class="navbar-text mr-2">
            <#if avgGrade??>
                Оценка: ${avgGrade[0..*4]}
                <#else>
                Оценок нет
            </#if>
        </span>
        <#if user??>
            <#if isFavorite>
                <input type="hidden" value="${article.id}" name="article_id">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa ddfa-heart-o"></i> Убрать из избранного</button>
            <#else>
                <input type="hidden" value="${article.id}" name="article_id">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa fa-heart"></i> В избранное</button>
            </#if>
        </#if>
           </form>
</nav>
<div class="container article col-lg-10 article-form">
    <h2>${article.title}</h2>
    <div id="carouselExampleSlidesOnly" class="carousel slide my-5" data-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${springMacroRequestContext.contextPath}${article.mainImg.fileName}" class="d-block w-100">
        </div>
      </div>
    </div>
    <p style="margin-bottom: 10%;">
    ${article.text}
    </p>
</div>

<nav class="navbar navbar-light bg-light fixed-bottom py-1">
    <p><span style="font-weight: bold;">Автор:</span> ${article.user.firstName} ${article.user.lastName}</p>
    <#if user??>
        <form method="post" action="${springMacroRequestContext.contextPath}/articles/${article.id}/evaluate">
            <div class="star-rating">
                <div class="star-rating__wrap">
                    <input class="star-rating__input" id="star-rating-5" type="submit" name="grade" value="5">
                    <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-5" title="5 из 5"></label>
                    <input class="star-rating__input" id="star-rating-4" type="submit" name="grade" value="4">
                    <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-4" title="4 из 5"></label>
                    <input class="star-rating__input" id="star-rating-3" type="submit" name="grade" value="3">
                    <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-3" title="3 из 5"></label>
                    <input class="star-rating__input" id="star-rating-2" type="submit" name="grade" value="2">
                    <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-2" title="2 из 5"></label>
                    <input class="star-rating__input" id="star-rating-1" type="submit" name="grade" value="1">
                    <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-1" title="1 из 5"></label>
                    <label style="float: right; font-weight: bold;">Оценить статью:</label>
                    <#if usersGrade??>
                        <label style="float: right; font-weight: bold;" class="mr-3">Ваша оценка статьи: ${usersGrade}</label>
                    </#if>
                </div>
            </div>

        </form>
    </#if>

</nav>
</body>
</html>