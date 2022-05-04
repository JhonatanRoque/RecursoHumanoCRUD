package contacto;

import java.sql.*;
import java.util.*;

public class Update {
    Update() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Persona person = new Persona();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ACTUALIZAR REGISTROS >>");
        
        System.out.println("Ingresar id del registro a modificar: ");
        person.setIdPersona(leer.nextInt());
        
        //reingreso de datos para actualizar
        String tablaBuscar = "tb_estudiante";
        String camposBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + person.getIdPersona();
        utilerias.desplegarRegistros(tablaBuscar, camposBuscar, condicionBuscar);
        
        System.out.println("Carnet: ");
        person.setCarnet(leer.next());
        
        System.out.println("Nombre: ");
        person.setNomPersona(leer.next());
        
        System.out.println("Apellido: ");
        person.setApellido(leer.next());
        
        System.out.println("Teléfono: ");
        person.setEdad(leer.nextInt());
        
        String tabla = "tb_estudiante";
        String camposValoresNuevos = "carnet_estudiante = '" + person.getCarnet() + "', nom_estudiante = '" + person.getNomPersona() + "' , ape_estudiante = '" + person.getApellido() + "' , edad_estudiante = '" + person.getEdad() + "' ";
        utilerias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente! ");
        
        MenuPrincipal.desplegarMenu();
    }
}
