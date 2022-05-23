package one.FelipeRoberto.gof.service.impl;

import one.FelipeRoberto.gof.model.Cliente;
import one.FelipeRoberto.gof.model.ClienteRepository;
import one.FelipeRoberto.gof.model.Endereco;
import one.FelipeRoberto.gof.model.EnderecoRepository;
import one.FelipeRoberto.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.FelipeRoberto.gof.service.ViaCepService;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy e  Facade

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Clientes por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Clientes por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
