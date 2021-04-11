package com.tcs.app;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tcs.app.model.Empleado;
import com.tcs.app.restController.EmpleadoRestController;
import com.tcs.app.service.EmpleadoService;
import com.tcs.app.utilitario.CORSFilter;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
/*Se indica donde esta el servlet-context.xml, porque ahi se tiene la configuracion de BD, query, properties y demas*/
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class StudieControllerV0UnitTest {
	
	private MockMvc mockMvc;
	
	/*mock a la interface que implementa a Empleados*/
	@Mock
	private EmpleadoService empleadoService;
	
	@InjectMocks
	private EmpleadoRestController empleadoRestController;
	
	@Before
    public void init(){
		/*inicializando los objetos mock*/
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(empleadoRestController)
                .addFilters(new CORSFilter())
                .build();
    }
	
	@Test
	public void getEmpleado() throws Exception {
		
		Empleado empleado = new Empleado();
		empleado.setId(1);
		empleado.setNombre("Nombre 1");
		empleado.setApellido("Apellido 1");
		empleado.setEdad(21);
		empleado.setSexo("Masculino");
		
        when(empleadoService.get(empleado.getId())).thenReturn(empleado);
        
        /*verificar con lo que devuelve el servicio campo por campo*/
        mockMvc.perform(get("/rest/empleado/buscar/{id}", 1))
	        .andExpect(status().isOk())
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	        .andExpect(jsonPath("$.body.id", is(1)))
	        .andExpect(jsonPath("$.body.nombre", is("Nombre 1")))
	        .andExpect(jsonPath("$.body.apellido", is("Apellido 1")))
        	.andExpect(jsonPath("$.body.edad", is(21)))
        	.andExpect(jsonPath("$.body.sexo", is("Masculino")));
        
        /*verificar que solo se ejecute una vez*/
		verify(empleadoService, times(1)).get((long) 1);
		/*verificar que no existan mas interacciones*/
		verifyNoMoreInteractions(empleadoService);
		
	}

}
