package com.tropicgame.tinkoffnewstest.dagger.components;

import com.tropicgame.tinkoffnewstest.dagger.modules.NetworkModule;
import com.tropicgame.tinkoffnewstest.dagger.modules.PresentersModule;
import javax.inject.Singleton;
import dagger.Component;

@Component(modules = {
        NetworkModule.class,
})
@Singleton
public interface AppComponent {
    PresentersComponent plus(PresentersModule module);
}
