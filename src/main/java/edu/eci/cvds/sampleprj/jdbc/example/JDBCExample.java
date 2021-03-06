/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.sampleprj.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {

    public static void main(String args[]){
        try {
            String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="prueba2019";

            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);


            System.out.println("El costo total del pedido 1 es "+valorTotalPedido(con, 1));

            List<String> prodsPedido=nombresProductosPedido(con, 1);


            int pedido = 1;
            System.out.println("Productos del pedido 1");
            System.out.println("-----------------------");
            for (int i = 0 ; i<prodsPedido.size()-1 ; i=i+2){
                String nombre = prodsPedido.get(i);
                Integer codigo = Integer.parseInt(prodsPedido.get(i+1));
                if(codigo!=pedido) {
                    pedido +=1;
                    System.out.println("");
                    System.out.println("Productos del pedido " + prodsPedido.get(i + 1));
                    System.out.println("-----------------------");
                }
                System.out.println(nombre);
            }


            int suCodigoECI=2145445;
            registrarNuevoProducto(con, suCodigoECI, "David leon", 155500);
            con.commit();

            int suCodigoECI2=21854458;
            registrarNuevoProducto(con, suCodigoECI2, "Carlos Sorza", 999999);
            con.commit();


            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Agregar un nuevo producto con los par??metros dados
     * @param con la conexi??n JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        //Crear preparedStatement
        PreparedStatement nuevoProducto = null;
        String insert = "INSERT INTO ORD_PRODUCTOS VALUES (?,?,?);";
        nuevoProducto = con.prepareStatement(insert);
        nuevoProducto.setInt(1, codigo);
        nuevoProducto.setString(2, nombre);
        nuevoProducto.setInt(3, precio);
        nuevoProducto.executeUpdate();

        //Asignar par??metros
        //usar 'execute'


        con.commit();

    }

    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexi??n JDBC
     * @param codigoPedido el c??digo del pedido
     * @return
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido) throws SQLException {
        List<String> np=new LinkedList<>();

        //Crear prepared statement
        //asignar par??metros
        //usar executeQuery
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla

        PreparedStatement nombreProducto = null;
        String select = "SELECT nombre , pedido_fk " +
                        "FROM ORD_PRODUCTOS po ,ORD_DETALLE_PEDIDO pe " +
                        "WHERE po.codigo = pe.producto_fk " +
                        "ORDER BY pedido_fk;";
        nombreProducto = con.prepareStatement(select);
        ResultSet names = nombreProducto.executeQuery();
        while(names.next()){
            String nombre = names.getString("nombre");
            String pedido = names.getString("pedido_fk");
            np.add(nombre);
            np.add(pedido);
        }
        return np;
    }


    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido c??digo del pedido cuyo total se calcular??
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido) throws SQLException {

        //Crear prepared statement
        //asignar par??metros
        //usar executeQuery
        //Sacar resultado del ResultSet
        PreparedStatement costoPedido = null;
        String select = "SELECT sum(cantidad) as precio " +
                        "FROM ORD_DETALLE_PEDIDO " +
                        "WHERE pedido_fk ="+codigoPedido+" "+
                        "GROUP BY (pedido_fk);";
        costoPedido = con.prepareStatement(select);
        ResultSet costo = costoPedido.executeQuery();
        int precio = 0;
        while(costo.next()){
            precio = costo.getInt("precio");
        }
        return precio;
    }


}