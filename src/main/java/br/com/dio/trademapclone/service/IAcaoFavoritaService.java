package br.com.dio.trademapclone.service;

import java.util.List;

import br.com.dio.trademapclone.dto.AcaoFavoritaDTO;
import br.com.dio.trademapclone.modelo.AcaoFavorita;
import br.com.dio.trademapclone.modelo.Usuario;

public interface IAcaoFavoritaService {

	AcaoFavorita salvar(AcaoFavorita acaoFavorita);

	AcaoFavoritaDTO salvar(AcaoFavoritaDTO acaoFavoritaDTO);

	List<AcaoFavorita> listar(Usuario usuario);

	List<AcaoFavorita> listarSemDuplicidade();
}
