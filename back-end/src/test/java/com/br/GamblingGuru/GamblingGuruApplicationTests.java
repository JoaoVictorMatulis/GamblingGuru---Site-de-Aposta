package com.br.GamblingGuru;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.GamblingGuru.entities.Cliente;
import com.br.GamblingGuru.service.GamblingService;

@SpringBootTest
class GamblingGuruApplicationTests {

	@Autowired
	private GamblingService gamblingService;

	@Test
	public void testeValidarLogin() {
		// Primeiro teste
		// Email e senha correspondentes do banco de dados:
		// Resposta Esperada: Retornar um o cliente achado no banco de dados que tenha o
		// email e a senha igual ao email e senha enviado
		Cliente resultado = this.gamblingService.validarLogin("guru@gmail.com", "gurubambling");
		Assertions.assertThat(resultado.getEmail()).isEqualTo("guru@gmail.com");
		Assertions.assertThat(resultado.getSenha()).isEqualTo("gurubambling");

		// Segundo teste
		// Email correto senha errada
		// Resposta Esperada: Retornar um objeto vazio(null) pois não achou nenhum email
		// ou senha condizente com os dados enviados
		Cliente resultado2 = this.gamblingService.validarLogin("guru@gmail.com", "senhaErrada");
		Assertions.assertThat(resultado2).isNull();

		// Terceiro teste
		// Email não cadastrado no banco de dados
		// Resposta Esperada: Retornar um objeto vazio(null) pois não achou nenhum email
		// ou senha condizente com os dados enviados
		Cliente resultado3 = this.gamblingService.validarLogin("emailNãoCadastrado", "senhaErrada");
		Assertions.assertThat(resultado3).isNull();
	}

	@Test
	public void testFindbyEmail() {
		String email = "guru@gmail.com";
		Cliente resultado = this.gamblingService.findById(email);
		Assertions.assertThat(resultado.getEmail().equals(email));

	}

	@Test
	public void testLeaderboard() {
		List<Cliente> resultado = this.gamblingService.leaderboard();
		Assertions.assertThat(resultado).isNotNull();
	}

	@Test
	public void testCadastrar() {
		// Primeiro teste
		// Cadastro de um cliente não existente no banco de dados:
		// Resposta Esperada: Retornar os dados do cliente recém cadastrado
		Cliente cliente = new Cliente("paula.macedo@yahoo.com.br", "Paula Giron Macedo", "(64) 99753-7014",
				"xQ6meabI(63I");
		Cliente resultado = this.gamblingService.cadastrarCliente(cliente);
		Assertions.assertThat(resultado.getEmail()).isEqualTo(cliente.getEmail());
	}

	@Test
	public void testAtualizarCliente() {
		// Resposta Esperada: o resultado deve ser a alteração dos pontos atuais do
		// carlos@gmail.com(29394 pontos) para 1000 pontos
		Cliente cliente = new Cliente("carlos@gmail.com", "Carlos", "(43) 3945-8799", "carlos", 29394, true);
		this.gamblingService.cadastrarCliente(cliente);
		Cliente alteracao = new Cliente();
		alteracao.setPontos(1000);
		Cliente resultado = gamblingService.atualizarCliente("carlos@gmail.com", alteracao);
		System.out.println("PONTOS ATUAIS: " + resultado.getPontos());
		Assertions.assertThat(resultado.getPontos()).isEqualTo(1000);
	}

	@Test
	public void testDeletarCliente() {
		// Resposta Esperada: o resultado deve ser vazio(Null) pois o cliente informado
		// foi deletado do banco de dados
		gamblingService.deletar("fernando.souza@gmail.com");
		Cliente resultado = this.gamblingService.findById("fernando.souza@gmail.com");
		Assertions.assertThat(resultado).isNull();
	}
}
