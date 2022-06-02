package com.GraphQl.Dog.Resolver;

import com.GraphQl.Dog.Entity.Dog;
import com.GraphQl.Dog.Repository.DogRepository;
import com.GraphQl.Dog.exception.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }
    public Dog findDogById(Long id){
        Optional<Dog> optionalDog=dogRepository.findById(id);
        if(optionalDog.isPresent()){
            return optionalDog.get();
        }
        else {
            throw new DogNotFoundException("Dog not found:", id);
        }
    }
}
;