package estudiante;

import java.sql.SQLException;
import java.util.*;

public class Create {
    Create() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Persona person = new Persona(); //Objeto person de la clase persona
        System.out.println("<< CREAR REGISTRO >>");
        
        System.out.println("Carnet: ");
        person.setCarnet(leer.nextLine());
        
        System.out.println("Nombre: ");
        person.setNomPersona(leer.nextLine()); 
        
        System.out.println("Apellido: ");
        person.setApellido(leer.nextLine());
        
        System.out.println("Edad: ");
        person.setEdad(leer.nextInt());
        
        String tabla = "tb_estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCampos = "'" + person.getCarnet() + "', '"+ person.getNomPersona() + "', '" + person.getApellido()+ "' , '" + person.getEdad() + "'";
        //instancia u objeto de la clase ConexionCRUD
        ConexionCRUD utilerias = new ConexionCRUD();
        //Se encian los parametros necesarios para guardar el registro al metodo guardarRegistros
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
        
        MenuPrincipal.desplegarMenu(); //Llama el metodo del menu principal
    }
}
