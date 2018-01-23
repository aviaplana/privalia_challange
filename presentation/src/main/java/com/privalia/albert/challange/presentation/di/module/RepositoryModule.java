package com.privalia.albert.challange.presentation.di.module;

import com.privalia.albert.challange.data.manager.NetworkManager;
import com.privalia.albert.challange.data.mapper.MoviePaginatedEntityDtoMapper;
import com.privalia.albert.challange.data.repository.MovieRepositoryImpl;
import com.privalia.albert.challange.data.store.imageConfiguration.ImageConfigurationDataStore;
import com.privalia.albert.challange.data.store.movie.MovieDataStore;
import com.privalia.albert.challange.domain.repository.MovieRepository;
import com.privalia.albert.challange.presentation.di.scope.AppScope;

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
