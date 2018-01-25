package com.privalia.albert.challenge.data.repository;

import com.privalia.albert.challenge.data.entity.MovieEntity;
import com.privalia.albert.challenge.data.entity.PaginatedEntity;
import com.privalia.albert.challenge.data.manager.NetworkManager;
import com.privalia.albert.challenge.data.mapper.MoviePaginatedEntityDtoMapper;
import com.privalia.albert.challenge.data.store.imageConfiguration.ImageConfigurationDataStore;
import com.privalia.albert.challenge.data.store.movie.MovieDataStore;
import com.privalia.albert.challenge.domain.dto.MovieDto;
import com.privalia.albert.challenge.domain.dto.PaginatedDto;
import com.privalia.albert.challenge.domain.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by albert on 19/1/18.
 */

public class MovieRepositoryImpl
        extends RepositoryImpl<MovieDataStore, MoviePaginatedEntityDtoMapper>
        implements MovieRepository {

    public static String baseImageUrl;
    private ImageConfigurationDataStore imageConfigurationDataStore;

    @Inject
    public MovieRepositoryImpl(NetworkManager networkManager, MovieDataStore movieDataStore,
                               ImageConfigurationDataStore imageConfigurationDataStore,
                               MoviePaginatedEntityDtoMapper moviePaginatedEntityDtoMapper) {
        super(networkManager, movieDataStore, moviePaginatedEntityDtoMapper);
        this.imageConfigurationDataStore = imageConfigurationDataStore;
    }

    @Override
    public Observable<PaginatedDto<MovieDto>> getMovies(String orderBy, boolean ascendant,
                                                        int page) {

        Observable<PaginatedEntity<MovieEntity>> observableMovies =
                this.dataStore.get(orderBy, ascendant, page);

        if (baseImageUrl == null || baseImageUrl.isEmpty()) {
            observableMovies = getImageBaseUrl(observableMovies);
        }


        return addBaseUrlToPosterPath(observableMovies).map(this.entityDtoMapper::map2);
    }

    @Override
    public Observable<PaginatedDto<MovieDto>> searchMovies(String query, int page) {

        Observable<PaginatedEntity<MovieEntity>> observableMovies =
                this.dataStore.search(query, page);

        if (baseImageUrl == null || baseImageUrl.isEmpty()) {
            observableMovies = getImageBaseUrl(observableMovies);
        }

        return addBaseUrlToPosterPath(observableMovies).map(this.entityDtoMapper::map2);
    }

    private Observable<PaginatedEntity<MovieEntity>> addBaseUrlToPosterPath(
                                            Observable<PaginatedEntity<MovieEntity>> observable) {
        return observable.map(paginatedMovieEntity -> {

            for (MovieEntity movieEntity: paginatedMovieEntity.getResults()) {
                String posterPath = movieEntity.getPosterPath();

                if (posterPath != null && !posterPath.isEmpty()) {
                    movieEntity.setPosterPath(baseImageUrl + posterPath);
                }
            }

            return paginatedMovieEntity;
        });
    }

    private Observable<PaginatedEntity<MovieEntity>> getImageBaseUrl(
                                            Observable<PaginatedEntity<MovieEntity>> observable) {

        return this.imageConfigurationDataStore.get().flatMap(imageConfiguration -> {
            List<String> posterSizes = imageConfiguration.getPosterSizes();

            if (posterSizes != null && !posterSizes.isEmpty()) {
                // The smallest size
                String size = posterSizes.get(0);

                this.baseImageUrl = imageConfiguration.getSecureBaseUrl() + size;
            }

            return observable;
        });
    }
}
