package com.jkb.rollinglayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Common base class of common implementation for {@link RollingLayout} that can be
 * used by another class.
 * <p>
 * Created by yangjing on 17-7-21.
 */

public interface RollingLayoutAction {

    /**
     * @hide
     */
    @IntDef({UP_DOWN, DOWN_UP, LEFT_RIGHT, RIGHT_LEFT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    /**
     * the rolling orientation of {@link RollingLayout} child views from top to bottom.
     */
    int UP_DOWN = 1001;
    /**
     * the rolling orientation of {@link RollingLayout} child views from bottom to top.
     */
    int DOWN_UP = 1002;
    /**
     * the rolling orientation of {@link RollingLayout} child views from left to right.
     */
    int LEFT_RIGHT = 2001;
    /**
     * the rolling orientation of {@link RollingLayout} child views from right to left.
     */
    int RIGHT_LEFT = 2002;

    /**
     * set the rolling orientation.
     *
     * @param orientation rolling orientation for {@link RollingLayout}.
     */
    void setRollingOrientation(@Orientation int orientation);

    /**
     * set the spend time of each rolling.
     *
     * @param time the spend time of each rolling for {@link RollingLayout}.measure time by the millisecond.
     */
    void setRollingEachTime(int time);

    /**
     * set the pause time when the child view is rolling complected.
     *
     * @param time the pause time . measure time by the millisecond.
     */
    void setRollingPauseTime(int time);

    /**
     * Sets the data behind this RollingLayout.
     *
     * @param adapter The BaseAdapter which is responsible for maintaining the
     *                data backing this list and for producing a view to represent an
     *                item in that data set.
     */
    void setAdapter(BaseAdapter adapter);

    /**
     * make the RollingLayout's child view rolling.
     */
    void startRolling();

    /**
     * stop the RollingLayout rolling.
     */
    void stopRolling();

    /**
     * add a listener to listen RollingLayout rolling changed action.
     */
    void addOnRollingChangedListener(@NonNull OnRollingChangedListener onRollingChangedListener);

    /**
     * set a listener to listen RollingLayout rolling item click action.
     */
    void setOnRollingItemClickListener(@NonNull OnRollingItemClickListener onRollingItemClickListener);

    /**
     * listener for listen RollingLayout changed action.
     */
    interface OnRollingChangedListener {

        /**
         * This method will be called when rolling is changed.
         *
         * @param rollingLayout   {@link RollingLayout}
         * @param currentPosition current position of rolling list.
         * @param sumPosition     sum position of rolling list.
         */
        void onRollingChanged(View rollingLayout, int currentPosition, int sumPosition);
    }

    /**
     * listener for listen RollingLayout item view is clicked.
     */
    interface OnRollingItemClickListener {

        /**
         * this method will be called when rolling item is clicked.
         *
         * @param view     item view.
         * @param parent   RollingLayout view.
         * @param position the item position that is clicked.
         */
        void onRollingItemClick(View view, ViewGroup parent, int position);
    }
}
