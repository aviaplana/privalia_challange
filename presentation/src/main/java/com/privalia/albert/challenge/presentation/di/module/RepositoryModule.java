package com.privalia.albert.challenge.presentation.di.module;

import com.privalia.albert.challenge.data.manager.NetworkManager;
import com.privalia.albert.challenge.data.mapper.MoviePaginatedEntityDtoMapper;
import com.privalia.albert.challenge.data.repository.MovieRepositoryImpl;
import com.privalia.albert.challenge.data.store.imageConfiguration.ImageConfigurationDataStore;
import com.privalia.albert.challenge.data.store.movie.MovieDataStore;
import com.privalia.albert.challenge.domain.repository.MovieRepository;
import com.privalia.albert.challenge.presentation.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 5/05/17.
 */

@Module
public class RepositoryModule {


    @Provides
    @AppScope
    MovieRepository provideMovieRepository(NetworkManager networkManager,
                                       MovieDataStore movieDataStore,
                                       ImageConfigurationDataStore imageConfigurationDataStore,
                                       MoviePaginatedEntityDtoMapper moviePaginatedEntityDtoMapper){

        return new MovieRepositoryImpl(networkManager, movieDataStore, imageConfigurationDataStore,
                                        moviePaginatedEntityDtoMapper);
    }
}
