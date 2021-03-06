package com.example.projetoambev.repository;

import com.example.projetoambev.model.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel,Long> {



    boolean existsByCPF(String cpf);
}