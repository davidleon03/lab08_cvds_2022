package edu.eci.cvds.test;

import static org.junit.Assert.assertNull;


import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void noDeberiaConsultarcliente() throws ExcepcionServiciosAlquiler {
        assertNull(serviciosAlquiler.consultarCliente(1));
    }
    @Test
    public void deberiaConsultarCliente(){
        try {
            serviciosAlquiler.consultarCliente(2233);
            Assert.assertTrue(true);
        } catch (ExcepcionServiciosAlquiler ex) {
            Assert.fail();
        }
    }
    @Test
    public void deberiaRegistrarcliente(){
        try {
            ArrayList<ItemRentado> itemRentados = new ArrayList<ItemRentado>();
            Cliente cliente = new Cliente("david",2168514,"telefono","direccion","email",false,itemRentados);
            serviciosAlquiler.registrarCliente(cliente);
            Assert.assertTrue("david".equals(serviciosAlquiler.consultarCliente(2168514).getNombre()));
        } catch (ExcepcionServiciosAlquiler ex) {
            Assert.fail();
        }
    }
    @Test
    public void NodeberiaRegistrarclienterepetido(){
        try {
            ArrayList<ItemRentado> itemRentados = new ArrayList<ItemRentado>();
            Cliente cliente = new Cliente("david",2168514,"telefono","direccion","email",false,itemRentados);
            serviciosAlquiler.registrarCliente(cliente);
        } catch (ExcepcionServiciosAlquiler ex) {
            Assert.fail();
        }
    }
    
    
    
}