## lab08_cvds_2022
## PARTE I. INICIO EN CLASE
Cree la interface ItemDAO y utilicela como referencia para realizar los Objetos de Acceso a los Datos (DAO) para las demas entidades:\
![image](https://user-images.githubusercontent.com/98216838/160669244-d0732236-9a23-4a84-8d0b-11e3e9fc2973.png)\
Usando como referencia la implementación de ItemDAO: MyBATISItemDao, cree el DAO MyBATIS de las demas entidades:\
![image](https://user-images.githubusercontent.com/98216838/160671573-0fc12885-161e-4be9-af7a-cd17309826b0.png)\
Cree la interface ServiciosAlquiler para los servicios de la capa lógica:\
![image](https://user-images.githubusercontent.com/98216838/160672132-832cd925-8d1e-4d45-a0c6-435b2e7ada1c.png)\
Realice en la implementación de la capa lógica (ServiciosAlquilerImpl), inyecte los DAO que sean necesarios. Tome de ejemplo el ItemDAO.\
Realice la implementación de un servicio Stub (ServiciosAlquilerItemsStub) para que se pueda probar la lógica facilmente sin la capa de persistencia:\
![image](https://user-images.githubusercontent.com/98216838/160673201-1c69c788-4fa5-4bbc-9164-0326de51137c.png)\
Pruebe el programa ‘Main’ suministrado, y con este rectifique que a través de la capa lógica se pueda consultar un cliente.\

Implemente los métodos que sean necesarios en las interfaces de las entidades (DAO) y en sus implementaciones haciendo uso del DAO inyectado. Haga un programa para comprobar que la consulta de un cliente se haga correctamente, a través de la capa lógica.\

## PARTE II - PRUEBAS

PARTE III - CAPA PRESENTACIÓN

3. Cree el listener con el paquete y nombre indicados de forma que se asocie la configuración de Guice y MyBatis a la inicialización del contexto de la aplicación en el servidor tomcat7 embebido, con el siguiente contenido inicial, resolviendo el ‘TODO’ (asociando la interfaz del servicio a la implementación Stub)

  ![image](https://user-images.githubusercontent.com/78982514/161620858-065c9019-47d6-41fd-bec9-1b3f68206147.png)
  
5. Implementar la aplicación Web que permita agregar nuevos clientes a la videotienda, y registrar alquileres para los mismos. Ambas funcionalidades estarán en dos vistas diferentes (registrocliente.xhtml, registroalquiler.xhtml), de acuerdo con las siguientes especificaciones (tenga en cuenta que, por ahora, la aplicación no maneja ningún esquema de autenticación)

### Registro Alquiler
 
![image](https://user-images.githubusercontent.com/78982514/161624436-9c08df6a-1b56-4473-b19e-a82024056050.png)
![image](https://user-images.githubusercontent.com/78982514/161624472-2debe4e0-2b19-42a3-8bdc-d7a472b24935.png)
 

### Registro Cliente

![image](https://user-images.githubusercontent.com/78982514/161624330-af054d57-cf3a-4582-8ff4-aaf76d38e0c7.png)
![image](https://user-images.githubusercontent.com/78982514/161624352-47831df2-e93c-448b-b3a8-df1d2b768546.png)

