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


        <h1>${getUser.firstName} ${getUser.lastName}</h1>
        <#if getUser.photoSrc??>
            <img src="${springMacroRequestContext.contextPath}/uploads/${getUser.photoSrc}">
        <#else >
            <img src="${springMacroRequestContext.contextPath}/uploads/default.png">
        </#if>

        <form method="post" enctype="multipart/form-data" modelAttribute="profileForm">
            <label for="upload"><input type="file" name="photo" id="upload" multiple accept="image/*,image/jpeg">Загрузить новую</label>

            <label for="name">Имя</label>
            <input type="text" name="firstName" id="name" placeholder="Введите имя" value="${getUser.firstName}" required>
            <label for="surname">Фамилия</label>
            <input type="text" name="lastName" id="surname" placeholder="Введите фамилию" value="${getUser.lastName}" required>
            <label>Пол
            <input type="radio" name="sex" value="true" <#if getUser.sex>checked</#if>>мужской
            </label>
            <label>
            <input type="radio" name="sex" value="false" <#if !getUser.sex>checked</#if>>женский
            </label>
            <label for="email">E-mail</label>
            <input type="email" id="email" placeholder="email" value="${getUser.email}" disabled>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="придумайте пароль" value="">
            <label for="repassword">Repassword</label>
            <input type="password" name="repeatPassword" id="repassword" placeholder="повторите пароль">
            <label for="subscription">
            <input type="checkbox" name="consentToReceiveEmails" value="true" id="subscription" <#if getUser.consentToReceiveEmails>checked</#if>>
                Подписка
            </label>

            <label for="growth">Рост</label>
            <input type="number" name="growth" id="growth" placeholder="Ваш рост" value="<#if getUser.growth??>${getUser.growth}</#if>" required>
            <label for="age">Возраст</label>
            <input type="number" name="age" id="age" placeholder="Возраст" value="<#if getUser.age??>${getUser.age}</#if>" required>

            <label for="weight">Текущий вес</label>
            <input type="number" name="weight" id="weight" placeholder="Текущий вес в кг" value="<#if getUser.weight??>${getUser.weight}</#if>" required>
            <label for="purposeWeight">Цель</label>
            <input type="number" name="purposeWeight" id="purposeWeight" placeholder="Цель" value="<#if getUser.purposeWeight??>${getUser.purposeWeight}</#if>" required>

            <button type="submit">Обновить данные</button>
        </form>
    </div>









<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script  src="${springMacroRequestContext.contextPath}/js/index.js"></script>
</body>
</html>