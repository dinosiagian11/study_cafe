<?php
// Koneksi langsung ke database milik abang (studycafe)
$conn = mysqli_connect("localhost", "root", "", "studycafe");

if (!$conn) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nama     = $_POST['nama'];
    $email    = $_POST['email'];
    $password = $_POST['password'];

    // Memasukkan data ke tabel users abang
    $query = "INSERT INTO users (name, email, password, role) VALUES ('$nama', '$email', '$password', 'user')";
    
    if (mysqli_query($conn, $query)) {
        echo "<script>
                alert('Pendaftaran Sukses! Data Akun Anda sudah tersimpan di database.');
                window.location.href = 'login.php'; // Otomatis balik ke halaman login setelah sukses
              </script>";
    } else {
        echo "Gagal mendaftar: " . mysqli_error($conn);
    }
}
?>