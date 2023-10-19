package com.residencia.biblioteca.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.EditoraDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepo;
	
	@Autowired
	EmailService emailService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<Editora> listarEditoras(){
		return editoraRepo.findAll();
	}
	
	public Editora buscarEditoraPorId(Integer id) {
		return editoraRepo.findById(id).orElse(null);
	}
	
	public Editora salvarEditora(Editora editora) {
		return editoraRepo.save(editora);
	}
	
	private EditoraDTO entityToDto(Editora editora) {
		EditoraDTO editoraDto = new EditoraDTO();
		editoraDto.setCodigoEditora(editora.getCodigoEditora());
		editoraDto.setNome(editora.getNome());
		editoraDto.setImagemFileName(editora.getImagemFileName());
		editoraDto.setImagemNome(editora.getImagemNome());
		editoraDto.setImagemUrl(editora.getImagemUrl());
		
		return editoraDto;
	}
	
	private EditoraDTO entityToDtoWMapper(Editora editora) {
		EditoraDTO editoraDto = modelMapper.map(editora, EditoraDTO.class);
		return editoraDto;
	}
	
	private Editora dtoToEntityWMapper(EditoraDTO editoraDTO) {
		Editora editora = modelMapper.map(editoraDTO, Editora.class);
		return editora;
	}
	
	private Editora dtoToEntity(EditoraDTO editoraDTO) {
		Editora editora = new Editora();
		
		editora.setNome(editoraDTO.getNome());
		editora.setImagemFileName(editoraDTO.getImagemFileName());
		editora.setImagemNome(editoraDTO.getImagemNome());
		editora.setImagemUrl(editoraDTO.getImagemUrl());
		
		return editora;
	}
	
	public EditoraDTO salvarEditoraDTO(EditoraDTO editoraDTO) {
		Editora editora = dtoToEntity(editoraDTO);
		EditoraDTO novaEditoraDto = entityToDto(editoraRepo.save(editora));
		
		return novaEditoraDto;
	}
	
	public Editora atualizarEditora(Editora editora) {
		return editoraRepo.save(editora);
	}
	
	public Boolean deletarEditora(Editora editora) {
		if(editora == null)
			return false;
		
		Editora editoraExistente = buscarEditoraPorId(editora.getCodigoEditora());
		
		if(editoraExistente == null)
			return false;
		
		editoraRepo.delete(editora);
		
		Editora editoraContinuaExistindo = 
				buscarEditoraPorId(editora.getCodigoEditora());
		
		if(editoraContinuaExistindo == null)
			return true;

		return false;	
	}
	
}
