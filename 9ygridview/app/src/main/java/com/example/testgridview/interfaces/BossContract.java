package com.example.testgridview.interfaces;

/**
 * Created by jings on 2019/4/17.
 */

public interface BossContract {
    interface View {
        void showText(String text);

        void showTitle(String title);
    }

    interface Presenter {
        void attach(View view);

        void detach();

        void start();

        void stop();
    }
}
