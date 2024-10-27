package ru.chernevich.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chernevich.demo.entity.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {
}
