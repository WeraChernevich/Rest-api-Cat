package ru.chernevich.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.chernevich.demo.dto.CatDto;
import ru.chernevich.demo.entity.Cat;
import ru.chernevich.demo.repository.CatRepo;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;

    @Operation(
            summary = "кладет нового котика в базу",
            description = "получает DTO кота и билдером собирает и сохраняет сущность в базу"
    )
    @PostMapping("/api/add")
    public void changeCat(@RequestBody CatDto catDto) {
        log.info( "New row: " + catRepo.save(Cat.builder()
                .age(catDto.getAge())
                .weight(catDto.getWeight())
                .name(catDto.getName())
                .build())
        );
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll() {
        List<Cat> cats = catRepo.findAll();
        return catRepo.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }

    @PutMapping("/api/change")
    public String addCat(@RequestBody Cat cat) {
        if(!catRepo.existsById(cat.getId())) {
            return "Now such row";
        }
         return catRepo.save(cat).toString();
    }

}
