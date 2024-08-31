<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laboratory Work 1</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 20px 0;
            text-align: center;
        }
        h1 {
            font-size: 36px;
        }
        h2 {
            font-size: 24px;
        }
        .content {
            text-align: center;
            margin-top: 20px;
        }
        .buttons-holder {
            margin-top: 20px;
        }
        button {
            padding: 10px 20px;
            font-size: 18px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            margin-right: 10px;
        }
        button:last-child {
            margin-right: 0;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<header>
    <h1>Network App</h1>
    <h2>Polina Aliunina, Alexandra Myalik</h2>
</header>

<div class="content">
    <div class="buttons-holder">
        <button onclick="location.href='/SignUpController'">Register</button>
        <button onclick="location.href='/SignInController'">Login</button>
    </div>
</div>
</body>
</html>
