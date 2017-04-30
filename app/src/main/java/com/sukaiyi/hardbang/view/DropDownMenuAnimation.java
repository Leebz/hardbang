package com.sukaiyi.hardbang.view;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.shehabic.droppy.DroppyMenuPopup;
import com.shehabic.droppy.animations.DroppyAnimation;
import com.shehabic.droppy.views.DroppyMenuPopupView;

public class DropDownMenuAnimation implements DroppyAnimation
{
    private static int ANIMATION_DURATION = 200;

    @Override
    public void animateHide(final DroppyMenuPopup popup, final DroppyMenuPopupView popupView, final View anchor, final boolean itemSelected)
    {
        ScaleAnimation alphaAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        alphaAnimation.setDuration(ANIMATION_DURATION);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override public void onAnimationStart(Animation animation) { }
            @Override public void onAnimationRepeat(Animation animation) { }
            @Override
            public void onAnimationEnd(Animation animation)
            {
                popup.hideAnimationCompleted(itemSelected);
            }
        });
        popupView.startAnimation(alphaAnimation);
    }

    @Override
    public void animateShow(final DroppyMenuPopupView popup, final View anchor)
    {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        scaleAnimation.setDuration(ANIMATION_DURATION);
        scaleAnimation.setFillAfter(true);
        popup.startAnimation(scaleAnimation);
    }
}
