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
 * @author hp
 */
public class Admin  {
    public int id_admin;
    public String nama_user, username, password;

    public Admin(int id_admin, String nama_user, String username, String password) {
        this.id_admin = id_admin;
        this.nama_user = nama_user;
        this.username = username;
        this.password = password;
    }

    public Admin() {
        
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Admin getById(int id){
        Admin a = new Admin();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin "
        +" WHERE id_admin = '" + id + "'");
        
        try {
            while (rs.next()) {
                a = new Admin();
                a.setId_admin(rs.getInt("id_admin"));
                a.setNama_user(rs.getString("nama_user"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    
    public void save() {
        //To change body of generated methods, choose Tools | Templates.
        if(getById(id_admin).getId_admin()== 0){
            String SQL = "INSERT INTO admin (nama_user, username, password) VALUES("
                    +"      '"+ this.nama_user +"', "
                    +"      '"+this.username +"', "
                    +"      '"+this.password +"' "
                    +"      );";
            this.id_admin = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE user SET"
                    +"      nama = '"+ this.nama_user +"', "
                    +"      no hp = '"+this.username +"', "
                    +"      alamat = '"+this.password +"' "
                    +"      WHERE id_karyawan = '" + this.id_admin+ "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> ListAdmin = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin");

        try {
            while (rs.next()) {
                Admin pe = new Admin();
                pe.setId_admin(rs.getInt("id_admin"));
                pe.setNama_user(rs.getString("nama_user"));
                pe.setUsername(rs.getString("username"));
                pe.setPassword(rs.getString("password"));

                ListAdmin.add(pe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListAdmin;
    }
    
}
