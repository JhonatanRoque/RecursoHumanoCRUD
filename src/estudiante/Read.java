package estudiante;

import java.sql.*;

public class Read {
    public Read() throws SQLException {
        System.out.println("<< CONSULTA REGISTROS >>");
        mostrarResultados();
    }

    private void mostrarResultados() {
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "";
            //Condición se envia vacia para indicar que todos los registros se neceistan
            String condicionBusqueda = "";
            //Método que realiza la busqueda
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}
