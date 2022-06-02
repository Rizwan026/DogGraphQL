package com.GraphQl.Dog.mutator;

import com.GraphQl.Dog.Entity.Dog;
import com.GraphQl.Dog.Repository.DogRepository;
import com.GraphQl.Dog.exception.BreedNotFoundException;
import com.GraphQl.Dog.exception.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    public boolean deleteDogBreed(String breed){
        Iterable<Dog> dogIterable=dogRepository.findAll();
        Boolean delete=false;
        for(Dog d:dogIterable){
            if(d.getBreed().equals(breed)){
                dogRepository.deleteById(Long.valueOf(d.getId()));
                delete=true;
            }
        }
        if(!delete) throw new BreedNotFoundException("breed not found:", breed);
        return delete;
    }

    public Dog updateDogName(String name,Integer id){
        Optional<Dog> optionalDog=dogRepository.findById(id.longValue());

        if(optionalDog.isPresent()){
            Dog d=optionalDog.get();
            d.setName(name);
            dogRepository.save(d);
            return d;
        }
        else throw new DogNotFoundException("Dog Not Found:",Long.valueOf(id));
    }
}
