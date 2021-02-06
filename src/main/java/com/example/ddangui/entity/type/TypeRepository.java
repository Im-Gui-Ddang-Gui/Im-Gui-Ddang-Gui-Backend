package com.example.ddangui.entity.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {

}
