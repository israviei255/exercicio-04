package exercicio04.controllers;

import exercicio04.dtos.organizacoes.OrganizacaoRequestDto;
import exercicio04.dtos.organizacoes.OrganizacaoResponseDto;
import exercicio04.services.OrganizacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizacoes")
public class OrganizacaoController {

    private final OrganizacaoService service;

    OrganizacaoController(OrganizacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizacaoResponseDto post(@RequestBody OrganizacaoRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizacaoResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizacaoResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizacaoResponseDto putById(@PathVariable Long id,
                                          @RequestBody OrganizacaoRequestDto dto) {
        return service.updateById(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
