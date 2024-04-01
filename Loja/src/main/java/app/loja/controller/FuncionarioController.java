package app.loja.controller;

import app.loja.entity.Funcionario;
import app.loja.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Funcionario funcionario) {

        try {
            String salvar = this.funcionarioService.save(funcionario);
            return new ResponseEntity<>(salvar, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Funcionario funcionario) {

        try {

            String alterar = this.funcionarioService.update(id, funcionario);
            return new ResponseEntity<>(alterar, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Funcionario>> listAll() {

        try {

            List<Funcionario> lista = this.funcionarioService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id) {

        try {

            Funcionario funcionario = this.funcionarioService.findById(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {

        try {

            String deletar = this.funcionarioService.delete(id);
            return new ResponseEntity<>(deletar, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Funcionario>> findByNome(@RequestParam String nome) {

        try {

            List<Funcionario> funcionario = this.funcionarioService.findByNome(nome);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findByIdade")
    public ResponseEntity<List<Funcionario>> findByIdade(@RequestParam int idade) {

        try {

            List<Funcionario> funcionario = this.funcionarioService.findByIdade(idade);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findByMatricula")
    public ResponseEntity<List<Funcionario>> findByMatricula(@RequestParam int matricula) {

        try {

            List<Funcionario> funcionario = this.funcionarioService.findByMatricula(matricula);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}