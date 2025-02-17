package prokel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class TampilanStokData extends javax.swing.JFrame {

    private List<Minimarket> dataStokMinimarket = new ArrayList();
    private String username;
    private String password;

    // Constructor tanpa parameter
    public TampilanStokData() {
        initializeData();
        initComponents();
        tombolDelete.setEnabled(false);

        // Menampilkan data di jTable
        MinimarketTableModel tableModel = new MinimarketTableModel(dataStokMinimarket);
        table.setModel(tableModel);
    }
    public TampilanStokData(String username, String password) {
        this.username = username;
        this.password = password;
        initializeData();
        initComponents();
        tombolDelete.setEnabled(false);

        // Menampilkan data di jTable
        MinimarketTableModel tableModel = new MinimarketTableModel(dataStokMinimarket);
        table.setModel(tableModel);
        

    }

    public void refreshTable() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Dapatkan koneksi ke database
            conn = this.getConnection();

            // Query untuk mengambil semua data dari tabel MINIMARKET
            String sql = "SELECT * FROM MINIMARKET ORDER BY KODEBARANG";
            ps = conn.prepareStatement(sql);

            // Eksekusi query
            rs = ps.executeQuery();

            // Kosongkan daftar lokal
            dataStokMinimarket.clear();

            // Tambahkan data dari hasil query ke dataStokMinimarket
            while (rs.next()) {
                String kodeBarang = rs.getString("KODEBARANG");
                String namaBarang = rs.getString("NAMABARANG");
                String kategori = rs.getString("KATEGORI");
                String stokTersedia = rs.getString("STOKTERSEDIA");
                String harga = rs.getString("HARGA");
                String supplier = rs.getString("SUPPLIER");

                // Tambahkan objek Minimarket ke daftar
                dataStokMinimarket.add(new Minimarket(kodeBarang, namaBarang, kategori, stokTersedia, harga, supplier));
            }

            // Perbarui tabel dengan model baru
            MinimarketTableModel tableModel = new MinimarketTableModel(dataStokMinimarket);
            table.setModel(tableModel);
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saat memuat data: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        String host = "localhost";
        String port = "1521";
        String db = "xe";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
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

    private void initializeData() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        conn = this.getConnection();
        try {
            st = conn.createStatement();
            String query = "Select * from minimarket";
            rs = st.executeQuery(query);

            while (rs.next()) {
                dataStokMinimarket.add(new Minimarket(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        isiTabelData = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        tombolDelete = new javax.swing.JButton();
        tombolUpdate = new javax.swing.JButton();
        pilihanFilterKategori = new javax.swing.JComboBox<>();
        Refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA STOK "));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "KODEBARANG", "NAMABARANG", "KATEGORI", "STOKTERSEDIA", "HARGA ", "SUPPLIER"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        isiTabelData.setViewportView(table);

        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        tombolDelete.setText("DELETE");
        tombolDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolDeleteActionPerformed(evt);
            }
        });

        tombolUpdate.setText("UPDATE");
        tombolUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUpdateActionPerformed(evt);
            }
        });

        pilihanFilterKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-FILTER KATEGORI- ", "Makanan", "Minuman" }));
        pilihanFilterKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanFilterKategoriActionPerformed(evt);
            }
        });

        Refresh.setText("REFRESH");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiTabelData, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Refresh)
                        .addGap(15, 15, 15)
                        .addComponent(pilihanFilterKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolDelete)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(isiTabelData, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolDelete)
                    .addComponent(tombolUpdate)
                    .addComponent(pilihanFilterKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back)
                    .addComponent(Refresh))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_RefreshActionPerformed

    private void pilihanFilterKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihanFilterKategoriActionPerformed
        // Mendapatkan model tabel dari JTable
        MinimarketTableModel tableModel = (MinimarketTableModel) table.getModel();

        // Membuat TableRowSorter untuk melakukan filter
        TableRowSorter<MinimarketTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter); // Mengaitkan sorter ke tabel

        // Mendapatkan kategori yang dipilih
        String pilihKategori = (String) pilihanFilterKategori.getSelectedItem();

        // Logika filtering berdasarkan pilihan kategori
        if ("-FILTER KATEGORI-".equals(pilihKategori.trim())) {
            sorter.setRowFilter(null); // Menampilkan semua data jika tidak ada filter
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(pilihKategori, 2)); // Filter kolom kategori (index ke-2)
        }
    }//GEN-LAST:event_pilihanFilterKategoriActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        tombolDelete.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked
    
    // cara metode penghapusan terjadi secara langsung di database 
    // dan juga diikuti dengan pembaruan data pada aplikasi agar 
    // tampilan tetap konsisten dengan data di database.
    private void tombolDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolDeleteActionPerformed
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Pastikan ada baris yang dipilih di tabel
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
                return;
            }

            int confirmation = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            // Jika pengguna memilih 'No', batalkan penghapusan
            if (confirmation == JOptionPane.NO_OPTION) {
                return;
            }

            // Ambil nilai kode barang dari tabel
            String kodeBarang = table.getValueAt(selectedRow, 0).toString(); // Asumsi kolom 0 adalah KODEBARANG

            // Koneksi ke database
            conn = this.getConnection();

            // SQL DELETE query
            String sql = "DELETE FROM MINIMARKET WHERE KODEBARANG = ?";
            ps = conn.prepareStatement(sql);

            // Set parameter kode barang
            ps.setString(1, kodeBarang);

            // Eksekusi query
            int exeUpd = ps.executeUpdate();

            // Commit perubahan ke database
            conn.commit();

            if (exeUpd > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

                // Hapus baris dari daftar tabel
                dataStokMinimarket.remove(selectedRow);

                // Perbarui tampilan tabel
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Message: " + ex.getMessage());
        } finally {
            // Tutup koneksi dan prepared statement
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Message: " + ex.getMessage());
            }
        }
        tombolDelete.setEnabled(false);
    }//GEN-LAST:event_tombolDeleteActionPerformed
    
    // Membuka program UpdateDataStok
    private void tombolUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUpdateActionPerformed
        UpdateDataStok update = new UpdateDataStok(username, password);
        update.setVisible(true);
    }//GEN-LAST:event_tombolUpdateActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanStokData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Refresh;
    private javax.swing.JScrollPane isiTabelData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> pilihanFilterKategori;
    private javax.swing.JTable table;
    private javax.swing.JButton tombolDelete;
    private javax.swing.JButton tombolUpdate;
    // End of variables declaration//GEN-END:variables
}
