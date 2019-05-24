<!DOCTYPE html>
<html lang="en">
<head>
    <title>Диалоги</title>

</head>
<body>

    <#list dialogs as dialog>
        <h1>${dialog.id}</h1>
        <h2> ${dialog.creationTime.dayOfMonth}-${dialog.creationTime.month}-${dialog.creationTime.year} ${dialog.creationTime.hour}:${dialog.creationTime.minute}</h2>
        <a href="${springMacroRequestContext.contextPath}/dialogs/${dialog.id}">${dialog.name}</a>
    </#list>


</body>
</html>