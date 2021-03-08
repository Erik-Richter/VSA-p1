/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1ut;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author vsa
 */
public class T1ut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t1utPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNativeQuery("select * from KNIHA", Kniha.class);
        List<Kniha> knihy = q.getResultList();
        
        for(Kniha k: knihy){
            System.out.println("" + k);
        }
    }


    
    /**    
     * Zakomentovana cast je ekvivalent k vykonavanemu kodu (pre spustenie je treba definovat atributy v Kniha.java na public)
     * 
     * public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM KNIHA");
        List<Kniha> knihy = new ArrayList<>();
        
        while(rs.next()){
            
            Kniha k = new Kniha();
            k.nazov = rs.getString(1);
            k.cena = rs.getDouble("CENA");
            knihy.add(k);
            System.out.println("" + k);
        }
    }**/
}
