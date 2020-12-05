package br.com.dio.trademapclone.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIOS")
public class Usuario extends EntidadeBase {

	@Column(name = "USU_LOGIN", nullable = false)
	private String login;

	@Column(name = "USU_SENHA", nullable = false)
	private String senha;

	@Column(name = "USU_EMAIL", nullable = false)
	private String email;

	@Column(name = "USU_NOME", nullable = false)
	private String nome;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<AcaoFavorita> acoesFavoritas;

	@Column(name = "USU_ATIVO", nullable = false)
	private Boolean ativo;

}
