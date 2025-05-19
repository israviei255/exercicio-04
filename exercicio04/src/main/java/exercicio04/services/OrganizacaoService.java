package exercicio04.services;

import exercicio04.dtos.organizacoes.OrganizacaoRequestDto;
import exercicio04.dtos.organizacoes.OrganizacaoResponseDto;

import java.util.List;

public interface OrganizacaoService {

    OrganizacaoResponseDto create(OrganizacaoRequestDto requestDto);
    List<OrganizacaoResponseDto> findAll();
    OrganizacaoResponseDto findById(Long id);
    OrganizacaoResponseDto updateById(Long id, OrganizacaoRequestDto requestDto);
    void deleteById(Long id);
}
