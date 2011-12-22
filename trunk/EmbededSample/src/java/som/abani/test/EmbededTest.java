/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package som.abani.test;

import com.abani.ejbs.HalloBean;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

/**
 *
 * @author CHIKI
 */
public class EmbededTest {
    private static final String APP_NAME = "Sample";
    public static void main (String[] x){
        test();
    }
    public static void test (){
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put(EJBContainer.APP_NAME, APP_NAME);
        EJBContainer ec = null;
        try {
            ec = EJBContainer.createEJBContainer(prop);
            Context context = ec.getContext();
            HalloBean hallo = (HalloBean) context.lookup("java:global/Sample/classes/HalloBean");
            System.out.println("hallo obj " + hallo.greet());
        }catch(Exception e){
           // e.printStackTrace();
        }finally{
            ec.close();
        }
    }
}
