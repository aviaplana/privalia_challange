package com.privalia.albert.challange.presentation.ui.handler;

import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by albert on 24/1/18.
 */

public interface MainActivityHandler {
    void onSortDirClicked(View view);
    void onItemSelected(AdapterView<?> parent, View view, int position, long id);
    void onTextChanged(Editable s);
}
