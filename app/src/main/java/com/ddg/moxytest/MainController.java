package com.ddg.moxytest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bluelinelabs.conductor.Controller;

/**
 * Created by james on 10.07.17.
 */

public class MainController extends Controller implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    private View colorView;

    private MvpDelegate<? extends MainController> mMvpDelegate;

    public MainController() {
        super();
        Log.d("TAG", "MainController: constructor was called");
        this.getMvpDelegate().onCreate();
    }

    public MainController(Bundle args) {
        super(args);
        this.getMvpDelegate().onCreate(args);
    }

    @Override
    protected void onAttach(@NonNull View v) {
        super.onAttach(v);
        this.getMvpDelegate().onAttach();
        colorView = v.findViewById(R.id.colorView);
        v.findViewById(R.id.changeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onChangeBtnClick();
            }
        });
    }

    @Override
    protected void onDetach(@NonNull View view) {
        super.onDetach(view);
        this.getMvpDelegate().onDetach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.getMvpDelegate().onDestroy();
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        this.getMvpDelegate().onDestroyView();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        this.getMvpDelegate().onSaveInstanceState(outState);
    }

    private MvpDelegate getMvpDelegate() {
        if (this.mMvpDelegate == null) {
            this.mMvpDelegate = new MvpDelegate<>(this);
        }

        return this.mMvpDelegate;
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {

        return inflater.inflate(R.layout.content, container, false);
    }

    @Override
    public void onChangeClick() {
        colorView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}
