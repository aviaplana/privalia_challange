package com.privalia.albert.challange.presentation.ui.viewModel;

import android.databinding.ObservableField;

import com.privalia.albert.challange.presentation.base.BaseViewModel;
import com.privalia.albert.challange.presentation.ui.navigator.MainNavigator;

import javax.inject.Inject;

/**
 * Created by albert on 26/12/17.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {

    private final ObservableField<String> appVersion = new ObservableField<>();

    @Inject
    public MainViewModel() {
        super();
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

}
