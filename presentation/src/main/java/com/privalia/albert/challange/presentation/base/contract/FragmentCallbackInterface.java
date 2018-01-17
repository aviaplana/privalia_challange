package com.privalia.albert.challange.presentation.base.contract;

/**
 * Created by albert on 25/12/17.
 */

public interface FragmentCallbackInterface {

    void onFragmentAttached();

    void onFragmentDetached(String tag);
}