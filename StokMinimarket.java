package prokel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StokMinimarket extends javax.swing.JFrame {

    private String username;
    private String password;

    private List<Minimarket> dataStokMinimarket = new ArrayList();

    public StokMinimarket() {
        initComponents();
    }

    public StokMinimarket(String username, String password) {
        this.username = username;
        this.password = password;
        initComponents();
    }

    public void clearField() {
        isiNamaBarang.setText("");
        pilihanKategori.setSelectedIndex(0);
        isiJumlahStok.setText("");
        isiHargaSatuan.setText("");
        isiSupplier.setText("");
    }

    public Connection getConnection() {
        String host = "localhost";
        String port = "1521";
        String db = "xe";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver tidak ditemukan");
            JOptionPane.showMessageDialog(this, "message:" + ex.getMessage());
        }

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host
                    + ":" + port + ":" + db, username, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal");
        }
        return conn;
    }

    private boolean isValidKode(String kode) {
        String pattern = "^(?!000$)(?:[0-9]{3}|1000)$";
        return kode.matches(pattern);
    }

    private boolean isValidJumStok(String jumlahStok) {
        String pattern = "[0-9]{1,5}"; // Menerima angka 1 hingga 5 digit
        if (jumlahStok.matches(pattern)) {
            int stok = Integer.parseInt(jumlahStok);
            return stok > 0; // Memastikan stok lebih dari 0
        }
        return false; // Jika tidak sesuai pola, kembalikan false
    }

    private boolean isValidHarga(String harga) {
        String pattern = "^Rp[0-9]{1,3}(?:\\.[0-9]{1}[0]{2})*$";
        return harga.matches(pattern);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        kodeBarang = new javax.swing.JLabel();
        namaBarang = new javax.swing.JLabel();
        kategori = new javax.swing.JLabel();
        jumlahStok = new javax.swing.JLabel();
        hargaSatuan = new javax.swing.JLabel();
        isiKodeBarang = new javax.swing.JTextField();
        isiNamaBarang = new javax.swing.JTextField();
        isiJumlahStok = new javax.swing.JTextField();
        isiHargaSatuan = new javax.swing.JTextField();
        pilihanKategori = new javax.swing.JComboBox<>();
        Cancel = new javax.swing.JButton();
        Simpan = new javax.swing.JButton();
        Lihat = new javax.swing.JButton();
        isiSupplier = new javax.swing.JTextField();
        hargaSatuan1 = new javax.swing.JLabel();
        Rp = new javax.swing.JLabel();
        tigaDigitAngka = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelTitle.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel1.setText("STOK");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Stok"));

        kodeBarang.setText("Kode Barang");

        namaBarang.setText("Nama Barang");

        kategori.setText("Kategori");

        jumlahStok.setText("Jumlah Stok");

        hargaSatuan.setText("Harga Satuan");

        isiHargaSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiHargaSatuanActionPerformed(evt);
            }
        });

        pilihanKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Makanan", "Minuman" }));

        Cancel.setText("CANCEL");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Simpan.setText("SIMPAN");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Lihat.setText("LIHAT DATA");
        Lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatActionPerformed(evt);
            }
        });

        isiSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiSupplierActionPerformed(evt);
            }
        });

        hargaSatuan1.setText("Supplier");

        Rp.setText("RpX.X00");

        tigaDigitAngka.setText("3 digit angka");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 137, Short.MAX_VALUE)
                        .addComponent(Cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Lihat)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isiJumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pilihanKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isiNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isiKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hargaSatuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(isiSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(isiHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rp)
                            .addComponent(tigaDigitAngka))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeBarang)
                    .addComponent(isiKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tigaDigitAngka))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaBarang)
                    .addComponent(isiNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kategori)
                    .addComponent(pilihanKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahStok)
                    .addComponent(isiJumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaSatuan)
                    .addComponent(isiHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rp))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isiSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaSatuan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancel)
                    .addComponent(Simpan)
                    .addComponent(Lihat))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();

        boolean isValid = true;
        String kodBar = null;
        String pilKate = null;
        String jumStok = null;
        String harSatu = null;
        String namBar, supp;

        if (this.isValidKode(isiKodeBarang.getText())) {
            kodBar = isiKodeBarang.getText();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Kode barang tidak valid! Pastikan kode terdiri dari 3 digit angka yang dimulai dengan angka 001 hingga 1000.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        namBar = isiNamaBarang.getText();
        if (pilihanKategori.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Tolong pilih kategori",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else {
            pilKate = pilihanKategori.getSelectedItem().toString();
        }

        if (this.isValidJumStok(isiJumlahStok.getText())) {
            jumStok = isiJumlahStok.getText();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Jumlah stok tidak valid! Pastikan jumlah stok terdiri dari angka antara 1 hingga 100 digit.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        if (this.isValidHarga(isiHargaSatuan.getText())) {
            harSatu = isiHargaSatuan.getText();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Harga tidak valid! Pastikan harga dimulai dengan 'Rp' dan diikuti dengan angka 1.000!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        supp = isiSupplier.getText();

        try {
            ps = conn.prepareStatement("insert into minimarket values(?,?,?,?,?,?)");
            ps.setString(1, kodBar);
            ps.setString(2, namBar);
            ps.setString(3, pilKate);
            ps.setString(4, jumStok);
            ps.setString(5, harSatu);
            ps.setString(6, supp);
            ps.executeUpdate();
            conn.commit();

            if (isValid) {
                dataStokMinimarket.add(new Minimarket(kodBar, namBar, pilKate, jumStok, harSatu, supp));

                JOptionPane.showMessageDialog(this, "Data berhasil Tersimpan");
                clearField();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal Tersimpan");
            }
            
            int kode = Integer.parseInt(isiKodeBarang.getText());
            kode++;

            kodBar = String.format("%03d", kode);
            isiKodeBarang.setText(kodBar);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void LihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatActionPerformed
        TampilanStokData lihatData = new TampilanStokData(username, password); // Kirim data
        lihatData.setVisible(true);

    }//GEN-LAST:event_LihatActionPerformed

    private void isiHargaSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiHargaSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiHargaSatuanActionPerformed

    private void isiSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiSupplierActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        clearField();
    }//GEN-LAST:event_CancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StokMinimarket().setVisible(true);
                BasisData bd = new BasisData();
                bd.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Lihat;
    private javax.swing.JLabel Rp;
    private javax.swing.JButton Simpan;
    private javax.swing.JLabel hargaSatuan;
    private javax.swing.JLabel hargaSatuan1;
    private javax.swing.JTextField isiHargaSatuan;
    private javax.swing.JTextField isiJumlahStok;
    private javax.swing.JTextField isiKodeBarang;
    private javax.swing.JTextField isiNamaBarang;
    private javax.swing.JTextField isiSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jumlahStok;
    private javax.swing.JLabel kategori;
    private javax.swing.JLabel kodeBarang;
    private javax.swing.JLabel namaBarang;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JComboBox<String> pilihanKategori;
    private javax.swing.JLabel tigaDigitAngka;
    // End of variables declaration//GEN-END:variables
}
