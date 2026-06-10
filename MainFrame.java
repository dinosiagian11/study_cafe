

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// =====================================================================
// 1. INTERFACE (Kontrak Fungsi Sistem)
// =====================================================================
interface Cetak {
    void cetakStruk();
}

// =====================================================================
// 2. SUPERCLASS / KELAS INDUK (Penerapan Enkapsulasi)
// =====================================================================
class TempatBelajar {
    private String namaCafe;
    private String nomorKursi;

    // Constructor Kelas Induk
    public TempatBelajar(String namaCafe, String nomorKursi) {
        this.namaCafe = namaCafe;
        this.nomorKursi = nomorKursi;
    }

    // Properti Enkapsulasi diakses lewat fungsi Getter
    public String getNamaCafe() {
        return namaCafe;
    }

    public String getNomorKursi() {
        return nomorKursi;
    }
}

// =====================================================================
// 3. SUBCLASS / KELAS ANAK (Penerapan Pewarisan & Polimorfisme)
// =====================================================================
class BookingCafe extends TempatBelajar implements Cetak {
    private String namaMahasiswa;
    private String slotWaktu;
    private String keperluan;
    private int totalBayar;

    // Constructor Subclass memanggil properti kelas induk via kata kunci 'super'
    public BookingCafe(String namaCafe, String nomorKursi, String namaMahasiswa, String slotWaktu, String keperluan, int totalBayar) {
        super(namaCafe, nomorKursi); 
        this.namaMahasiswa = namaMahasiswa;
        this.slotWaktu = slotWaktu;
        this.keperluan = keperluan;
        this.totalBayar = totalBayar;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getSlotWaktu() {
        return slotWaktu;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    // Penerapan Polimorfisme (Overriding Method dari Interface Cetak)
    @Override
    public void cetakStruk() {
        System.out.println("[SISTEM LOG] Cetak manifest sukses untuk pelanggan: " + namaMahasiswa);
    }
}

// =====================================================================
// 4. MAIN FRAME CLASS (Aplikasi GUI Utama & Driver Program)
// =====================================================================
class MainFrame extends JFrame {
    // Penyimpanan data dinamis internal menggunakan Java Collection Framework (ArrayList)
    private ArrayList<BookingCafe> listBooking = new ArrayList<>();
    
    // Komponen Tampilan GUI Swing
    private JTextField txtNama, txtKursi, txtBayar;
    private JComboBox<String> cbCafe, cbWaktu, cbKeperluan;
    private JTable tabelData;
    private DefaultTableModel tableModel;
    private JTextArea txtStruk;
    private JButton btnTambah, btnCetak, btnHapus, btnClear;

    public MainFrame() {
        // Konfigurasi Landasan Jendela Aplikasi
        setTitle("StudyCafe Administrator & Receptionist System");
        setSize(1000, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Membuka jendela otomatis pas di tengah layar
        setLayout(new BorderLayout(10, 10));

        // --- BAGIAN UTARA: Header Atas ---
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(15, 15, 15));
        JLabel lblJudul = new JLabel("STUDYCAFE RECEPTIONIST & TICKET SYSTEM");
        lblJudul.setFont(new Font("Inter", Font.BOLD, 18));
        lblJudul.setForeground(new Color(245, 158, 11)); // Aksen warna Amber/Emas serasi tema web
        panelHeader.add(lblJudul);
        add(panelHeader, BorderLayout.NORTH);

        // --- BAGIAN TENGAH: Konten Utama (Dibagi Kolom Kiri & Kanan) ---
        JPanel panelTengah = new JPanel(new GridLayout(1, 2, 10, 10));
        panelTengah.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // SISI KIRI: Form Pengisian Kasir Offline
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createTitledBorder("Form Reservasi Offline (Meja Kasir)"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; panelForm.add(new JLabel("Nama Mahasiswa:"), gbc);
        gbc.gridx = 1; txtNama = new JTextField(15); panelForm.add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panelForm.add(new JLabel("Pilih Spot / Cafe:"), gbc);
        gbc.gridx = 1; 
        cbCafe = new JComboBox<>(new String[]{"Login Cafe", "Brew & Study", "Kopi Koding", "Green Corner Cafe", "Neon Desk Space", "Rumah Belajar Co-op"});
        panelForm.add(cbCafe, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panelForm.add(new JLabel("Nomor Kursi (cth: A6):"), gbc);
        gbc.gridx = 1; txtKursi = new JTextField(5); panelForm.add(txtKursi, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panelForm.add(new JLabel("Slot Waktu:"), gbc);
        gbc.gridx = 1;
        cbWaktu = new JComboBox<>(new String[]{"09:00 - 12:00 WIB", "13:00 - 16:00 WIB", "17:00 - 20:00 WIB", "21:00 - 24:00 WIB"});
        panelForm.add(cbWaktu, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panelForm.add(new JLabel("Keperluan Vibe:"), gbc);
        gbc.gridx = 1;
        cbKeperluan = new JComboBox<>(new String[]{"Belajar", "Kerja", "Meeting"});
        panelForm.add(cbKeperluan, gbc);

        gbc.gridx = 0; gbc.gridy = 5; panelForm.add(new JLabel("Total Bayar (Rp):"), gbc);
        gbc.gridx = 1; txtBayar = new JTextField("25000"); panelForm.add(txtBayar, gbc);

        // Baris Tombol Aksi di Form
        JPanel panelTombolForm = new JPanel(new GridLayout(1, 2, 5, 5));
        btnTambah = new JButton("Tambah Antrean");
        btnTambah.setBackground(new Color(217, 119, 6));
        btnTambah.setForeground(Color.WHITE);
        btnClear = new JButton("Reset Form");
        panelTombolForm.add(btnTambah);
        panelTombolForm.add(btnClear);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panelForm.add(panelTombolForm, gbc);

        // SISI KANAN: Tabel Data Manifest
        JPanel panelKanan = new JPanel(new BorderLayout(5, 5));
        tableModel = new DefaultTableModel(new String[]{"Nama", "Cafe", "Kursi", "Waktu", "Keperluan", "Total Bayar"}, 0);
        tabelData = new JTable(tableModel);
        JScrollPane scrollTabel = new JScrollPane(tabelData);
        panelKanan.add(new JLabel("Daftar Antrean Sistem Resepsionis:"), BorderLayout.NORTH);
        panelKanan.add(scrollTabel, BorderLayout.CENTER);

        // Tombol Pengendali Baris Tabel
        JPanel panelTombolTabel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnCetak = new JButton("Cetak Struk Terpilih");
        btnCetak.setBackground(new Color(16, 185, 129));
        btnCetak.setForeground(Color.WHITE);
        btnHapus = new JButton("Hapus Data");
        btnHapus.setBackground(new Color(185, 28, 28));
        btnHapus.setForeground(Color.WHITE);
        panelTombolTabel.add(btnCetak);
        panelTombolTabel.add(btnHapus);
        panelKanan.add(panelTombolTabel, BorderLayout.SOUTH);

        panelTengah.add(panelForm);
        panelTengah.add(panelKanan);
        add(panelTengah, BorderLayout.CENTER);

        // --- BAGIAN TIMUR: Tampilan Preview Cetak Kertas ---
        JPanel panelStruk = new JPanel(new BorderLayout());
        panelStruk.setBorder(BorderFactory.createTitledBorder("Live Ticket Preview (Mini Thermal)"));
        panelStruk.setPreferredSize(new Dimension(280, 0));
        txtStruk = new JTextArea();
        txtStruk.setEditable(false);
        txtStruk.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtStruk.setBackground(new Color(245, 245, 245));
        panelStruk.add(new JScrollPane(txtStruk), BorderLayout.CENTER);
        add(panelStruk, BorderLayout.EAST);

        // =====================================================================
        // LOGIKA INTERAKSI TOMBOL (ACTION LISTENERS)
        // =====================================================================

        // 1. Tambah Data Baru ke Antrean
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText().trim();
                String cafe = cbCafe.getSelectedItem().toString();
                String kursi = txtKursi.getText().trim();
                String waktu = cbWaktu.getSelectedItem().toString();
                String keperluan = cbKeperluan.getSelectedItem().toString();
                String bayarStr = txtBayar.getText().trim();

                if (nama.isEmpty() || kursi.isEmpty() || bayarStr.isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Mohon lengkapi seluruh isi form input!", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int totalBayar = Integer.parseInt(bayarStr);
                    
                    // Instansiasi Objek Baru Pola OOP
                    BookingCafe dataBaru = new BookingCafe(cafe, kursi, nama, waktu, keperluan, totalBayar);
                    listBooking.add(dataBaru);

                    // Render ke baris visual komponen tabel
                    tableModel.addRow(new Object[]{nama, cafe, kursi, waktu, keperluan, "Rp " + totalBayar});
                    
                    txtNama.setText("");
                    txtKursi.setText("");
                    JOptionPane.showMessageDialog(MainFrame.this, "Data berhasil masuk antrean kasir!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Input Total Bayar harus angka murni!", "Kesalahan Format", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 2. Aksi Ambil Data Baris Tabel & Cetak Nota Mini Thermal
        btnCetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int barisTerpilih = tabelData.getSelectedRow();
                
                if (barisTerpilih == -1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Silakan klik salah satu baris antrean pada tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Mengambil referensi data objek berdasarkan baris tabel yang aktif dipilih
                BookingCafe b = listBooking.get(barisTerpilih);
                
                String formatNota = 
                    "=============================\n" +
                    "          STUDYCAFE          \n" +
                    "   Premium Workspace Member  \n" +
                    "=============================\n" +
                    " Nama Mhs  : " + b.getNamaMahasiswa() + "\n" +
                    " Lokasi Spot: " + b.getNamaCafe() + "\n" +
                    " No. Kursi : " + b.getNomorKursi() + "\n" +
                    " Durasi Jam: " + b.getSlotWaktu() + "\n" +
                    " Keperluan : " + b.getKeperluan() + "\n" +
                    "-----------------------------\n" +
                    " TOTAL     : Rp " + b.getTotalBayar() + "\n" +
                    " STATUS    : OFFLINE VERIFIED\n" +
                    "=============================\n" +
                    "  Terima Kasih Atas Kunjungan\n" +
                    "  Harap Jaga Ketenangan Belajar\n" +
                    "=============================\n";
                
                txtStruk.setText(formatNota);
                b.cetakStruk(); // memicu method overriding terminal log
            }
        });

        // 3. Menghapus Antrean Data Terpilih
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int barisTerpilih = tabelData.getSelectedRow();
                if (barisTerpilih == -1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Pilih baris data pada tabel yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                listBooking.remove(barisTerpilih);
                tableModel.removeRow(barisTerpilih);
                txtStruk.setText(""); // hapus riwayat preview struk lawas
            }
        });

        // 4. Bersihkan Seluruh Isian Form Inputan
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtKursi.setText("");
                txtBayar.setText("25000");
                cbCafe.setSelectedIndex(0);
                cbWaktu.setSelectedIndex(0);
                cbKeperluan.setSelectedIndex(0);
            }
        });
    }

    // MAIN METHOD: Driver Pembuka Aplikasi Java
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true); // Memunculkan aplikasi GUI ke layar monitor
            }
        });
    }
}