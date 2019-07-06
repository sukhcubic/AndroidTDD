package com.example.notetaking.di;

import com.example.notetaking.BaseApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(
        modules = {
                AndroidInjectionModule.class,
                AppModule.class,
                ActivityBuilderModule.class,
                ViewModelFactoryModule.class


        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {
}
