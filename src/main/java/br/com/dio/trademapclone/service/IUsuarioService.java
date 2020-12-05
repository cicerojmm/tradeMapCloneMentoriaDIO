package br.com.dio.trademapclone.service;

import br.com.dio.trademapclone.dto.UsuarioDTO;
import br.com.dio.trademapclone.modelo.Usuario;

public interface IUsuarioService {

	UsuarioDTO consultar(String login);
	
	Usuario consultarEntidade(String login);

}
