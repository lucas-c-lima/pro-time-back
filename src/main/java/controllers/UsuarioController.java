package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.protime.entities.Usuario;
import com.proj.protime.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsers(){
		List<Usuario> users = usuarioService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}
	
}
