/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.lang.String;

/**
 *
 * @author owner
 */
public class Barang {
    public String nama_barang, jenis;
    public int id_barang,stok,harga,id_admin;
    
//    public enum jenis_barang{
//        Kering(1),Basah(2);
//        private int value;
//        
//        private jenis_barang(int value) {
//        this.value = value;
//        }
//
//        public int getJenis() {
//            return value;
//        }
//        //Just for testing from some SO answers, but no use
//        public void setJenis(int value) {
//            this.value = value;
//        }
//    }

    public Barang(String nama_barang, String jenis, int id_barang, int stok, int harga, int id_admin) {
        this.nama_barang = nama_barang;
        this.jenis = jenis;
        this.id_barang = id_barang;
        this.stok = stok;
        this.harga = harga;
        this.id_admin = id_admin;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public Barang() {
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    
    public int getId_admin() {
        return id_admin;
    }
    public Barang getById(int id){
        Barang br = new Barang();
        ResultSet rs = DB_Helper.selectQuery("SELECT * FROM barang "
        +" WHERE id_barang = '" + id + "'");
        
        try {
            while (rs.next()) {
                br = new Barang(); 
                br.setId_barang(rs.getInt("id_barang"));
                br.setJenis(rs.getString("jenis_barang"));
                br.setNama_barang(rs.getString("nama_barang"));
                br.setStok(rs.getInt("stok"));
                br.setHarga(rs.getInt("harga"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }
    public ArrayList<Barang> getAll(){
        ArrayList<Barang> ListBarang = new ArrayList();
        ResultSet rs = DB_Helper.selectQuery("SELECT * FROM barang");
        
        try {
            while (rs.next()) {                
                Barang br = new Barang();
                br.setId_barang(rs.getInt("id_barang"));
                br.setJenis(rs.getString("jenis_barang"));
                br.setNama_barang(rs.getString("nama_barang"));
                br.setStok(rs.getInt("stok"));
                br.setHarga(rs.getInt("harga"));
                br.setId_admin(rs.getInt("id_admin"));
                ListBarang.add(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBarang;
    }
    
    public void save(){
        if(getById(id_barang).getId_barang()== 0){
            String SQL = "INSERT INTO barang (jenis_barang,nama_barang,stok,harga) VALUE("
                    +"      '"+ this.jenis +"', "
                    +"      '"+ this.nama_barang +"', "
                    +"      '"+ this.stok +"', "
                    +"      '"+ this.harga +"' "
//                    +"      '"+ this.id_admin +"' "
                    +"      )";
            this.id_barang = DB_Helper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE barang SET"
                    +"      jenis_barang = '"+ this.jenis +"', "
                    +"      nama_barang = '"+ this.nama_barang +"', "
                    +"      stok = '"+ this.stok +"', "
                    +"      harga = '"+ this.harga +"' "
//                    +"      harga = '"+ this.id_admin +"' "
                    +"      WHERE id_barang = '" + this.id_barang+ "' ";
            DB_Helper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM barang WHERE id_barang = '"+ this.id_barang + "'";
        DB_Helper.executeQuery(SQL);
    }
    

    @Override
    public String toString() {
        return nama_barang;
    }
}
