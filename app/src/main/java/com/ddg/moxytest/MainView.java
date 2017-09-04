package com.ddg.moxytest;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by james on 10.07.17.
 */

public interface MainView extends MvpView {

    void onChangeClick();

}
