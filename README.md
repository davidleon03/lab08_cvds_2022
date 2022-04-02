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


![image](https://user-images.githubusercontent.com/98216838/161363334-c25c3bd3-55ce-4589-9602-0c90f9efd864.png)
![image](https://user-images.githubusercontent.com/98216838/161363352-0b2cb624-670b-487d-9ea2-0dba00614133.png)
![image](https://user-images.githubusercontent.com/98216838/161363358-8dfdfecc-49b9-402d-98dc-ce9f4cd7216f.png)
