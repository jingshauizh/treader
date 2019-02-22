/*
 * Copyright  2018  WoNium, Joy, Lokiwife.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wonium.utils;

import android.app.Application;

import android.util.Log;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;
import com.wonium.example.BuildConfig;

/**
 * @ClassName: App.java
 * @Description: 应用程序
 * @Author: Wonium
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2018/11/17 15:00
 * @UpdateUser: update user
 * @UpdateDate: 2018/11/17 15:00
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
public class App extends Application {
    private static App mInstance;
    private static final String TAG = "Tinker.App";
    private com.tencent.tinker.loader.app.ApplicationLike tinkerApplicationLike;

    @Override
    public void onCreate() {
        super.onCreate();
        initTinkerPatch();
        mInstance = this;
        initLogger();
    }

    /**
     * 我们需要确保至少对主进程跟patch进程初始化 TinkerPatch
     */
    private void initTinkerPatch() {
        // 我们可以从这里获得Tinker加载过程的信息
        if (BuildConfig.TINKER_ENABLE) {
            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
            // 初始化TinkerPatch SDK
            TinkerPatch.init(
                tinkerApplicationLike
                //                new TinkerPatch.Builder(tinkerApplicationLike)
                //                    .requestLoader(new OkHttp3Loader())
                //                    .build()
            )
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true)
                .setFetchPatchIntervalByHours(1)
            ;
            // 获取当前的补丁版本
            Log.d(TAG, "Current patch version is " + TinkerPatch.with().getPatchVersion());

            // fetchPatchUpdateAndPollWithInterval 与 fetchPatchUpdate(false)
            // 不同的是，会通过handler的方式去轮询
            TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
       }
    }


    /**
     * 初始化Logger组建
     */
    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder().showThreadInfo(true).methodCount(5).methodOffset(7).tag("wonium-extension-util").build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    public static App getInstance() {
        return mInstance;
    }
}
