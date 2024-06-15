package com.example.demo.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.demo.entities.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Long> {

}
