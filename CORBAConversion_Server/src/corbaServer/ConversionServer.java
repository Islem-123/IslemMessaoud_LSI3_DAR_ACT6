package corbaServer;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import service.ConversionImpl;
import javax.naming.Context;
import javax.naming.InitialContext;
public class ConversionServer {
    public static void main(String[] args) {
        try {
            //initialisation de l'ORB en utilisant les arguments passés au programme
            ORB orb = ORB.init(args, null);
            // une référence sur le RootPOA (Portable Object Adapter) est obtenue à partir de l'ORB
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));                     //orb heki naamlha bch  nhwl min objet lil reference
            //activation de POAManager
            poa.the_POAManager().activate();
            // Création d'une instance de l'implémentation du service de conversion.
            ConversionImpl od = new ConversionImpl();
            //publication de l’objet dans l’annuaire
            Context ctx = new InitialContext();
            //La méthode rebind() lie l'objet distant od à la clé  "BK" dans l'annuaire JNDI à l'aide du POA.
            ctx.rebind("BK", poa.servant_to_reference(od));
            // l'ORB en attente des requêtes des clients
            orb.run();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}












//orb //jndi c'est un standard