package exercicio04.controllers;

import exercicio04.dtos.usuarios.UsuarioRequestDto;
import exercicio04.dtos.usuarios.UsuarioResponseDto;
import exercicio04.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDto post(@RequestBody UsuarioRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponseDto putById(@PathVariable Long id,
                                      @RequestBody UsuarioRequestDto dto) {
        return service.updateById(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
