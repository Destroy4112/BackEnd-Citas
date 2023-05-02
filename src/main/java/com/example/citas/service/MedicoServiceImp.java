package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Medico;
import com.example.citas.model.Rol;
import com.example.citas.model.Usuario;
import com.example.citas.repository.MedicoRepository;
import com.example.citas.repository.UsuarioRepository;

@Service
public class MedicoServiceImp implements MedicoService {

	@Autowired
	private MedicoRepository repositorio;

	@Autowired
	private UsuarioRepository repoUser;

	@Override
	public Medico addMedico(Medico medico) {

		Usuario usuario = new Usuario();
		usuario.setUsuario(medico.getDocumento());
		usuario.setPassword(medico.getDocumento());
		Rol r = new Rol();
		r.setId(1L);
		usuario.setRol(r);
		Usuario res = repoUser.save(usuario);
		medico.setUsuario(res);
		return repositorio.save(medico);
	}

	@Override
	public List<Medico> getMedicos() {
		return repositorio.consultarMedicosActivos();
	}

	@Override
	public Optional<Medico> getMedicosId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public int contador() {
		return repositorio.cantidadMedicos();
	}

	@Override
	public Medico updateMedico(Medico medico) {
		
		return null;
	}

}
