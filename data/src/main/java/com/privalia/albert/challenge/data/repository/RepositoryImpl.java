package com.privalia.albert.challenge.data.repository;

import com.privalia.albert.challenge.data.manager.NetworkManager;
import com.privalia.albert.challenge.data.mapper.BaseMapper;
import com.privalia.albert.challenge.data.store.datasource.DataSource;
import com.privalia.albert.challenge.domain.interactor.UseCase;
import com.privalia.albert.challenge.domain.repository.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by albert on 7/1/18.
 */

public abstract class RepositoryImpl
        <DATA_STORE extends DataSource, ENTITY_DTO_MAPPER extends BaseMapper>
        implements Repository {

    protected NetworkManager networkManager;

    protected DATA_STORE dataStore;

    protected ENTITY_DTO_MAPPER entityDtoMapper;

    protected final Map<String, UseCase> useCasesMap = new HashMap<>();

    public RepositoryImpl(NetworkManager networkManager,
                          DATA_STORE dataStore,
                          ENTITY_DTO_MAPPER entityDtoMapper) {
        this.networkManager = networkManager;
        this.dataStore = dataStore;
        this.entityDtoMapper = entityDtoMapper;
    }
}