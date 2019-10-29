/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import sun.util.calendar.BaseCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author umam
 */
public class Penjualan extends javax.swing.JFrame {
    
    private Connection con;
    private Statement st;
    private ResultSet RSpenjualan;
    private String sql="";
    JasperReport Jasrep;
    JasperPrint Jaspri;
    Map param= new HashMap();
    JasperDesign JasDes;
    private String tran, kb, nb, tgl;
    private int s, j, h, t, b, k;

    /**
     * Creates new form MenuUtama
     */
    public Penjualan() {
        initComponents();
        KoneksiDB();
        ShowData(sql);
        update();
        aktif(false);
        setTombol(true);
    }
    
    private void KoneksiDB (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_draffa", "root", "");
            System.out.println("Koneksi Berhasil");
            //JOptionPane.showMessageDialog(null,"Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi gagal \n"+e);
        }
    }
    
    private void ShowData(String sql){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("Nomor");
        data.addColumn ("Nomor Transaksi");
        data.addColumn ("Tanggal Transaksi");
        data.addColumn ("Kode Barang");
        data.addColumn ("Nama Barang");
        data.addColumn ("Stock");
        data.addColumn ("Jumlah");
        data.addColumn ("Harga");
        data.addColumn ("Total");
        data.addColumn ("Bayar");
        data.addColumn ("Kembalian");
        try{    
            int i = 1;
            st=con.createStatement();
             RSpenjualan=st.executeQuery("select * FROM penjualan");
            while ( RSpenjualan.next())
                data.addRow(new Object[]{
                (""+i++),
                    RSpenjualan.getString(1),  RSpenjualan.getString(2),
                    RSpenjualan.getString(3),  RSpenjualan.getString(4),
                    RSpenjualan.getString(5),  RSpenjualan.getString(6),
                    RSpenjualan.getString(7),  RSpenjualan.getString(8),
                    RSpenjualan.getString(9),  RSpenjualan.getString(10),     
                });
            tabelpenjualan.setModel(data);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
    }
    private void Clear(){
        no_tran.setText("");
        tgl_tran.setDate(null);
        kd_brg.setText("");
        nm_brg.setText("");
        stock.setText("");
        jlh.setText("");
        har.setText("");
        tot.setText("");
        byr.setText("");
        kem.setText("");
        
    }
    
    private void update(){
   
        try{
            
            String tt=jlh.getText();
            String ss=stock.getText();
            int stk=Integer.parseInt(ss);
            int jmlh=Integer.parseInt(tt);
            
            int hasil = stk - jmlh;
            sql="update data_barang set stok='"+ hasil +"' where kd_barang = '"+ kb +"'";
            st=con.createStatement();
            st.execute(sql);
            //JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, "ERROR \n"+e.getMessage());
        }
    }
    
    private void cek(){
        try {
            String stc=stock.getText();
            int stk=Integer.parseInt(stc);
            int nol=0;
            if(stk < nol){
               JOptionPane.showMessageDialog(null, "STOK BARANG HABIS \n Silahkan Cek Persediaan Barang Terlebih Dahulu"); 
            }
            //ResultSet rs = st.executeQuery("SELECT * FROM servis WHERE KdSakit='" + jTextField9.getText() + "'"); 
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "STOK BARANG HABIS \n Silahkan Cek Persediaan Barang Terlebih Dahulu"+e.getMessage());
        }
    }
    
    public void waktu(){
        Date tgll= new Date();
        tgl_tran.setDate(tgll);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        har = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tgl_tran = new com.toedter.calendar.JDateChooser();
        cari = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        no_tran = new javax.swing.JTextField();
        kd_brg = new javax.swing.JTextField();
        nm_brg = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpenjualan = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        cetak_jual = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        byr = new javax.swing.JTextField();
        kem = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tot = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlh.setBackground(new java.awt.Color(240, 240, 176));
        jlh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jlhKeyReleased(evt);
            }
        });
        getContentPane().add(jlh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 184, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(221, 221, 135));
        jLabel10.setText("Harga");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, 14));

        har.setBackground(new java.awt.Color(240, 240, 176));
        har.setEnabled(true);
        getContentPane().add(har, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 184, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(221, 221, 135));
        jLabel9.setText("Tgl Transaksi");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        tgl_tran.setForeground(new java.awt.Color(240, 240, 176));
        tgl_tran.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_tranPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 184, -1));

        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 40, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(221, 221, 135));
        jLabel4.setText("No Transaksi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 14));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(221, 221, 135));
        jLabel5.setText("Kode Barang");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(221, 221, 135));
        jLabel6.setText("Stock");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(221, 221, 135));
        jLabel7.setText("Nama Barang");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        no_tran.setBackground(new java.awt.Color(240, 240, 176));
        no_tran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_tranActionPerformed(evt);
            }
        });
        getContentPane().add(no_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 184, -1));

        kd_brg.setBackground(new java.awt.Color(240, 240, 176));
        kd_brg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                kd_brgFocusLost(evt);
            }
        });
        kd_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_brgActionPerformed(evt);
            }
        });
        kd_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kd_brgKeyReleased(evt);
            }
        });
        getContentPane().add(kd_brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 184, -1));

        nm_brg.setBackground(new java.awt.Color(240, 240, 240));
        nm_brg.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nm_brg.setEnabled(false);
        getContentPane().add(nm_brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 184, -1));

        stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        stock.setEnabled(false);
        stock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockFocusLost(evt);
            }
        });
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });
        getContentPane().add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 184, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(221, 221, 135));
        jLabel8.setText("Jumlah");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        tabelpenjualan.setBackground(new java.awt.Color(240, 240, 176));
        tabelpenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nomor", "Nomor Transaksi", "Tanggal Transaksi", "Kode Barang", "Nama Barang", "Stock", "Jumlah", "Harga", "Total", "Bayar", "Kembalian"
            }
        ));
        jScrollPane1.setViewportView(tabelpenjualan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 950, 118));

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add(2).png"))); // NOI18N
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, 40));

        cetak.setBackground(new java.awt.Color(255, 255, 255));
        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/printer.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 100, 44));

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reload(1).png"))); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 60, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save(1).png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit(1).png"))); // NOI18N
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 60, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/garbage(1).png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, -1, -1));

        cetak_jual.setBackground(new java.awt.Color(240, 240, 176));
        getContentPane().add(cetak_jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 80, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shopping_Cart.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 68, 90));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 221, 135));
        jLabel3.setText("DATA PENJUALAN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        byr.setBackground(new java.awt.Color(240, 240, 176));
        byr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byrActionPerformed(evt);
            }
        });
        byr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                byrKeyReleased(evt);
            }
        });
        getContentPane().add(byr, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 222, -1));

        kem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        kem.setEnabled(false);
        getContentPane().add(kem, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 222, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(221, 221, 135));
        jLabel18.setText("Total");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, 14));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(221, 221, 135));
        jLabel15.setText("Bayar");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, 14));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(221, 221, 135));
        jLabel16.setText("Kembali");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, -1, 14));

        tot.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tot.setEnabled(false);
        getContentPane().add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 222, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(221, 221, 135));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background-pattern-shadow-dark-wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 670));

        jMenu1.setText("Home");
        jMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Input Data");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modify.png"))); // NOI18N
        jMenuItem1.setText("Data Barang");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/People.png"))); // NOI18N
        jMenuItem2.setText("Data Supplier");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Female.png"))); // NOI18N
        jMenuItem3.setText("Data Pelanggan");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transaksi");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buy.png"))); // NOI18N
        jMenuItem4.setText("Penjualan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delivery.png"))); // NOI18N
        jMenuItem5.setText("Pembelian");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Keluar");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void no_tranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_tranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_tranActionPerformed
        
    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockActionPerformed

    //tanggal
    private void tgl_tranPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_tranPropertyChange
        // TODO add your handling code here:
        if(tgl_tran.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tgl=format.format(tgl_tran.getDate());
        }
    }//GEN-LAST:event_tgl_tranPropertyChange

    private void jlhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlhKeyReleased
        String qtys=har.getText();       
        String totals=jlh.getText();
        double qtysd=Double.parseDouble(qtys);
        double totalsd=Double.parseDouble(totals);
        DecimalFormat df = new DecimalFormat("#.##");
        tot.setText(df.format(qtysd * totalsd));
        String awal=tot.getText();
        
      
        
        
    }//GEN-LAST:event_jlhKeyReleased

    private void stockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_stockFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Barang brg = new Barang();
        brg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Supplier sup = new Supplier();
        sup.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Pelanggan mem = new Pelanggan();
        mem.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Penjualan pen = new Penjualan();
        pen.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Pembelian pem = new Pembelian();
        pem.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1KeyPressed

    private void jMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu1MenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MenuKeyPressed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        // TODO add your handling code here:
        Home hm = new Home();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MenuSelected

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
      String no_transaksi = no_tran.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_draffa", "root", "");
            Statement statement = (Statement) koneksi.createStatement();
            String sql="SELECT * FROM penjualan WHERE no_transaksi like '"+no_transaksi+"'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())
            {
                aktif(true);
                setTombol(false);
                tgl_tran.setDate(rs.getDate(2));
                kd_brg.setText(rs.getString(3));
                nm_brg.setText(rs.getString(4));
                stock.setText(rs.getString(5));
                jlh.setText(rs.getString(6));
                har.setText(rs.getString(7));
                tot.setText(rs.getString(8));
                byr.setText(rs.getString(9));
                kem.setText(rs.getString(10));
                JOptionPane.showMessageDialog(null, "Data ditemukan","Insert Data",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan ","Insert Data",JOptionPane.INFORMATION_MESSAGE);
            }
            statement.close();
            koneksi.close();
        }
        catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, "Eror:"+e,"Gagal",JOptionPane.WARNING_MESSAGE);
            //System.err.println("Exception: "+e.getMessage());
        }
    }//GEN-LAST:event_cariActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5MouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        tran=String.valueOf(no_tran.getText());
        try{
            sql="DELETE FROM penjualan"
            +" where no_transaksi ='"+ tran +"' ";
            st=con.createStatement();
            st.execute(sql);
            Clear();
            ShowData(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n"+e.getMessage());
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        tran=String.valueOf(no_tran.getText());
        kb=String.valueOf(kd_brg.getText());
        nb=String.valueOf(nm_brg.getText());
        s=Integer.parseInt(stock.getText());
        j=Integer.parseInt(jlh.getText());
        h=Integer.parseInt(har.getText());
        t=Integer.parseInt(tot.getText());
        b=Integer.parseInt(byr.getText());
        k=Integer.parseInt(kem.getText());
        try{
            sql="update penjualan set kd_barang='"+ kb +"',tgl_transaksi='"+ tgl +"',nama_barang='"+ nb +"',stok='"+ s +"',jumlah='"+ j +"',harga='"+ h +"',total='"+ t +"',bayar='"+ b +"',kembalian='"+ k +"' where no_transaksi = '"+ tran +"'";
            st=con.createStatement();
            st.execute(sql);
            Clear();
            ShowData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n"+e.getMessage());
        }
        update();
    }//GEN-LAST:event_editActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        tran=String.valueOf(no_tran.getText());
        kb=String.valueOf(kd_brg.getText());
        nb=String.valueOf(nm_brg.getText());
        s=Integer.parseInt(stock.getText());
        j=Integer.parseInt(jlh.getText());
        h=Integer.parseInt(har.getText());
        t=Integer.parseInt(tot.getText());
        b=Integer.parseInt(byr.getText());
        k=Integer.parseInt(kem.getText());

        try{
            sql="INSERT INTO penjualan (no_transaksi, tgl_transaksi, kd_barang, nama_barang,  stok, jumlah,harga, total, bayar, kembalian)value"
            + "('"+ tran +"','"+ tgl +"','"+ kb +"','"+ nb +"','"+ s +"','"+ j +"','"+ h +"','"+ t +"','"+ b +"','"+ k +"')";
            st=con.createStatement();
            st.execute(sql);
            Clear();
            ShowData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Menyimpan Data"+e.getMessage());
        }
        update();
    }//GEN-LAST:event_simpanActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_draffa", "root", "");
            File report = new File("./src/ireport/penjualan.jrxml");
            JasDes = JRXmlLoader.load(report);
            param.put("kode_jual",cetak_jual.getText());
            JasperReport JasRep = JasperCompileManager.compileReport(JasDes);
            JasperPrint JasPri = JasperFillManager.fillReport(JasRep, param, koneksi);
            JasperViewer.viewReport(JasPri,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cetakActionPerformed

    private void byrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_byrKeyReleased
        // TODO add your handling code here:
        String qtys=tot.getText();
        String totals=byr.getText();
        double qtysd=Double.parseDouble(qtys);
        double totalsd=Double.parseDouble(totals);
        DecimalFormat df = new DecimalFormat("#.##");
        kem.setText(df.format(totalsd - qtysd));
    }//GEN-LAST:event_byrKeyReleased

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        Clear();
        aktif(false);
        setTombol(true);
    }//GEN-LAST:event_resetActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        aktif(true);
        otomatis();
        setTombol(false);
    }//GEN-LAST:event_tambahActionPerformed

    private void byrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_byrActionPerformed

    private void kd_brgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kd_brgKeyReleased
        // TODO add your handling code here:

        tran=no_tran.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try {

                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_draffa", "root", "");
                st=con.createStatement();
                RSpenjualan=st.executeQuery("select * from data_barang where kd_barang='" + kd_brg.getText() + "'");

                if (RSpenjualan.next()) {
                    nm_brg.setText(RSpenjualan.getString("nama_barang"));
                    stock.setText(RSpenjualan.getString("stok"));
                    har.setText(RSpenjualan.getString("harga_jual"));

                    String sc=stock.getText();
                    int sk=Integer.parseInt(sc);
                    int nol=0;
                    if(sk <= nol){
                        JOptionPane.showMessageDialog(null, "STOK BARANG HABIS \n Silahkan Cek Persediaan Barang Terlebih Dahulu");
                    }else{
                    }
                } else{
                    nm_brg.setText(null);
                    stock.setText(null);
                    har.setText(null);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal Memuat Data \n Data Tidak Di Temukan"+e.getMessage());
            }
        }
    }//GEN-LAST:event_kd_brgKeyReleased

    private void kd_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_brgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_brgActionPerformed

    private void kd_brgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kd_brgFocusLost
        // TODO add your handling code here:
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_draffa", "root", "");
            st=con.createStatement();
            RSpenjualan=st.executeQuery("select * from data_barang where kd_barang='" + kd_brg.getText() + "'");
            //ResultSet rs = st.executeQuery("SELECT * FROM servis WHERE KdSakit='" + jTextField9.getText() + "'");

            if (RSpenjualan.next()) {
                nm_brg.setText(RSpenjualan.getString("nama_barang"));
                stock.setText(RSpenjualan.getString("stok"));
                har.setText(RSpenjualan.getString("harga_jual"));

                String sc=stock.getText();
                int sk=Integer.parseInt(sc);
                int nol=0;
                if(sk <= nol){
                    JOptionPane.showMessageDialog(null, "STOK BARANG HABIS \n Silahkan Cek Persediaan Barang Terlebih Dahulu");
                }else{
                    //JOptionPane.showMessageDialog(null, "STOK BARANG HABIS \n Silahkan Cek Persediaan Barang Terlebih Dahulu");
                }
            } else{
                nm_brg.setText(null);
                stock.setText(null);
                har.setText(null);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Memuat Data \n Data Tidak Di Temukan"+e.getMessage());
        }
    }//GEN-LAST:event_kd_brgFocusLost
 private void otomatis(){
        try {
            open_db();
            String sql="select right (no_transaksi,2)+1 FROM penjualan";
            ResultSet rs=st.executeQuery(sql);
                kd_brg.setText("");
                nm_brg.setText("");
                tgl_tran.setDate(null);
                nm_brg.setText("");
                stock.setText("");
                har.setText("");
                jlh.setText("");
                byr.setText("");
                kem.setText("");
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    no_tran.setText("PJ"+no);}
                }
            else
            {
                no_tran.setText("PJ001"); 
            }
            } catch (Exception e) 
            {
        }
    }
    private void open_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_draffa", "root", "");
            st = (com.mysql.jdbc.Statement) con.createStatement();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi gagal");
            System.out.println(e.getMessage());
        }
    }
    private void aktif(boolean x) {
      no_tran.requestFocus();}

    private void setTombol(boolean t) {
     tambah.setEnabled(t);
     simpan.setEnabled(!t);
     hapus.setEnabled(!t);
     edit.setEnabled(!t);
     reset.setEnabled(!t);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField byr;
    private javax.swing.JButton cari;
    private javax.swing.JButton cetak;
    private javax.swing.JTextField cetak_jual;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField har;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jlh;
    private javax.swing.JTextField kd_brg;
    private javax.swing.JTextField kem;
    private javax.swing.JTextField nm_brg;
    private javax.swing.JTextField no_tran;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField stock;
    private javax.swing.JTable tabelpenjualan;
    private javax.swing.JButton tambah;
    private com.toedter.calendar.JDateChooser tgl_tran;
    private javax.swing.JTextField tot;
    // End of variables declaration//GEN-END:variables

}
