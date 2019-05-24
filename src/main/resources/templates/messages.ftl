<!DOCTYPE html>
<html>
<head>
    <title>Диалог</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/wellness/js/chat.js"></script>
</head>
<body onload="connect();" onunload="disconnect();">
<h1> Chat Room </h1>
<textarea id="messages" disabled="true"></textarea>
<div class="panel input-area">
    <input id="userName" type="text" placeholder="Name"/>
    <input id="messageInput" type="text" placeholder="Message"
           onkeydown="if (event.keyCode == 13) sendMessage();" />
    <input class="button" type="submit" value="Send" onclick="sendMessage();" />
</div>
</body>
</html






<html lang="en">
<head>
    <title>Диалоги</title>

</head>
<body>

<#list messages as message>
    <h2> ${message.user.firstName}:</h2>
    <h1>${message.text}</h1>
    <#if message.creationTime??>
        <h2> ${message.creationTime.dayOfMonth}-${message.creationTime.month}-${message.creationTime.year} ${message.creationTime.hour}:${message.creationTime.minute}</h2>
    </#if>
</#list>
<form method = "post">
    <br />

    <textarea rows = "5" cols = "50" name = "message">

         </textarea>

    <input type = "submit" value = "submit" />
</form>

</body>
</html>