package com.privalia.albert.challange.presentation.ui.activity;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.privalia.albert.challange.presentation.ui.contract.FragmentCallbackInterface;
import com.privalia.albert.challange.presentation.ui.viewModel.BaseViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity<VIEWDATABINDING extends ViewDataBinding,
                                    VIEWMODEL extends BaseViewModel>
        extends DaggerAppCompatActivity
        implements FragmentCallbackInterface {

    // TODO
    // this can probably depend on isLoading variable of BaseViewModel,
    // since its going to be common for all the activities
    private ProgressDialog progressDialog;

    private VIEWDATABINDING viewDataBinding;

    @Inject
    protected VIEWMODEL viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    private void performDataBinding() {
        this.viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = this.viewModel == null ? getViewModel() : this.viewModel;
        this.viewDataBinding.setVariable(getBindingVariable(), this.viewModel);
        this.viewDataBinding.executePendingBindings();
    }

    /*
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showLoading() {
        hideLoading();
        //mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    public void hideLoading() {
        if (this.progressDialog != null && this.progressDialog.isShowing()) {
            this.progressDialog.cancel();
        }
    }

    public VIEWDATABINDING getViewDataBinding() {
        return this.viewDataBinding;
    }

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract VIEWMODEL getViewModel();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

}

