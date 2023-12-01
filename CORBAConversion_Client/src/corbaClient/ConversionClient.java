package corbaClient;
import corbaConversion.IConversionRemote;
import corbaConversion.IConversionRemoteHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionClient {
        public static void main(String[] args) {
            try {
                // Création d'un contexte InitialContext pour interagir avec l'annuaire JNDI
                Context ctx = new InitialContext();
                // Récupération de la référence de l'objet distant à partir de l'annuaire JNDI
                java.lang.Object ref = ctx.lookup("BK");
                // Conversion de la référence vers le type de l'objet à utiliser (IConversionRemote)
                IConversionRemote stub = IConversionRemoteHelper.narrow((org.omg.CORBA.Object)ref);
                // Appel de la méthode convertirMontant() via le stub pour convertir un montant (70.00)
                System.out.println(stub.convertirMontant(70.00));
                // Appel de la méthode distante convertirMontant() via le stub pour convertir un  montant (150.00)
                System.out.println(stub.convertirMontant(150.00));

            }
            catch (NamingException e){
                throw new RuntimeException(e);
            }
        }
    }











    //jms andou haja ismha broker ykhdm ala lkol activemq