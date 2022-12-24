/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koneksi;

/**
 *
 * @author muham
 */
public class Session {
    private static String id;
    private static String username;
    private static String cek;
    
    public static String getUsername() { 
        return username;
    }
     public static void setUsername(String username) { 
        Session.username = username;
        
    }
     public static String getid() { 
        return id;
    }
     public static void setId(String id) { 
        Session.id = id;
    }
     public static String getCek() { 
        return cek;
    }
     public static void setCek(String cek) { 
        Session.cek = cek;
    }
    
}
