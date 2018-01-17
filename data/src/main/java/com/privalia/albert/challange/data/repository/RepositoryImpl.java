package com.privalia.albert.challange.data.repository;

import com.privalia.albert.challange.data.manager.NetworkManager;
import com.privalia.albert.challange.data.mapper.BaseMapper;
import com.privalia.albert.challange.data.store.datasource.Cache;
import com.privalia.albert.challange.data.store.datasource.DataSource;
import com.privalia.albert.challange.domain.interactor.UseCase;
import com.privalia.albert.challange.domain.repository.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by albert on 7/1/18.
 */

public abstract class RepositoryImpl
        <DATA_STORE extends DataSource,
                CACHE extends Cache,
                ENTITY_DTO_MAPPER extends BaseMapper> implements Repository {

    protected NetworkManager mNetworkManager;

    protected DATA_STORE mDataStore;

    protected CACHE mCache;

    protected ENTITY_DTO_MAPPER mEntityDtoMapper;

    protected final Map<String, UseCase> mUseCasesMap = new HashMap<>();

    public RepositoryImpl(NetworkManager networkManager,
                          DATA_STORE dataStore,
                          CACHE cache,
                          ENTITY_DTO_MAPPER entityDtoMapper) {
        mNetworkManager = networkManager;
        mDataStore = dataStore;
        mCache = cache;
        mEntityDtoMapper = entityDtoMapper;
    }
}