/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author owner
 */
public class LaporanBackend {
    public int id_laporan,harga,stok,total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public String jenis_barang,nama_barang;

    public LaporanBackend() {
    }

    public LaporanBackend(int id_laporan, int harga, int stok,int total ,String jenis_barang,String nama_barang) {
        this.id_laporan = id_laporan;
        this.harga = harga;
        this.stok = stok;
        this.total = total;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public int getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(int id_laporan) {
        this.id_laporan = id_laporan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    

    
    public LaporanBackend getById(int id){
        LaporanBackend tr = new LaporanBackend();
        ResultSet rs = DB_Helper.selectQuery("SELECT * FROM laporan "
        +" WHERE id_laporan= '" + id + "'");
        
        try {
            while (rs.next()) {
                tr = new LaporanBackend(); 
                tr.setId_laporan(rs.getInt("id_laporan"));
                tr.setJenis_barang(rs.getString("jenis_barang"));
                tr.setNama_barang(rs.getString("nama_barang"));              
                tr.setStok(rs.getInt("stok"));
                tr.setHarga(rs.getInt("harga"));
                tr.setTotal(rs.getInt("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tr;
    }
    public ArrayList<LaporanBackend> getAll(){
        ArrayList<LaporanBackend> ListLaporan = new ArrayList();
        ResultSet rs = DB_Helper.selectQuery("SELECT * FROM laporan");
        
        try {
            while (rs.next()) {                
                LaporanBackend tr = new LaporanBackend();
                tr.setId_laporan(rs.getInt("id_laporan"));
                tr.setJenis_barang(rs.getString("jenis_barang"));
                tr.setNama_barang(rs.getString("nama_barang"));
                tr.setStok(rs.getInt("stok"));
                tr.setHarga(rs.getInt("harga"));
                tr.setTotal(rs.getInt("total"));
                ListLaporan.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListLaporan;
    }
    
    public void kirim(){
        String SQL = "INSERT INTO laporan(jenis_barang,nama_barang,stok,harga,total) VALUE("
                    +"      '"+ this.jenis_barang +"', "
                    +"      '"+ this.nama_barang +"', "
                    +"      '"+ this.stok +"', "
                    +"      '"+ this.harga +"', "
                    +"      '"+ this.total + "');";
            this.id_laporan = DB_Helper.insertQueryGetId(SQL);
    }
    
    public void save(){
        if(getById(id_laporan).getId_laporan()== 0){
            String SQL = "INSERT INTO laporan(jenis_barang,nama_barang,stok,harga,total) VALUE("
                    +"      '"+ this.jenis_barang +"', "
                    +"      '"+ this.nama_barang +"', "
                    +"      '"+ this.stok +"', "
                    +"      '"+ this.harga +"', "
                    +"      '"+ this.total +"', "
                    +"      );";
            this.id_laporan = DB_Helper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE laporan SET"
                    +"      jenis_barang = '"+ this.jenis_barang +"', "
                    +"      nama_barang = '"+ this.nama_barang +"', "
                    +"      stok = '"+ this.stok +"', "
                    +"      harga = '"+ this.harga +"', "
                    +"      total = '"+ this.total +"', "
                    +"      WHERE id_laporan = '" + this.id_laporan+ "' ";
            DB_Helper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM laporan WHERE id_laporan= '"+ this.id_laporan + "'";
        DB_Helper.executeQuery(SQL);
    }
}