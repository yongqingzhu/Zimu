package com.zimu21.zimu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zimu21.zimu.R;

/**
 * Created by Administrator on 2017/3/9.
 */

public class RoundnessView extends View {
    private OnMyClickListener onMyClickListener = null;
    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
        this.onMyClickListener = onMyClickListener;
    }
    private BitmapShader bitmapShader = null;
    private Bitmap bitmap = null;
    private Paint paint = null;
    public RoundnessView(Context context) {
        this(context,null);
    }
    public RoundnessView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public RoundnessView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR,
                Shader.TileMode.MIRROR);
        paint.setShader(bitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        // canvas.drawRect(0, 0, getRight(), getBottom(), paint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 10,
                paint);
    }
    private boolean isDown = false;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if ((event.getX() - getWidth() / 2)
                        * (event.getX() - getWidth() / 2)
                        + (event.getY() - getHeight() / 2)
                        * (event.getY() - getHeight() / 2) <= (getWidth() / 2 - 10)
                        * (getWidth() / 2 - 10)) {
                    isDown = true;
                }

                break;
            /*case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                if ((event.getX() - getWidth() / 2)
                        * (event.getX() - getWidth() / 2)
                        + (event.getY() - getHeight() / 2)
                        * (event.getY() - getHeight() / 2) <= (getWidth() / 2 - 10)
                        * (getWidth() / 2 - 10)) {
                    if (isDown) {
                        if (onMyClickListener != null) {
                            onMyClickListener.onClick(RoundnessView.this);
                        }
                        isDown=false;
                    }
                }
                break;*/
            default:
                break;
        }
        return true;
    }
    private interface OnMyClickListener{
        void onClick(View view);
    }

}
