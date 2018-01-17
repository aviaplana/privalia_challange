package com.privalia.albert.challange.presentation.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by albert on 9/05/17.
 */

@Scope
@Retention(RUNTIME)
public @interface UseCase {
}

