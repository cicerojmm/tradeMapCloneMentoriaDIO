package br.com.dio.trademapclone.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.trademapclone.dto.AcaoFavoritaDTO;
import br.com.dio.trademapclone.modelo.AcaoFavorita;
import br.com.dio.trademapclone.service.IUsuarioService;

@Service
public class AcaoFavoritaConversor extends ConversorBase<AcaoFavorita, AcaoFavoritaDTO> {

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public AcaoFavoritaDTO converterEntidadeParaDto(AcaoFavorita entidade) {
		return AcaoFavoritaDTO.builder().codigo(entidade.getCodigo()).build();
	}

	@Override
	public AcaoFavorita converterDtoParaEntidade(AcaoFavoritaDTO dto) {
		return AcaoFavorita
		.builder()
		.codigo(dto.getCodigo())
		.usuario(usuarioService.consultarEntidade(dto.getLoginUsuario()))
		.build();
	}

}
