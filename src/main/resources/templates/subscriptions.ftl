<!DOCTYPE html>
<html lang="en">
<head>
    <title>Друзья</title>

</head>
<body>

<li>
    <#list user.friends as friend>
        <ul>${friend.firstName} ${friend.lastName} <a href="/wellness/myFriends/${friend.id}">Посмотреть</a><a href="/wellness/myFriends/${friend.id}">Подписаться</a></ul>
    </#list>

</li>


</body>
</html>