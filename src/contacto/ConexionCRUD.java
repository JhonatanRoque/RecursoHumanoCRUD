package contacto;

import java.sql.*; //Libreria para las conexiones a la BD

public class ConexionCRUD {
    /*
    Ruta de la base de datos del servidor 127.0.0.1, el puerto 3306 y el nombre 
    de la base de datos bd_recurso_humano
    */
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/bd_recurso_humano"; //Cambiar el puerto 33066 por 3306, si da error, en mi paquina mysql utiliza el puerto 33066
    //Nombre del usuario (root por defecto) de la base de datos
    private final String usuario = "root";
    //Clave del usuario de la base de datos
    private final String clave = "";
    //Libreria de mysql
    private final String driverConector  = "com.mysql.jdbc.Driver";
    //Objeto de la clase Connection del paquete java.sql
    private static Connection conexion;
    
    public ConexionCRUD(){
        try{
            Class.forName(driverConector); //Levantar el driver
            //Establecer conexión
            conexion = DriverManager.getConnection(servidor, usuario, clave);
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexión fallida! Error! : " + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conexion; //Devuelve el objeto conexion
    }
    
    public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
        //cargar la conexión
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            //Definir la sentencia sql
            String sqlQueryStmt = "INSERT INTO " + tabla + " (" + camposTabla + ") VALUES (" + valoresCampos + ");";
            //Establecemos la comunicación entre nuestra aplicación java y la base de datos
            Statement stmt; //Envia sentencias sql a la base de datos
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt); //Ejecutar la sentencia sql
            //Cerrar el statement y la conexión se cierran en orden de como se han abierto
            stmt.close();
            cone.close();
            System.out.println("Registro guardado correctamente!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
        //Cargar la conexión
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            //Verificar que valoresCamposNuevos venga vacia y asi seleccionar si es borrar o actualizar registro
            if(valoresCamposNuevos.isEmpty()){
                sqlQueryStmt = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
            }else{
                sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + " ;";
                
            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void desplegarRegistros(String tablaBuscar, String campoBuscar, String condicionBuscar)throws SQLException{
        //Cargar la conexión
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            if(condicionBuscar.equals("")){
                sqlQueryStmt = "SELECT * FROM " + tablaBuscar + " ;";
            }else {
                sqlQueryStmt = "SELECT " + campoBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar + " ;";
            }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            //Le indicamos que ejecute la consulata de la tabla y la pasamos por argumentos nuestra sentencia
            try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if(miResultSet.next()){ //Ubica el curso en la primera fila de la tabla de resultado
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount(); //Obtiene el número de columnas de la consulta
                    System.out.println("<< REGISTROS ALMACENADOS >>");
                    System.out.println();
                    for (int i = 1; i <= numColumnas; i++){
                        //Muestra los titulos de las columnas y %-20s\t indica la separación entre columnas
                        if(i == 3){
                            System.out.printf("%-35s\t", metaData.getColumnName(i));
                        }else{
                           System.out.printf("%-20s\t", metaData.getColumnName(i)); 
                        }
                    }
                    System.out.println();
                    do{
                        for(int i = 1; i <= numColumnas; i++){
                            if(i == 3){
                                System.out.printf("%-35s\t", miResultSet.getObject(i));
                            }else{
                                System.out.printf("%-20s\t", miResultSet.getObject(i));
                            }
                        }
                        System.out.println();
                    }while(miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close(); //Cerrar el ResultSet
            }finally{
                //Cerrar el Statement y la Conexion: Se cierran en orden inverso de como se han abierto
                stmt.close();
                cone.close();
            }
        }catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
}
