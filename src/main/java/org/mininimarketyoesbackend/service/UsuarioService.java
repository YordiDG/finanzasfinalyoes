package org.mininimarketyoesbackend.service;

import org.mininimarketyoesbackend.model.RegisterWithPhoneNumberRequest;
import org.mininimarketyoesbackend.model.User;

import java.util.List;

public interface UsuarioService {
    List<User> obtenerTodosLosUsuarios();
    User obtenerUsuarioPorId(Long id);
    User agregarUsuario(User usuario);
    User actualizarUsuario(Long id, User usuarioActualizado);
    void eliminarUsuario(Long id);

    User findByEmailAndPassword(String email, String password);

    User registerWithPhoneNumber(RegisterWithPhoneNumberRequest request);
}
