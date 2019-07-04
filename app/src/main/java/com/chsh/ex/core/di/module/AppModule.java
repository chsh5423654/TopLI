/*
 *     (C) Copyright 2019, ForgetSky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.chsh.ex.core.di.module;



import com.chsh.ex.app.TopLiApp;
import com.chsh.ex.core.http.HttpHelper;
import com.chsh.ex.core.http.HttpHelperImpl;
import com.chsh.ex.core.preference.PreferenceHelper;
import com.chsh.ex.core.preference.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final TopLiApp application;

    public AppModule(TopLiApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    TopLiApp provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }
//
//    @Provides
//    @Singleton
//    DbHelper provideDbHelper(DbHelperImpl dbHelperImpl) {
//        return dbHelperImpl;
//    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl preferenceHelper) {
        return preferenceHelper;
    }

//    @Provides
//    @Singleton
//    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
//        return new DataManager(httpHelper, dbHelper, preferenceHelper);
//    }

}
