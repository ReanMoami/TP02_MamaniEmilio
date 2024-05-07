package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;


public class Main {
    public static void main(String[] args) {
        FelinoDomestico pepe = new FelinoDomestico("pepe", (byte) 50, 120f);
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        FelinoSalvaje felino1 = converter.convert(pepe);
        converter.mostrarObjeto(felino1);

        FelinoSalvaje Juan = new FelinoSalvaje("Juan", (byte) 23, 150f);
        if (Converter.isNotNull(Juan)) {
        	 Converter<FelinoSalvaje, FelinoDomestico> converter1 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
        	 FelinoDomestico felinoConvertido = converter1.convert(Juan);
        	 converter1.mostrarObjeto(felinoConvertido);
        }else {
            System.out.println("El objeto a convertir no existe.");
        }
    }
}