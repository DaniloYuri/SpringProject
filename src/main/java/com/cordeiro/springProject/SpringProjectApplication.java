package com.cordeiro.springProject;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cordeiro.springProject.domain.Categoria;
import com.cordeiro.springProject.domain.Cidade;
import com.cordeiro.springProject.domain.Cliente;
import com.cordeiro.springProject.domain.Endereco;
import com.cordeiro.springProject.domain.Estado;
import com.cordeiro.springProject.domain.Produto;
import com.cordeiro.springProject.domain.enums.TipoCliente;
import com.cordeiro.springProject.repositorys.CategoriaRepository;
import com.cordeiro.springProject.repositorys.CidadeRepository;
import com.cordeiro.springProject.repositorys.ClienteRepository;
import com.cordeiro.springProject.repositorys.EnderecoRepository;
import com.cordeiro.springProject.repositorys.EstadoRepository;
import com.cordeiro.springProject.repositorys.ProdutoRepository;


@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	@Autowired 
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository ;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	public void run (String...args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",200.00);
		Produto p3 = new Produto(null,"Mouse",2000.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p1,p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silve", "maria@gmail.com", "36778912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("1197783574","39251178"));
		Endereco e1 = new Endereco(null,"Rua flores","300","apt 303","Jardim","332555080",cli1,c1);
		Endereco e2 = new Endereco(null,"Av Mattos","105","sala 800","Centro","223354580",cli1,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}
	
}