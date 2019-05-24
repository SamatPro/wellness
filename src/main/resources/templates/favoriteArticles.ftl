<!DOCTYPE html>
<html lang="en">
<head>
    <title>Wellness - лучший сервис для похудения! Избранное</title>
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
<body class="main-page">
<nav class="navbar main navbar-expand navbar-light fixed-top">
    <a class="navbar-brand" href="" >
        <img src="${springMacroRequestContext.contextPath}/server.img/logo.png" width="60" height="50" class="d-inline-block mb-3 m-0" alt="Wellness" >
        <span class="brand " > Wellness </span>
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active px-2 pl-6">
                <a class="nav-link" href="#">Главная<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item non-active px-2">
                <a class="nav-link"  href="#">Питание</a>
            </li>
            <li class="nav-item non-active px-2">
                <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Лента</a>
            </li>
        </ul>

    </div>
</nav>
<div class="container ">
    <div class="row">
        <div class="col-3 button-list">
            <div class="nav flex-column nav-pills " id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a data-toggle="pill"  href="" role="tab" aria-controls="v-pills-home" aria-selected="true"></a>
                <a data-toggle="pill"  href="" role="tab" aria-controls="v-pills-home" aria-selected="true"></a>
                <a data-toggle="pill"  href="" role="tab" aria-controls="v-pills-home" aria-selected="true"></a>
                <a data-toggle="pill"  href="${springMacroRequestContext.contextPath}/articles" role="tab" aria-controls="v-pills-home" id="favorite-link" aria-selected="true"><i class="fa fa-newspaper-o"></i> Все статьи</a>
                <a  data-toggle="pill" href="${springMacroRequestContext.contextPath}/articles/add" id="add-article-link" role="tab"  aria-selected="true"><i class="fa fa-plus" aria-controls="v-pills-home"></i> Добавить статью</a>
                <a data-toggle="pill" href="${springMacroRequestContext.contextPath}/profile" id="my-profile-link" role="tab"  aria-selected="true" aria-controls="v-pills-home"><i class="fa fa-smile-o"></i> Мой профиль</a>
            </div>
        </div>
    </div>
</div>
<div class="container articles">
  <#list articles as article>
      <#if article_index%3!=0>
          <#continue>
      </#if>
  <div class="row justify-content-end mb-3">
    <div class="carousel slide col-5 article" data-ride="carousel">
        <div class="carousel-inner">
            <a class="article-link" href="${springMacroRequestContext.contextPath}/articles/${article.id}">
                <div class="carousel-item active d-block w-100">

                    <img src="${springMacroRequestContext.contextPath}${article.mainImg.fileName}" class="d-block w-100" >

                    <div class="carousel-caption d-none d-md-block">
                        <h3>${article.title}</h3>
                    </div>
                </div>
            </a>
        </div>
    </div>
      <#if !article_has_next>
          </div>
          <#break>
      </#if>
      <div class="carousel slide col-5 article" data-ride="carousel">
          <div class="carousel-inner">
              <a class="article-link" href="${springMacroRequestContext.contextPath}/articles/${articles[article_index + 1].id}">
                  <div class="carousel-item active">
                      <img src="${springMacroRequestContext.contextPath}${articles[article_index + 1].mainImg.fileName}" class="d-block w-100">
                      <div class="carousel-caption d-none d-md-block">
                          <h3>${articles[article_index + 1].title}</h3>
                      </div>
                  </div>
              </a>
          </div>
      </div>
  </div>
  <#if !articles[article_index + 2]??>
      </div>
      <#break>
  </#if>
      <div class="row justify-content-end mb-3">
          <div class="carousel slide col-10 article" data-ride="carousel">
              <div class="carousel-inner">
                  <a class="article-link" href="${springMacroRequestContext.contextPath}/articles/${articles[article_index + 2].id}">
                      <div class="carousel-item active">
                          <img src="${springMacroRequestContext.contextPath}${articles[article_index + 2].mainImg.fileName}" class="d-block w-100">
                          <div class="carousel-caption d-none d-md-block">
                              <h3>${articles[article_index + 2].title}</h3>
                          </div>
                      </div>
                  </a>
              </div>
          </div>
      </div>
  </#list>
</div>
</body>
</html>
