package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private Map<Long, Time> colecaoTimes = new HashMap<>();
	private Map<Long, Jogador> colecaoJogadores = new TreeMap<>();

	@Desafio("incluirTime")//OK
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {

		this.isIdentificadorExiste(this.colecaoTimes, id);

		this.colecaoTimes.put(id, new Time(id, nome, corUniformePrincipal, corUniformeSecundario, dataCriacao));
	}

	@Desafio("incluirJogador")//OK
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {

		this.isIdentificadorExiste(colecaoJogadores, id);

		this.isTimeExiste(idTime);

		this.colecaoJogadores.put(id, new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")//OK
	public void definirCapitao(Long idJogador) {

		// Identifica o jogador pelo ID Recebido
		Jogador jogador = new Jogador();
		jogador = this.isJogadorExiste(idJogador);

		// Identifica o Time que o jogador faz parte
		Time time = new Time();
		time = this.colecaoTimes.get(jogador.getIdTime());

		// Atualiza o time com o novo capit�o
		time.setIdCapitaoTime(idJogador);

		// Atualiza a cole��o de times com o capit�o do time em quest�o
		this.colecaoTimes.put(jogador.getIdTime(), time);
	}

	@Desafio("buscarCapitaoDoTime")//OK
	public Long buscarCapitaoDoTime(Long idTime) {


		Time time = this.isTimeExiste(idTime);

		if (time.getIdCapitaoTime() == null) {

			throw new CapitaoNaoInformadoException();
			
		} else {

			return time.getIdCapitaoTime();
		}
	}

	@Desafio("buscarNomeJogador")//OK
	public String buscarNomeJogador(Long idJogador) {

		Jogador jogador = this.isJogadorExiste(idJogador);
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")//OK
	public String buscarNomeTime(Long idTime) {

		Time time = this.isTimeExiste(idTime);
		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")//ok
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		this.isTimeExiste(idTime);

		List<Jogador> jogadores = new ArrayList<>(this.colecaoJogadores.values()).stream()
				.filter(grupoJogadores -> grupoJogadores.getIdTime().equals(idTime)).collect(Collectors.toList());
		return jogadores.stream().map(Jogador::getId).collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")//OK
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		this.isTimeExiste(idTime);

		Jogador jogadorSelecionado = new ArrayList<>(this.colecaoJogadores.values()).stream()
				.filter(grupoJogadores -> grupoJogadores.getIdTime().equals(idTime))
				.max(Comparator.comparing(Jogador::getNivelHabilidade)).get();
		return jogadorSelecionado.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		/*this.isTimeExiste(idTime);

		Jogador jogadorSelecionado = new ArrayList<>(this.colecaoJogadores.values()).stream()
				.filter(grupoJogadores -> grupoJogadores.getId().equals(idTime))
				.min(Comparator.comparing(Jogador::getDataNascimento)).get();

		return jogadorSelecionado.getId();*/

		return null;
	}

	@Desafio("buscarTimes") // OK
	public List<Long> buscarTimes() {

		if (this.colecaoTimes.isEmpty() || this.colecaoTimes.size() == 0) {

			return new ArrayList<>();

		} else {

			return new ArrayList<>(this.colecaoTimes.keySet()).stream().sorted().collect(Collectors.toList());
		}
	}

	@Desafio("buscarJogadorMaiorSalario")//OK
	public Long buscarJogadorMaiorSalario(Long idTime) {

		this.isTimeExiste(idTime);

		Jogador colecaoMaiorSalario = new ArrayList<>(this.colecaoJogadores.values()).stream()
				.filter(grupoJogadores -> grupoJogadores.getIdTime().equals(idTime))
				.max(Comparator.comparing(Jogador::getSalario)).get();

		Jogador jogadorMaiorSalario = new ArrayList<>(this.colecaoJogadores.values()).stream()
				.filter(grupoJogadores -> grupoJogadores.getIdTime().equals(idTime)
						&& grupoJogadores.getSalario().compareTo(colecaoMaiorSalario.getSalario()) == 0)
				.min(Comparator.comparing(Jogador::getId)).get();

		return jogadorMaiorSalario.getId();
	}

	@Desafio("buscarSalarioDoJogador") //OK
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		Jogador jogador = isJogadorExiste(idJogador);

		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		/*if (this.colecaoJogadores.isEmpty() || this.colecaoJogadores.size() == 0) {
			return new ArrayList<>();
		}

		List<Jogador> listaJogadores = new ArrayList<>(this.colecaoJogadores.values()).stream()
				.filter(grupoJogadores -> grupoJogadores.getNivelHabilidade().equals(top))
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()).collect(Collectors.toList());

		return listaJogadores.stream().map(Jogador::getId).collect(Collectors.toList());*/

		return null;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Time timeCasa = this.colecaoTimes.get(timeDaCasa);
		Time timeVisitante = this.colecaoTimes.get(timeDeFora);

		if (timeCasa.getCorUniformePrincipal().equals(timeVisitante.getCorUniformePrincipal())) {

			return timeVisitante.getCorUniformeSecundario();
		}

		return timeVisitante.getCorUniformePrincipal();
	}

	/**
	 * - Verifca se o time existe na colecao de times
	 * 
	 * @param idTime
	 * @return
	 */
	private Time isTimeExiste(Long idTime) {

		if (!colecaoTimes.containsKey(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		return colecaoTimes.get(idTime);
	}

	/**
	 * - Verifca se o jogador existe na colecao de jogadores
	 * 
	 * @param idJogador
	 * @return
	 */
	private Jogador isJogadorExiste(Long idJogador) {

		if (!this.colecaoJogadores.containsKey(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}

		return this.colecaoJogadores.get(idJogador);
	}

	/**
	 * - Verifca se o ID Identificador Existe
	 * 
	 * @param pColecao
	 * @param pId
	 */
	private void isIdentificadorExiste(Map<Long, ?> pColecao, Long pId) {

		if (pColecao.containsKey(pId)) {
			throw new IdentificadorUtilizadoException();
		}
	}
}


