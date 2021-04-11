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

import com.tcs.app.model.Ingresos;
import com.tcs.app.service.IngresosService;
import com.tcs.app.utilitario.Error;
import com.tcs.app.utilitario.Response;

@RestController
@RequestMapping("rest/ingresos")
public class IngresosRestController {

	@Autowired
	private IngresosService ingresosService;

	@PostMapping("crear")
	public ResponseEntity<Response> create(@RequestBody Ingresos ingresos) {
		Response response = new Response();
		try {
			Ingresos ingresosResponse = ingresosService.create(ingresos);
			response.setBody(ingresosResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("listar")
	public ResponseEntity<Response> list() {
		Response response = new Response();
		try {
			List<Ingresos> ingresosResponse = ingresosService.list();
			response.setBody(ingresosResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("buscar/{id}")
	public ResponseEntity<Response> get(@PathVariable Long id) {
		Response response = new Response();
		try {
			Ingresos ingresosResponse = ingresosService.get(id);
			response.setBody(ingresosResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		Response response = new Response();
		try {
			ingresosService.delete(id);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

	@PutMapping("actualizar")
	public ResponseEntity<Response> update(@RequestBody Ingresos ingresos) {
		Response response = new Response();
		try {
			Ingresos ingresosResponse = ingresosService.update(ingresos);
			response.setBody(ingresosResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok().body(response);
	}

}