package com.example.foro.ForoAlura.controller;

import com.example.foro.ForoAlura.infra.security.DatosJWToken;
import com.example.foro.ForoAlura.infra.security.TokenService;
import com.example.foro.ForoAlura.usuarios.DatosAtenticacionCorreo;
import com.example.foro.ForoAlura.usuarios.Usuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticaCcorreo(@RequestBody  @Valid DatosAtenticacionCorreo datosAtenticacionCorreo){
        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosAtenticacionCorreo.email(),
                datosAtenticacionCorreo.contrasena());
        var usuarioAutenticado   = authenticationManager.authenticate(authtoken);
        var JWTtoken  =tokenService.generarToken((Usuarios
                ) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWToken(JWTtoken));
    }

}
