package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.exceptions.NoSuchElementException;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepo;
	
	public List<Aluno> listarAlunos(){
		return alunoRepo.findAll();
	}
	
	public List<AlunoResumidoDTO> listarAlunosResumidos(){
		List<Aluno> alunos = alunoRepo.findAll();
		List<AlunoResumidoDTO> alunosDTO = new ArrayList<>();
	
		for(Aluno aluno : alunos) {
			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
			alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			alunoResDTO.setNome(aluno.getNome());
			alunoResDTO.setCpf(aluno.getCpf());
			
			alunosDTO.add(alunoResDTO);
		}
		return alunosDTO;
	}
	
	public Aluno buscarAlunoPorId(Integer id) {
		//return alunoRepo.findById(id).get();
		
		/*
		 * Aluno alunoBanco = (alunoRepo.findById(id).isPresent()) ? alunoRepo.findById(id).get() : null;
		 * return alunoBanco; 
		 */
		
		/*
		if(alunoRepo.findById(id).isPresent())
			return alunoBanco.get();
		else
			return null;
		 */
		
		/*
		Optional<Aluno> alunoBanco = alunoRepo.findById(id);
		if(alunoBanco.isPresent())
			return alunoBanco.get();
		else
			return null;
		 */
		
		//return alunoRepo.findById(id).orElse(null);
		/*
		return alunoRepo.findById(id)
				.orElseThrow(() -> new AlunoNotFoundException(id));
		*/		
		
		return alunoRepo.findById(id)
		        .orElseThrow(() -> new NoSuchElementException("Aluno", id));
		        
	}
	
	public AlunoResumidoDTO getAlunoResumidoPorId(Integer id) {
		 Aluno aluno = alunoRepo.findById(id).orElse(null);
		 
		 if(aluno != null) {
			 AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO(
					 aluno.getNumeroMatriculaAluno(),
					 aluno.getNome(),
					 aluno.getCpf()
					 );
			 
			 //alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			 //alunoResDTO.setNome(aluno.getNome());
			 //alunoResDTO.setCpf(aluno.getCpf());
			 return alunoResDTO;
		 }
		 
		 return null;
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	/*
	public void deletarAlunoPorId(Integer id) {
		if(id == null)
			return null;
		
		Aluno aluno = buscarAlunoPorId(id);
		
		if(aluno == null)
			return null;
		
		alunoRepo.deleteById(id);
		
		//...
	}
	*/
	

	public Boolean deletarAluno(Aluno aluno) {
		if(aluno == null)
			return false;
		
		Aluno alunoExistente = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoExistente == null)
			return false;
		
		alunoRepo.delete(aluno);
		
		Aluno alunoContinuaExistindo = 
				buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoContinuaExistindo == null)
			return true;

		return false;
	}
	
}
