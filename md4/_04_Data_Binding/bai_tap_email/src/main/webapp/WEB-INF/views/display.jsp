<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>Language: ${email.languages}</div>
<div>Page size: ${email.page}</div>
<div>Spam Filter: ${email.filter}</div>
<div>Signature: ${email.signature}</div>
<a href="/edit">
    <button>Edit</button>
</a>
</body>
</html>
