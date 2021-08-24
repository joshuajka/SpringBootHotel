package br.ufg.inf.fs.business;

import br.ufg.inf.fs.repositories.HospedeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ufg.inf.fs.entities.Hospede;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeBusiness {
    @Autowired
    HospedeRepository repository;

    public List<Hospede> findAll() {
        return this.repository.findAll();
    }

    public Hospede findById(Integer id) {
        Optional<Hospede> optHospede = this.repository.findById(id);
        Hospede hospede = optHospede.get();
        return hospede;
    }

    public Hospede insert(Hospede hospede) {

        return this.repository.save(hospede);
    }

    public Hospede update(Hospede hospede) {
        return this.repository.save(hospede);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
