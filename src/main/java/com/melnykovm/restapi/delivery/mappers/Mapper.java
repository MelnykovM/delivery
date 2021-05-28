package com.melnykovm.restapi.delivery.mappers;

public interface Mapper<E, M> {

    E toEntity(M model);

    M toModel(E entity);
}
