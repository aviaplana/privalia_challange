package com.privalia.albert.challenge.presentation.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by albert on 22/1/18.
 */

public abstract class BaseViewHolder<MODEL> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(MODEL item);

}
