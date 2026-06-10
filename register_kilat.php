<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daftar Akun - Study Cafe</title>
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
        .register-container {
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
        .login-link {
            margin-top: 20px;
            font-size: 14px;
            color: #aaa;
        }
        .login-link a {
            color: #f59e0b;
            text-decoration: none;
            font-weight: bold;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="register-container">
    <h2>DAFTAR AKUN BARU</h2>
    
    <form action="proses_daftar.php" method="POST">
        <input type="text" name="nama" placeholder="Nama Lengkap Anda" required>
        <input type="email" name="email" placeholder="Masukkan Email Baru" required>
        <input type="password" name="password" placeholder="Buat Password Baru" required>
        <button type="submit">Daftar Sekarang</button>
    </form>

    <div class="login-link">
        Sudah punya akun? <a href="login.php">Log In</a>
    </div>
</div>

</body>
</html>