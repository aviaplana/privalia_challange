package com.privalia.albert.challenge.presentation.ui.viewModel;

/**
 * Created by albert on 31/12/17.
 */

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
public class ViewModelProviderFactory<V> implements ViewModelProvider.Factory {

    private V viewModel;

    public ViewModelProviderFactory(V viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(viewModel.getClass())) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }

}
