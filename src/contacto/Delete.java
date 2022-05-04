package contacto;

import java.sql.*;
import java.util.*;

public class Delete {
    Delete() throws SQLException{
        Scanner leer = new Scanner(System.in); 
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTROS >>");
        
        System.out.println("Ingresr el id del registro: ");
        String idEstudianteEliminar = leer.next();
        
        //reingreso de datos para actualizar
        String tabla = "tb_estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + idEstudianteEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Presionar << Y >> para confirmar, << N >> para cancelar: ");
        String confirmarBorrar = leer.next();
        
        if("Y".equals(confirmarBorrar) | "y".equals(confirmarBorrar)){
            /*
            Se le deja vacio para el método actualizar EliminarRegistros
            envie solamente los parametros de la tabla y condicion y poder eliminar
            */
            campos = "";
            utilerias.actualizarEliminarRegistro(tabla, campos, condicion);
            System.out.println("Registro borrado satisfactoriamente!");
        }else if("N".equals(confirmarBorrar) | "n".equals(confirmarBorrar)){
            System.out.println("Se cancelo la acción");
        }
        
        MenuPrincipal.desplegarMenu();
    }
}
