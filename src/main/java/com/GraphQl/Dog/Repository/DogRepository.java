package com.GraphQl.Dog.Repository;

import com.GraphQl.Dog.Entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {
}
