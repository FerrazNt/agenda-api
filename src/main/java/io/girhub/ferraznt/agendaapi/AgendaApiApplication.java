package io.girhub.ferraznt.agendaapi;

import io.girhub.ferraznt.agendaapi.domain.entity.Contato;
import io.girhub.ferraznt.agendaapi.domain.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendaApiApplication {


	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ContatoRepository cr){
		return args -> {
			Contato contato = new Contato();
			contato.setNome("Maria");
			contato.setEmail("maria@maira.com");
			contato.setFavorito(true);

			cr.save(contato);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}

}
