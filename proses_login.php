<?php
// 1. Membuat koneksi langsung ke database study_cafe_db
$conn = mysqli_connect("localhost", "root", "", "studycafe");

// Cek jika koneksi gagal
if (!$conn) {
    die("Koneksi database gagal: " . mysqli_connect_error());
}

// 2. Menangkap data kiriman dari form login.php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email    = $_POST['email_user'];
    $password = $_POST['password_user'];

    // 3. Query memeriksa ke tabel 'users' apakah email & password ada dan cocok
    $query  = "SELECT * FROM users WHERE email='$email' AND password='$password'";
    $result = mysqli_query($conn, $query);

    // 4. Jika data ditemukan (lebih dari 0 baris)
    if (mysqli_num_rows($result) > 0) {
        $user_data = mysqli_fetch_assoc($result);
        
        // Memunculkan notifikasi sukses ala javascript popup
        echo "<script>
                alert('Login Sukses! Selamat datang, " . $user_data['name'] . " (" . $user_data['role'] . ")');
                window.location.href = 'html.html'; // Mengarahkan user kembali ke halaman utama abang
              </script>";
    } else {
        // Jika data salah atau tidak ditemukan
        echo "<script>
                alert('Login Gagal! Email atau Password salah.');
                window.location.href = 'login.php'; // Balikkan ke halaman login lagi
              </script>";
    }
}
?>