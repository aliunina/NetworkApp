<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="SignUpController" method="post">
        <label>Name:
            <input type="text" name="name" required/><br />
        </label>
        <label>Surname:
            <input type="text" name="surname" required/><br />
        </label>
        <label>Patronymic:
            <input type="text" name="patronymic" required/><br />
        </label>
        <label>Email:
            <input type="email" name="email" required/><br />
        </label>
        <label>PhoneNumber:
            <input type="text" name="phoneNumber" required/><br />
        </label>
        <label>Login:
            <input type="text" name="login" required/><br />
        </label>
        <label>Password:
            <input type="password" name="password" required/><br /><br />
        </label>
        <button type="submit">Register</button>
    </form>
</body>
</html>
