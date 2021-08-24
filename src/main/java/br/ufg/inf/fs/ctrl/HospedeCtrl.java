package br.ufg.inf.fs.ctrl;

import java.util.List;

import br.ufg.inf.fs.business.HospedeBusiness;
import br.ufg.inf.fs.entities.Hospede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hospede")
public class HospedeCtrl {

    @Autowired
    HospedeBusiness business;

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll() {
        List<Hospede> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id) {
        Hospede hospede = business.findById(id);
        return ResponseEntity.ok(hospede);
    }

    @PostMapping
    public ResponseEntity<Hospede> insert(@RequestBody Hospede h) {
        Hospede insertedHospedagem = this.business.insert(h);
        return ResponseEntity.status(201).body(insertedHospedagem);
    }

    // @PostMapping
    // public String insert(@RequestBody Hospede h) {

    // System.out.println(h);
    // return "Deu bom";
    // }

    @PutMapping
    public ResponseEntity<Hospede> update(@RequestBody Hospede h) {
        Hospede updatedHospede = this.business.insert(h);
        return ResponseEntity.status(201).body(updatedHospede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
