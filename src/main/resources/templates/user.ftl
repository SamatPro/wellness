<!DOCTYPE html>
<html lang="en">
<head>
    <title>Друзья</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="${springMacroRequestContext.contextPath}/js/message.js"></script>

</head>
<body>

<#if friend??>
    <h1>
        ${friend.lastName} ${friend.firstName}
    </h1>
    <p>${friend.age}</p>
    <#if friend.photoSrc??>
        <img src="/wellness/${friend.photoSrc}">
    </#if>
</#if>
    <button id="write">Написать</button>

<#if friend.comments??>
    <h1>Комменты</h1>
    <#list friend.comments as comment>
        <h1>
        ${comment.id} ${comment.article.title}
        </h1>
        <p>${comment.article.text}</p>
        <p>${comment.text}</p>
    </#list>
</#if>

<#if friend.favoriteArticles??>
    <h1>Избранные</h1>
    <#list friend.favoriteArticles as article>
        <h1>
            <a href="/wellness/articles/${article.id}">
                ${article.id} ${article.title}
            </a>
        </h1>
        <p>${article.text}</p>
    </#list>
</#if>





</body>
</html>