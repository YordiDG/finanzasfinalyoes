package org.mininimarketyoesbackend.service.Impl;

import org.mininimarketyoesbackend.model.RegisterWithPhoneNumberRequest;
import org.mininimarketyoesbackend.model.User;
import org.mininimarketyoesbackend.repository.UsuarioRepository;
import org.mininimarketyoesbackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<User> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public User obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public User agregarUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public User actualizarUsuario(Long id, User usuarioActualizado) {
        User usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setFirstName(usuarioActualizado.getFirstName());
            usuario.setLastName(usuarioActualizado.getLastName());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setPhoneNumber(usuarioActualizado.getPhoneNumber());
            usuario.setRole(usuarioActualizado.getRole());

            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }


    @Override
    public User registerWithPhoneNumber(RegisterWithPhoneNumberRequest request) {

        String phoneNumber = request.getPhoneNumber();
        if (!isValidPhoneNumber(phoneNumber)) {
            return null;
        }

        if (usuarioRepository.existsByPhoneNumber(phoneNumber)) {
            return null;
        }
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setPhoneNumber(request.getPhoneNumber());

        return usuarioRepository.save(newUser);
    }

    private static final String PHONE_NUMBER_PATTERN = "(\\+51)?\\s?9[0-9]{8}";

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
