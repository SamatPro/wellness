<!DOCTYPE html>
<html lang="en">
<head>
	<title>Wellness - лучший сервис для похудения! Регистрация</title>
	<meta name="keywords" content="Похудение, wellness, здоровье, питание, еда, сервис"> 
	<meta name="description" content="Wellness - лучший сервис для похудения! С его помощью вы быстро и легко достигните своей цели!">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<link href="https://fonts.googleapis.com/css?family=Damion|Dancing+Script" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz|Oswald|Gabriela" rel="stylesheet">

    <link href="${springMacroRequestContext.contextPath}/server.img/logo.png" rel="icon" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/styles.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="reg-page">
<div class="container">
	<div class="row auth justify-content-center">
		<a class="navbar-brand" href="${springMacroRequestContext.contextPath}/articles" >
    	<img src="${springMacroRequestContext.contextPath}/server.img/logo.png" width="80" height="70" class="d-inline-block align-top mt-5" alt="Wellness" >
    	<span class="brand "> Wellness </span>
 	 </a>
	</div>
	<div class="row justify-content-center mb-3">
		<div class="card auth-card ">
			  <div class="card-header">
			 	 Регистрация
                   <#if error??>
                   <br>
  					<span class="error">${error}</span>
                   </#if>
			  </div>
			  <div class="card-body">
			    <form method="post">
					  <div class="form-group p-2 mx-2">
					    <label for="login">Введите почту:</label>
					    <input type="email" name="email" class="form-control" id="login" aria-describedby="emailHelp" placeholder="E-mail">
					  </div>
					  <div class="row justify-content-between p-2 mx-2">
					    <div class="col">
					    <label for="first-name">Введите имя:</label>
					      <input type="text" id="first-name" class="form-control" name="firstName" placeholder="Имя">
					    </div>
					    <div class="col">
					    <label for="last-name">Введите фамилию:</label>
					      <input type="text" id="last-name" name="lastName" class="form-control" placeholder="Фамилия">
					    </div>
					  </div>

						<div class="row justify-content-between p-2 mx-2">
                            <label class="p-2">Выберите пол:</label>
                            <div class="form-check pt-2">
                                <input class="form-check-input" type="radio" name="sex" id="male" value="male" required="true">
                                <label class="form-check-label" for="male">
                                    Мужской
                                </label>
                            </div>
                            <div class="form-check pt-2">
                                <input class="form-check-input" type="radio" name="sex" id="female" value="female" required="true">
                                <label class="form-check-label" for="female">
                                    Женский
                                </label>
                            </div>
						</div>
					  <div class="row justify-content-between p-2 mx-2">
						  <div class="col">
                              <div class="form-group ">
                                  <label for="password">Введите пароль:</label>
                                  <input type="password" name="password" class="form-control" id="password" placeholder="Пароль">
                              </div>
						  </div>
						  <div class="col">
                              <div class="form-group ">
                                  <label for="r-password">Повторите пароль:</label>
                                  <input type="password" name="repeatPassword" class="form-control" id="r-password" placeholder="Пароль">
                              </div>
						  </div>
					  </div>

					  <div class="row justify-content-center form-group p-2 mx-2">
					    <div class="form-check">
					      <input class="form-check-input" type="checkbox" name="consentToTheProcessingOfPersonalData" id="gridCheck" required="true">
					      <label class="form-check-label" for="gridCheck">
					        Согласие на обработку персональных данных
					      </label>
					    </div>
					  </div>
					  <div class="row justify-content-center form-group p-2 mx-2">
					    <div class="form-check">
					      <input class="form-check-input" type="checkbox" name="consentToReceiveEmails" id="emailCheck">
					      <label class="form-check-label" for="emailCheck">
					        Присылать уведомления на почту
					      </label>
					    </div>
					  </div>
					  <div class="row justify-content-center">
					  <small class="form-text text-muted">Уже зарегистрированы? Вы можете <a href="${springMacroRequestContext.contextPath}/signin">войти</a>. </small>
					  </div>
					  <div class="row justify-content-center">
  						  <button type="submit" class="btn btn-success ">Зарегистрироваться</button>
					  </div>
				</form>			 
			   </div>
		</div>
	</div>
</div>


</body>
</html>