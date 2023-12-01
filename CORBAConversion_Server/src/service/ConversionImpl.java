package service;

import corbaConversion.IConversionRemotePOA;
// Déclaration de la classe ConversionImpl qui étend l'interface IConversionRemotePOA
public class ConversionImpl extends IConversionRemotePOA {

    @Override // Indique que cette méthode redéfinit une méthode de la classe parente
    public double convertirMontant(double mt) {
        return mt * 3.3; // Implémentation de la logique de conversion
    }
}






























//chnbdl methode maanha naaml modification