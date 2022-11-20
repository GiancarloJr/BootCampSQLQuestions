package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

        @Query(nativeQuery = true, value = "select empregados.cpf, empregados.enome,departamentos.dnome from empregados " +
                "inner join departamentos ON empregados.dnumero = departamentos.dnumero " +
                "where empregados.cpf not in (select empregados.cpf from empregados inner join trabalha ON trabalha.cpf_emp = empregados.cpf) " +
                "order by empregados.cpf")
        List<EmpregadoDeptProjection> search1();

}
