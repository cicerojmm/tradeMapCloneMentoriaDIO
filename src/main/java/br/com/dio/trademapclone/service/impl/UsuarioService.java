package br.com.dio.trademapclone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.trademapclone.conversor.usuarioConversor;
import br.com.dio.trademapclone.dto.UsuarioDTO;
import br.com.dio.trademapclone.modelo.AcaoFavorita;
import br.com.dio.trademapclone.modelo.Usuario;
import br.com.dio.trademapclone.repository.UsuarioRepository;
import br.com.dio.trademapclone.service.IAcaoFavoritaService;
import br.com.dio.trademapclone.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private IAcaoFavoritaService acaoFavoritaService;

	@Autowired
	private usuarioConversor usuarioConversor;

	@Override
	public UsuarioDTO consultar(String login) {
		Usuario usuario = consultarEntidade(login);
		if (usuario != null) {
			List<AcaoFavorita> acoes = acaoFavoritaService.listar(usuario);
			return usuarioConversor.converterEntidadeParaDto(usuario, acoes);
		}

		return null;
	}
	
	@Override
	public Usuario consultarEntidade(String login) {
		return usuarioRepository.findByLogin(login);
	}

}
