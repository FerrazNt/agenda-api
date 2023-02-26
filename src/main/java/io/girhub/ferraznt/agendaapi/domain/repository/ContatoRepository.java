package io.girhub.ferraznt.agendaapi.domain.repository;


import io.girhub.ferraznt.agendaapi.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
