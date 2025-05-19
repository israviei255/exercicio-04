package exercicio04.mappers;

import exercicio04.dtos.organizacoes.OrganizacaoRequestDto;
import exercicio04.dtos.organizacoes.OrganizacaoResponseDto;
import exercicio04.entities.Organizacao;

import java.util.List;

public class OrganizacaoMapper {

    private OrganizacaoMapper() {}

    public static Organizacao toEntity(Organizacao organizacao, OrganizacaoRequestDto requestDto) {
        organizacao.setNome(requestDto.nome());
        organizacao.setContato(requestDto.contato());
        return organizacao;
    }

    public static OrganizacaoResponseDto toResponseDto(Organizacao organizacao) {
        return new OrganizacaoResponseDto(
                organizacao.getId(),
                organizacao.getNome(),
                organizacao.getContato());
    }

    public static List<OrganizacaoResponseDto> toResponseDtos(List<Organizacao> organizacoes) {
        return organizacoes.stream().map(OrganizacaoMapper ::toResponseDto).toList();
    }
}
