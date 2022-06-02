package com.GraphQl.Dog.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String , Object> extensions=new HashMap<>();


    public BreedNotFoundException(String s, String breed) {
        super(s);
        extensions.put("invalidBreedId",breed);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.DataFetchingException;
    }
    @Override
    public Map<String,Object> getExtensions(){
        return extensions;
    }
}
