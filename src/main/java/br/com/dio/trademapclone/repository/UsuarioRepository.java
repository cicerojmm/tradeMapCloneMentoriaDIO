package br.com.dio.trademapclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.trademapclone.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);

}
