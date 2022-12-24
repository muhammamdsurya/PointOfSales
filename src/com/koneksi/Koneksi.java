/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koneksi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.view.Login;
import com.view.PointOfSales;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author muham
 */
public class Koneksi {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
   
   
    public Koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pos","root","");
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     *
     * @param user
     * @param pass
     */
    
    public void Login(String user, String pass)  { 
     
        try {
            pst = (PreparedStatement) conn.prepareStatement("SELECT * FROM kasir where username = ? and password =? ");
            pst.setString(1,user );
            pst.setString(2,pass );
            
            rs = pst.executeQuery();
            
            if (rs.next()) { 
                JOptionPane.showMessageDialog(null, "Login Berhasil !");
                Session.setId(rs.getString("id"));
                Session.setUsername(rs.getString("username"));
                Session.setCek(rs.getString("username"));
                PointOfSales menu = new PointOfSales();
                menu.setVisible(true);
                
            } else { 
                JOptionPane.showMessageDialog(null, "Username & Password Salah !");
                Login lg = new Login();
                lg.setVisible(true);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    public void tambahPr(String barcode, String product, String category, String harga, String qty, String status) {
        try {
            pst = (PreparedStatement) conn.prepareStatement("INSERT INTO product(barcode,nama,category,harga,qty,status)values(?,?,?,?,?,?) ");
            pst.setString(1,barcode);
            pst.setString(2, product);
            pst.setString(3,category);
            pst.setString(4, harga);
            pst.setString(5, qty);
            pst.setString(6, status);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Product Ditambahkan");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void updatePr(String barcode, String product, String category, String harga, String qty, String status) {
        try {
           pst = (PreparedStatement) conn.prepareStatement("UPDATE product SET nama=?,barcode=?,category=?,harga=?,qty=?,status=? where barcode= ?");
            pst.setString(1,product);
            pst.setString(2, barcode);
            pst.setString(3,category);
            pst.setString(4, harga);
            pst.setString(5, qty);
            pst.setString(6, status);
            pst.setString(7,barcode);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Product DiUpdate");
   
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePr(String barcode){  
        try {
            pst = (PreparedStatement) conn.prepareStatement("delete from product where barcode=?");
            pst.setString(1,barcode);
            JOptionPane.showMessageDialog(null,"Product DiHapus");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertPos(String kasir, String total, String bayar, String balance, TableModel data){ 
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            int lastId = 0;
            
            String query = "INSERT INTO sales(date,kasir,total,bayar,balance)values(?,?,?,?,?) ";
            
            pst = (PreparedStatement) conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1,date);
            pst.setString(2,kasir);
            pst.setString(3, total);
            pst.setString(4, bayar);
            pst.setString(5, balance);
            
            pst.executeUpdate();
            ResultSet generatedKeyResult = pst.getGeneratedKeys();
            
            if(generatedKeyResult.next()) { 
                lastId = generatedKeyResult.getInt(1);
            }
            int rows = data.getRowCount();
            String query1 = "INSERT INTO sales_product(sales_id,nama,harga,qty,subtotal)values(?,?,?,?,?) ";
            pst = (PreparedStatement) conn.prepareStatement(query1);
            
            
            for (int i =0; i<rows; i++) { 
                String nama_id = (String) data.getValueAt(i,1);
                String harga = (String) data.getValueAt(i,2);
                String qty = (String) data.getValueAt(i,3);
                int subtotal = (int) data.getValueAt(i,4);
                
                pst.setInt(1,lastId);
                pst.setString(2,nama_id);
                pst.setString(3,harga);
                pst.setString(4,qty);
                pst.setInt(5,subtotal);
                pst.executeUpdate();
                
            }
            
            String query2 = "UPDATE product SET qty=qty-? where barcode=? ";
            pst = (PreparedStatement) conn.prepareStatement(query2);
            
            for (int i =0; i<rows; i++) { 
                String barcode_id = (String) data.getValueAt(i,0);
                String qty = (String) data.getValueAt(i,3);
                    
                pst.setString(1,qty);
                pst.setString(2, barcode_id);
                
                pst.execute();
                
            }
                   
            pst.addBatch();
            JOptionPane.showMessageDialog(null,"Struk Berhasil Di Print!");
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
  
    public void insertKs(String user, String pass, String status) {   
        try {
            String query = "INSERT INTO kasir(username,password,status)values(?,?,?) ";
            pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1,user);
            pst.setString(2, pass);
            pst.setString(3,status);
           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Kasir Ditambahkan");
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void UpdateKs(String user, String pass, String status) {   
        try {
            String query = "UPDATE kasir SET username=?,password=?,status=? where username=?";
            pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1,user);
            pst.setString(2, pass);
            pst.setString(3,status);
            pst.setString(4,user);
           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Kasir Diedit!");
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
  
public void deleteKs(String user) { 
     try {
         int dialog = JOptionPane.showConfirmDialog(null,"Yakin?","Warning",JOptionPane.YES_NO_OPTION);
         if (dialog == JOptionPane.YES_OPTION){
            pst = (PreparedStatement) conn.prepareStatement("delete from kasir where username=?");
            pst.setString(1,user);
            JOptionPane.showMessageDialog(null,"Kasir DiHapus");
            pst.executeUpdate();
         }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
}  
  
    public ResultSet selectPr() {
        try {
            String query = "select * from product";
            st = conn.createStatement();
            rs  = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet selectPos(String barcode) {
        try {
            pst = (PreparedStatement) conn.prepareStatement("select * from product where barcode=?");
            pst.setString(1,barcode);
            rs = pst.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet selectKs() {
        try {
            String query = "select * from kasir";
            st = conn.createStatement();
            rs  = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet selectSl() {
        try {
            String query = "select * from sales";
            st = conn.createStatement();
            rs  = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
     public ResultSet selectSlPr() {
        try {
            String query = ("select sales.date, sales.kasir, sales_product.nama, sales_product.qty, sales_product.subtotal, (sales_product.qty * sales_product.subtotal) as total from sales inner join sales_product on sales.id=sales_product.sales_id"); 
            st = conn.createStatement();
            rs  = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    

    
}
    
