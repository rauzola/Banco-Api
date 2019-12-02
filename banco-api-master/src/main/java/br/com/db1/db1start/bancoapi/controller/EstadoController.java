package br.com.db1.db1start.bancoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.db1.db1start.bancoapi.service.EstadoService;
import br.com.db1.db1start.bancoapi.adapter.EstadoAdapter;
import br.com.db1.db1start.bancoapi.dto.EstadoDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoFormDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;

public class EstadoController {

	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping ("/estados")
	public List<EstadoDTO> buscarTodosEstados() {
		List<Estado> estados = estadoService.buscarTodos();
		List<EstadoDTO> listaDeRetorno = new ArrayList<>();
		
		estados.forEach(estado ->{
			EstadoDTO meuEstadoDto = EstadoAdapter.transformaEntidadeParaDTO(estado);
			listaDeRetorno.add(meuEstadoDto);
		});
		
		
		
		
		return listaDeRetorno;
				
	}
	
	@PostMapping("/estados")
	public void cadastrarNovoEstado (@RequestBody EstadoFormDTO form) {
		
		estadoService.criar(form.getNome());
		
	}
	
}
