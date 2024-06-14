package org.mininimarketyoesbackend.controller;

import org.mininimarketyoesbackend.model.LoginRequest;
import org.mininimarketyoesbackend.model.PhoneNumberValidator;
import org.mininimarketyoesbackend.model.RegisterWithPhoneNumberRequest;
import org.mininimarketyoesbackend.model.User;
import org.mininimarketyoesbackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimarket/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/All-Users")
    public List<User> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public User obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping("/new")
    public User agregarUsuario(@RequestBody User usuario) {
        return usuarioService.agregarUsuario(usuario);
    }

    @PutMapping("/{id}/update")
    public User actualizarUsuario(@PathVariable Long id, @RequestBody User usuarioActualizado) {
        return usuarioService.actualizarUsuario(id, usuarioActualizado);
    }

    @DeleteMapping("/{id}/delete")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = usuarioService.findByEmailAndPassword(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register_cell")
    public ResponseEntity<User> registerWithPhoneNumber(@RequestBody RegisterWithPhoneNumberRequest request) {

        User user = usuarioService.registerWithPhoneNumber(request);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        if (!PhoneNumberValidator.validatePhoneNumber(user.getPhoneNumber())) {
            return ResponseEntity.badRequest().build();
        }

        User registeredUser = usuarioService.agregarUsuario(user);
        if (registeredUser != null) {
            return ResponseEntity.ok(registeredUser);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

