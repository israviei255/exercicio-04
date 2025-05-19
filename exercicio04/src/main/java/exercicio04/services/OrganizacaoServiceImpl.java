package exercicio04.services;

import exercicio04.dtos.organizacoes.OrganizacaoRequestDto;
import exercicio04.dtos.organizacoes.OrganizacaoResponseDto;
import exercicio04.entities.Organizacao;
import exercicio04.mappers.OrganizacaoMapper;
import exercicio04.repositories.OrganizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizacaoServiceImpl implements OrganizacaoService {

    private final OrganizacaoRepository repository;

    OrganizacaoServiceImpl(OrganizacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrganizacaoResponseDto create(OrganizacaoRequestDto requestDto) {
        Organizacao organizacao = OrganizacaoMapper.toEntity(new Organizacao(), requestDto);
        repository.save(organizacao);
        return OrganizacaoMapper.toResponseDto(organizacao);
    }

    @Override
    public List<OrganizacaoResponseDto> findAll() {
        return OrganizacaoMapper.toResponseDtos(repository.findAll());
    }

    @Override
    public OrganizacaoResponseDto findById(Long id) {
        Optional<Organizacao> organizacaoOpt = repository.findById(id);
        if (organizacaoOpt.isPresent()) {
            Organizacao organizacao = organizacaoOpt.get();
            return OrganizacaoMapper.toResponseDto(organizacao);
        }
        return null;
    }

    @Override
    public OrganizacaoResponseDto updateById(Long id, OrganizacaoRequestDto requestDto) {
        Optional<Organizacao> organizacaoOpt = repository.findById(id);
        if (organizacaoOpt.isPresent()) {
            Organizacao organizacao = organizacaoOpt.get();
            OrganizacaoMapper.toEntity(organizacao, requestDto);
            return OrganizacaoMapper.toResponseDto(repository.save(organizacao));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Organizacao> organizacaoOpt = repository.findById(id);
        if (organizacaoOpt.isPresent()) {
            Organizacao organizacao = organizacaoOpt.get();
            repository.delete(organizacao);
        }
    }
}
