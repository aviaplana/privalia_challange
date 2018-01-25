package com.privalia.albert.challenge.presentation.di;

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
public interface HasComponent<C> {
    C getComponent();
}
