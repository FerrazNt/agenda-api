package io.girhub.ferraznt.agendaapi.domain.controller;

import io.girhub.ferraznt.agendaapi.domain.entity.Contato;
import io.girhub.ferraznt.agendaapi.domain.repository.ContatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin("*")
public class ContatoController {

    private final ContatoRepository repository;

    public ContatoController(ContatoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar(@RequestBody @Valid Contato contato){
        return repository.save(contato);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping
    public List<Contato> listar(){
        return repository.findAll();
    }

    @PatchMapping("{id}/favorito")
    public void favoritar(@PathVariable Integer id , @RequestBody Boolean favorito){
        Optional<Contato> contato = repository.findById(id);

        contato.ifPresent( ct -> {
            ct.setFavorito(favorito);
            repository.save(ct);
        });

    }

}
