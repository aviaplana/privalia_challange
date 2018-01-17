package com.privalia.albert.challange.presentation.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;
import javax.inject.Singleton;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by albert on 4/05/17.
 */

@Scope
@Retention(RUNTIME)
@Singleton
public @interface AppScope {
}
