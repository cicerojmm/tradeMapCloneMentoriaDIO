package br.com.dio.trademapclone.conversor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dio.trademapclone.dto.UsuarioDTO;
import br.com.dio.trademapclone.modelo.AcaoFavorita;
import br.com.dio.trademapclone.modelo.Usuario;

@Component
public class usuarioConversor extends ConversorBase<Usuario, UsuarioDTO> {

	@Autowired
	private AcaoFavoritaConversor acaoFavoritaConversor;
	
	@Override
	public UsuarioDTO converterEntidadeParaDto(Usuario entidade) {
		return UsuarioDTO.builder()
		.nome(entidade.getNome())
		.login(entidade.getLogin())
		.senha(entidade.getSenha())
		.email(entidade.getEmail())
		.ativo(entidade.getAtivo())
		.build();
	}
	
	public UsuarioDTO converterEntidadeParaDto(Usuario usuario, List<AcaoFavorita> acoes) {
		return UsuarioDTO.builder()
		.nome(usuario.getNome())
		.login(usuario.getLogin())
		.senha(usuario.getSenha())
		.email(usuario.getEmail())
		.ativo(usuario.getAtivo())
		.acoesFavoritas(acaoFavoritaConversor.converterEntidadesParaDtos(acoes))
		.build();
	}

	@Override
	public Usuario converterDtoParaEntidade(UsuarioDTO dto) {
		return null;
	}

}
