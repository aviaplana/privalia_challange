package com.privalia.albert.challange.data.repository;

import com.privalia.albert.challange.data.entity.MovieEntity;
import com.privalia.albert.challange.data.entity.PaginatedEntity;
import com.privalia.albert.challange.data.manager.NetworkManager;
import com.privalia.albert.challange.data.mapper.MoviePaginatedEntityDtoMapper;
import com.privalia.albert.challange.data.store.movie.MovieDataStore;
import com.privalia.albert.challange.domain.dto.MovieDto;
import com.privalia.albert.challange.domain.dto.PaginatedDto;
import com.privalia.albert.challange.domain.repository.MovieRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by albert on 19/1/18.
 */

public class MovieRepositoryImpl
        extends RepositoryImpl<MovieDataStore, MoviePaginatedEntityDtoMapper>
        implements MovieRepository {

    @Inject
    public MovieRepositoryImpl(NetworkManager networkManager, MovieDataStore movieDataStore,
                               MoviePaginatedEntityDtoMapper moviePaginatedEntityDtoMapper) {
        super(networkManager, movieDataStore, moviePaginatedEntityDtoMapper);
    }

    @Override
    public Observable<PaginatedDto<MovieDto>> getMovies(String orderBy, boolean ascendant,
                                                        int page) {

        Observable<PaginatedEntity<MovieEntity>> observableCities =
                this.dataStore.get(orderBy, ascendant, page);

        return observableCities.map(this.entityDtoMapper::map2);
    }

    @Override
    public Observable<PaginatedDto<MovieDto>> searchMovies(String query, int page) {

        Observable<PaginatedEntity<MovieEntity>> observableCities =
                this.dataStore.search(query, page);

        return observableCities.map(this.entityDtoMapper::map2);
    }
}
