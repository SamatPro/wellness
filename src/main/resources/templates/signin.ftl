<!DOCTYPE html>
<html lang="en">
<head>
	<title>Wellness - лучший сервис для похудения! Вход</title>
	<meta name="keywords" content="Похудение, wellness, здоровье, питание, еда, сервис"> 
	<meta name="description" content="Wellness - лучший сервис для похудения! С его помощью вы быстро и легко достигните своей цели!">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<link href="https://fonts.googleapis.com/css?family=Damion|Dancing+Script" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz|Oswald|Gabriela" rel="stylesheet">

    <link href="${springMacroRequestContext.contextPath}/server.img/logo.png" rel="icon" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/styles.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="auth-page">
<nav class="navbar auth mt-4 col-8">
	 <a class="navbar-brand" href="${springMacroRequestContext.contextPath}/articles" >
    	<img src="${springMacroRequestContext.contextPath}/server.img/logo.png" width="80" height="70" class="d-inline-block align-top mt-5" alt="Wellness" >
    	<span class="brand ml-1"> Wellness </span>
 	 </a>
</nav>
<div class="container">
	<div class="row">
		<div class="card auth-card">
			  <div class="card-header">
			 	 Вход
				  <#if error??>
				  <br>
  					<span  class="error">${error}</span>
				  </#if>
			  </div>
			  <div class="card-body">
			    <form method="post">
					  <div class="form-group p-2 mx-4">
					    <label for="login">Введите свою почту:</label>
					    <input type="email" class="form-control" name="email" id="login" aria-describedby="emailHelp" placeholder="E-mail">
					    <small id="emailHelp" class="form-text text-muted">Почта, с которой вы зарегистрировались на сайте. </small>
					  </div>
					  <div class="form-group p-2 mx-4">
					    <label for="password">Введите пароль:</label>
					    <input type="password" name="password" class="form-control" id="password" placeholder="Пароль">
					  </div>
					  <div class="row justify-content-center">
					  <small class="form-text text-muted">Еще не зарегистрированы? Войдите <a href="${springMacroRequestContext.contextPath}/signup">сюда</a>. </small>
					   </div>
					  <div class="row justify-content-center">
					  <button type="submit" class="btn btn-success justify-content-center">Войти</button>
					  </div>
				</form>			 
			   </div>
		</div>
		<div class="auth-text col-7 p-2 ml-3">
			 <h2>Похудей с Wellness!</h2>
			 <p class="pt-6">
			 Наш сервис поможет Вам легко перейти на правильное питание, которое будет способствовать Вашей заветной цели - скинуть пару киллограммов! Просто поставьте себе цель, найдите немного мотивации - а дальше позаботится Wellness!
			</p>
		</div>

	</div>
</div>


</body>
</html>