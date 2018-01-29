package tdi.bootcamp.latihan.hibernate;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import tdi.bootcamp.latihan.hibernate.model.Kecamatan;
import tdi.bootcamp.latihan.hibernate.model.Kelurahan;
import tdi.bootcamp.latihan.hibernate.model.Kota;
import tdi.bootcamp.latihan.hibernate.model.Provinsi;
import tdi.bootcamp.latihan.hibernate.util.HibernateUtil;

public class MainApp {
    
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            
        String result = getNativeQuery( session, "select version()");
        System.out.println(result);
        
            List<Kelurahan> listKel= getKel(session);
                for (Kelurahan kelurahan: listKel){
                System.out.println(" Id_Kel " + kelurahan.getIdKel() + " Nama_Kel           " +
                    kelurahan.getNamaKel() + " Id_Kec " + kelurahan.getKecamatan().getIdKec());
            }

//            List<Kecamatan> listKec= getKec(session);
//                for (Kecamatan kecamatan: listKec){
//                System.out.println(" Id_Kec " + kecamatan.getIdKec() + " Nama_Kec           " +
//                    kecamatan.getNamaKec() + " Id_Kota_Kab " + kecamatan.getKotaKabupaten().getIdKota());
//            }
               
//            List<Provinsi> listProv= getProv(session);
//                for (Provinsi provinsi: listProv){
//                System.out.println(" Id_Prov " + provinsi.getIdProv() + " Nama_Prov           " +
//                    provinsi.getNamaProv() + " Id_Negara " + provinsi.getIdNeg());
//            }

//           List<Kelurahan> listKel = getKelurahan(session);
//                for (Kelurahan kelurahan : listKel){
//                System.out.println(" Kelurahan  " + kelurahan.getNamaKel() + "      " + kelurahan.getKecamatan().getNamaKec());
//            }

//            List<Kecamatan> listkec = getKecamatan(session);
//                for (Kecamatan kecamatan : listkec) {
//                System.out.println(" Kecamatan " + kecamatan.getNamaKec() + "       " + kecamatan.getKotaKabupaten().getNamaKota());
//            }
      
//            List<Kota> listProv = getProvinsi(session);
//                for (Kota kotaKabupaten : listProv) {
//                System.out.println("Kota_Kabupaten  " + kotaKabupaten.getNamaKota()+ "      " + kotaKabupaten.getProvinsi().getNamaProv());
//            }
                   
            session.getTransaction().commit();
            session.close();
		
            HibernateUtil.shutdown();	
	}
    
        //Perintah Select dari Tabel Kecamatan
        private static List<Kecamatan> getKec(Session session){
            return session.createQuery("select c from Kecamatan c ").getResultList();
        }
        
        //Perintah Select dari Tabel Kelurahan
        private static List<Kelurahan> getKel(Session session){
            return session.createQuery("select l from Kelurahan l ").getResultList();
        }
        
        //Perintah Select dari Tabel Provinsi
        private static List<Provinsi> getProv(Session session){
            return session.createQuery("select p from Provinsi p ").getResultList();
        }
        
        //Perintah menggabungkan Kelurahan dan Kecamatan
        private static List<Kelurahan> getKelurahan(Session session) {
            return session.createQuery("select l from Kelurahan  l JOIN FETCH l.kecamatan").getResultList();
        }
        
        //Perintah menggabungkan Kecamatan dan Kota
        private static List<Kecamatan> getKecamatan(Session session) {
            return session.createQuery("select c from Kecamatan c JOIN FETCH c.kotaKabupaten").getResultList();
        }
        
        //Perintah menggabungkan Kota dan Provinsi
        private static List<Kota> getProvinsi(Session session) {
            return session.createQuery("select k from Kota k JOIN FETCH k.provinsi").getResultList();
        }
        
	private static String getNativeQuery(Session session, String sql) {
		
		return (String) session.createNativeQuery(sql).getSingleResult();
        }
}