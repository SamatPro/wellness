<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${springMacroRequestContext.contextPath}/img/logo.png" rel="icon">
    <title>Главная</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="https://fonts.googleapis.com/css?family=Philosopher:300,400,700,900|Raleway:400,300,700,900" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js" integrity="VjEeINv9OSwtWFLAtmc4JCtEJXXBub00gtSnszmspDLCtC0I4z4nqz7rEFbIZLLU" crossorigin="anonymous"></script>

    <link href="${springMacroRequestContext.contextPath}/css/style.css" rel="stylesheet">


</head>
<body>


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container" id="header-bar">
        <div class="nav navbar-nav navbar-left" style="width: 29%" href="#">
            <img src="img/logo.png" width="50" height="50" class="" alt="">
            Wellness
        </div>

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Главная</a></li>
                <li class="active"><a href="#">Питание</a></li>
                <li><a href="#">Лента</a></li>
                <!--<div class="nav navbar-right">-->
                <!--<a data-toggle="modal" data-target="#myModal" href="#myModal"><img src="../../resources/img/profileLogo.png" width="40">Мой профиль</a>-->
                <!--</div>-->


                <li class="menu__item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="img/profileLogo.png" width="40">Мой профиль
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <li><a class="dropdown-item" href="#">Мой профиль</a></li>
                        <li><a class="dropdown-item" href="#">Мой прогресс</a></li>
                        <li><a class="dropdown-item" href="#">Мои сообщения</a></li>
                        <li><div class="dropdown-divider"></div></li>
                        <li><a class="dropdown-item" href="#">Настройки</a></li>
                        <li><a class="dropdown-item" href="#">Выход</a></li>

                    </ul>
                </li>

            </ul>
        </div>
    </div>

</nav>

<div class="panel col-lg-2">
    <div class="row left">
        <div class="col-lg-offset-2">
            <button type="button" class="btn btn-secondary btn-lg btn-block btn-success">Изменить данные</button>
            <button type="button" class="btn btn-secondary btn-lg btn-block btn-success">Посмотреть прогресс</button>
        </div>
    </div>
</div>

<div class="container">

    <div class="ration-container">
        <h1>Утром</h1>
        <ul>
            <li>
                <span class="descr">
                    <h2>Хурма</h2>
                    <p>Спелая хурма сладкая и вкусная. Калорийность хурмы составляет 67 ккал. на 100 гр. А по полезным свойствам хурма опережает многих из своих ...</p>
                    <button class="btn btn-group-lg btn-success" onclick="ate(${id})"><i class="fa fa-cutlery"></i>Съел</button>
                </span>
                <img src="https://bezpuza.ru/wp-content/uploads/2016/03/hurma.jpg" height="440">
            </li>
            <li>
                <span class="descr">
                    <h2>Гусиные лапки</h2>
                    <p>Описание блюда</p>
                </span>
                <img src="https://ic.pics.livejournal.com/imajarov/21120016/194833/194833_800.jpg" height="440">
            </li>
            <li>
                <span class="descr">
                    <h2>Мухомор</h2>
                    <p>Гриб мухомор имеет крупное плодовое тело (у большинства представителей), стоящее на ножке. ... Красный мухомор (описание). Относится к ядовитым грибам, вызывающим сильные отравления, иногда со смертельным исходом.</p>
                </span>
                <img src="https://potenciya.guru/wp-content/uploads/2018/11/raka-narodnymi-sredstvami3.jpg" height="440">
            </li>
        </ul>
    </div>


    <div class="ration-container">
        <h1>Днём</h1>
        <ul>
            <li>
                <span class="descr"> Пищевая ценность и состав - яблока. НЖК - Насыщенные жирные кислоты. 0.1 г. Зола. 0.5 г. Крахмал. 0.8 г. Моно- и дисахариды.</span><img src="../../resources/img/logo.jpg">
            </li>
            <li>
                <span class="descr">Пищевая ценность и состав - яблока. НЖК - Насыщенные жирные кислоты. 0.1 г. Зола. 0.5 г. Крахмал. 0.8 г. Моно- и дисахариды.</span><img src="../../resources/img/logo.jpg">
            </li>
            <li>
                <span class="descr">Пищевая ценность и состав - яблока. НЖК - Насыщенные жирные кислоты. 0.1 г. Зола. 0.5 г. Крахмал. 0.8 г. Моно- и дисахариды.</span><img src="../../resources/img/logo.jpg">
            </li>
        </ul>
    </div>


    <div class="ration-container">
        <h1>Вечером</h1>
        <ul>
            <li>
                <span class="descr"> Пищевая ценность и состав - яблока. НЖК - Насыщенные жирные кислоты. 0.1 г. Зола. 0.5 г. Крахмал. 0.8 г. Моно- и дисахариды.</span><img src="../../resources/img/logo.jpg">
            </li>
            <li>
                <span class="descr">Пищевая ценность и состав - яблока. НЖК - Насыщенные жирные кислоты. 0.1 г. Зола. 0.5 г. Крахмал. 0.8 г. Моно- и дисахариды.</span><img src="../../resources/img/logo.png">
            </li>
            <li>
                <span class="descr">Пищевая ценность и состав - яблока. НЖК - Насыщенные жирные кислоты. 0.1 г. Зола. 0.5 г. Крахмал. 0.8 г. Моно- и дисахариды.</span><img src="../../resources/img/bg-1.png">
            </li>
        </ul>
    </div>

</div>



<div class="footer" style="padding-top: 6%">
    <footer class="footer" style="background-color:darkslategrey;">
        <div class="container" style="color: white">
                <span class="text" style="color: white;">
                    &copy; Made by Samat, Ernest, Rustem, Alina<br>
                        All rights reserved</span>
        </div>
    </footer>
</div>









<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script  src="../../resources/js/index.js"></script>
</body>
</html>