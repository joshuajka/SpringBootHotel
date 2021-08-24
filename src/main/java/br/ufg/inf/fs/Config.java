package br.ufg.inf.fs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import br.ufg.inf.fs.repositories.HospedeRepository;
import br.ufg.inf.fs.repositories.HotelRepository;
import br.ufg.inf.fs.repositories.QuartoRepository;

@Configuration
@Profile("dev")
public class Config  implements CommandLineRunner{

	@Autowired
	private HotelRepository hoteRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */
		
		Hotel h1 = new Hotel(null, "Calderão Furado", "Beco Diagonal", 3);
		Hotel h2 = new Hotel(null, "Bates Hotel", "White Pine Bay", 2);
		Hotel h3 = new Hotel(null, "Hotel Overlook", "Colorado", 4);
		Hotel h4 = new Hotel(null, "Continental Hotel", "Ney York City", 5);
		
		h1 = hoteRepository.save(h1);
		h2 = hoteRepository.save(h2);
		h3 = hoteRepository.save(h3);
		h4 = hoteRepository.save(h4);
		
		Quarto q1 = quartoRepository.save(new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0));
		Quarto q2 = quartoRepository.save(new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0));
		Quarto q3 = quartoRepository.save(new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0));
		Quarto q4 = quartoRepository.save(new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0));
		
		Date checkin = new Date(2021,20,8);
		Date checkout = new Date(2021,25,8);
		
		Hospedagem hg1 = new Hospedagem(1,1,1,checkin,checkout);
		Hospedagem hg2 = new Hospedagem(1,1,1,checkin,checkout);
		Hospedagem hg3 = new Hospedagem(1,1,1,checkin,checkout);
		Hospedagem hg4 = new Hospedagem(1,1,1,checkin,checkout); 
		
		hg1 = hospedagemRepository.save(hg1);
		hg2 = hospedagemRepository.save(hg2);
		hg3 = hospedagemRepository.save(hg3);
		hg4 = hospedagemRepository.save(hg4); 
		
		Date data = new Date(1980,4,16);
		
		
		Hospede hh1 = new Hospede(null, "Joao",data,2135648);
		Hospede hh2 = new Hospede(null, "Maria",data,2125648);
		Hospede hh3 = new Hospede(null, "Duda",data,2145648);
		Hospede hh4 = new Hospede(null, "Dudu",data,2155648); 
		
		hh1 = hospedeRepository.save(hh1);
		hh2 = hospedeRepository.save(hh2);
		hh3 = hospedeRepository.save(hh3);
		hh4 = hospedeRepository.save(hh4);
		
	}

}
