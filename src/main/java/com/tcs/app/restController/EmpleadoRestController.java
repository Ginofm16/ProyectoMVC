package com.tcs.app.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.app.model.Empleado;
import com.tcs.app.service.EmpleadoService;
import com.tcs.app.utilitario.Error;
import com.tcs.app.utilitario.Response;

@RestController
@RequestMapping("rest/empleado")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService empleadoService;

	@PostMapping("crear")
	public ResponseEntity<Response> create(@RequestBody Empleado empleado) {
		Response response = new Response();
		try {
			Empleado empleadoResponse = empleadoService.create(empleado);
			response.setBody(empleadoResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/listar")
	public ResponseEntity<Response> list() {
		Response response = new Response();
		try {
			List<Empleado> empleadoResponse = empleadoService.list();
			response.setBody(empleadoResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("buscar/{id}")
	public ResponseEntity<Response> get(@PathVariable Long id) {
		Response response = new Response();
		try {
			Empleado empleadoResponse = empleadoService.get(id);
			response.setBody(empleadoResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		Response response = new Response();
		try {
			empleadoService.delete(id);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

	@PutMapping("actualizar")
	public ResponseEntity<Response> update(@RequestBody Empleado empleado) {
		Response response = new Response();
		try {
			Empleado empleadoResponse = empleadoService.update(empleado);
			response.setBody(empleadoResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

}
