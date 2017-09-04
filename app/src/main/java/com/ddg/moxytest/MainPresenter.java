package com.ddg.moxytest;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void onChangeBtnClick() {
        getViewState().onChangeClick();
    }

}
