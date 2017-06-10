/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinarbank;

import java.util.Scanner;

/**
 *
 * @author sholjun
 */
public class DinarBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tabelnasabah entityObjk =new tabelnasabah();
        QueryDB tambah = new QueryDB();
        Scanner input=new Scanner(System.in);
        String nama,nohp,jwb,alamat;
        long id;
        
        System.out.println("SELAMAT DATANG DI DINAR BANK");
        System.out.println("Masukkan Biodata Anda :");
        System.out.print("Nama Lengkap :");nama = input.nextLine();
        System.out.print("Nomor hp :");nohp=input.nextLine();
        System.out.print("Alamat :");alamat=input.nextLine();
        entityObjk.setNama(nama);
        entityObjk.setNohp(nohp);
        entityObjk.setAlamat(alamat);
        tambah.Add(entityObjk);
        
        System.out.println("Apakah data anda ingin dilihat kan ? jawab ya/no");jwb=input.nextLine();
        if(jwb.equals("ya")){
        tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di rubah/di hapus kan ?\n"
                + "jawab lanjut : untuk rubah "
                + "\n jawab ok : untuk hapus");
        jwb=input.nextLine();
        
        if(jwb.equals("lanjut")){
            System.out.print("Nama :");nama = input.nextLine();
            System.out.print("No HP :");nohp = input.nextLine();
            System.out.print("Alamat :");alamat = input.nextLine();
            System.out.print("ID :");id=input.nextLong();
            tambah.update(id,nama,alamat,nohp);
            tambah.Show();
            
        }else if(jwb.equals("ok")){
            tambah.Show();
            System.out.print("Masukan ID :");id=input.nextLong();
            tambah.hapus(id);
            tambah.Show();
        }
        
    
        
    }
    
}
