package com.example.citas.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citas.model.Usuario;
import com.example.citas.service.UsuarioServiceImp;
import com.example.citas.util.JWTUtil;

@RestController
@RequestMapping("/api/autenticacion")
public class AuthController {

    @Autowired
    private UsuarioServiceImp servicio;

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping
	public ResponseEntity<?> createtoken(@RequestBody Usuario detalle){
		List<Usuario> persona = servicio.verificarUsuario(detalle.getUsuario(),detalle.getPassword());
		if(persona!=null && persona.size()>0) {
            String tokenJwt = jwtUtil.getJWTToken(persona.get(0).getUsuario()+"");
            return ResponseEntity.ok(new JSONObject().put("token", tokenJwt.replace("Bearer ", "")).put("usuario", servicio.verificarUsuario(detalle.getUsuario(),detalle.getPassword())).toString());
        }else {
			return ResponseEntity.ok((new JSONObject().put("token", "0")).toString());
		}
	}
}