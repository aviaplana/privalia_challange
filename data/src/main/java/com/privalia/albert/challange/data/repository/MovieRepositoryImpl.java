package com.privalia.albert.challange.data.repository;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.manager.NetworkManager;
import com.privalia.albert.challange.data.mapper.MovieEntityDtoMapper;
import com.privalia.albert.challange.data.store.movie.MovieDataStore;
import com.privalia.albert.challange.domain.dto.MovieDto;
import com.privalia.albert.challange.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by albert on 19/1/18.
 */

public class MovieRepositoryImpl
        extends RepositoryImpl<MovieDataStore, MovieEntityDtoMapper>
        implements MovieRepository {

    @Inject
    public MovieRepositoryImpl(NetworkManager networkManager, MovieDataStore movieDataStore,
                              MovieEntityDtoMapper movieEntityDtoMapper) {
        super(networkManager, movieDataStore, movieEntityDtoMapper);
    }
    @Override
    public Observable<List<MovieDto>> getMovies(String orderBy, int page) {
        Observable<List<MovieEntity>> observableCities = this.dataStore.get(orderBy, page);


        return observableCities.map(this.entityDtoMapper::map2);
    }
}
