<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Study Cafe</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #121212;
            color: #ffffff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #1e1e1e;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.5);
            width: 350px;
            text-align: center;
            border: 1px solid #f59e0b;
        }
        h2 { 
            color: #f59e0b; 
            margin-bottom: 20px; 
            font-size: 24px;
            letter-spacing: 1px;
        }
        input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #333;
            background-color: #2a2a2a;
            color: #fff;
            box-sizing: border-box;
            font-size: 14px;
        }
        input:focus {
            border-color: #f59e0b;
            outline: none;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #f59e0b;
            border: none;
            color: #121212;
            font-weight: bold;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
            transition: 0.3s;
        }
        button:hover { 
            background-color: #d97706; 
        }
        .register-link {
            margin-top: 20px;
            font-size: 14px;
            color: #aaa;
        }
        .register-link a {
            color: #f59e0b;
            text-decoration: none;
            font-weight: bold;
            transition: 0.2s;
        }
        .register-link a:hover {
            text-decoration: underline;
            color: #d97706;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>STUDY CAFE LOGIN</h2>
    
    <form action="proses_login.php" method="POST">
        <input type="email" name="email_user" placeholder="Masukkan Email (nama@email.com)" required>
        <input type="password" name="password_user" placeholder="Masukkan Password" required>
        <button type="submit">Masuk</button>
    </form>

    <div class="register-link">
        Belum punya akun? <a href="register_kilat.php">Daftar di Sini</a>
    </div>
</div>

</body>
</html>