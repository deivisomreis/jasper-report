package com.deivisonprogrammer.jasper.dao;

import java.util.List;

import com.deivisonprogrammer.jasper.model.Usuario;

public interface UsuarioInterface {

	void insert(Usuario u);
	List<Usuario> getUsuarios();
}
