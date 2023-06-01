package com.example.dev_mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class SimplePaint extends View {
    private Paint mPaint;
    private Path mPath;
    private ArrayList<Traco> tracos;

    private int corSelecionada = Color.RED;
    private Shape formatoSelecionado = Shape.LINE;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
        tracos = new ArrayList<>();
    }

    private void setupPaint() {
        mPaint = new Paint();
        mPath = new Path();

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(x,y);
                tracos.add(new Traco(mPath, mPaint));
                mPath = new Path();
                break;
        }

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Traco traco : tracos) {
            canvas.drawPath(traco.getPath(), traco.getPaint());
        }

        switch (formatoSelecionado) {
            case LINE:
                canvas.drawPath(mPath, mPaint);
                break;
            case CIRCLE:
                canvas.drawPath(mPath, mPaint);
                if (mPath != null) {
                    PathMeasure pathMeasure = new PathMeasure(mPath, false);
                    float[] startPoint = new float[2];
                    pathMeasure.getPosTan(0, startPoint, null);
                    float radius = calculateRadius(mPath);
                    canvas.drawCircle(startPoint[0], startPoint[1], radius, mPaint);
                }
                break;
            case SQUARE:
                canvas.drawPath(mPath, mPaint);
                if (mPath != null) {
                    RectF bounds = new RectF();
                    mPath.computeBounds(bounds, true);
                    canvas.drawRect(bounds, mPaint);
                }
                break;
        }
    }

    public void limparCanvas() {
        tracos.clear();
        invalidate();
    }

    public int getCorSelecionada() {
        return corSelecionada;
    }

    public Shape getFormatoSelecionado() {
        return formatoSelecionado;
    }

    public void setCorSelecionada(int cor) {
        corSelecionada = cor;
        mPaint.setColor(corSelecionada);
    }

    public void setFormatoSelecionado(Shape formato) {
        formatoSelecionado = formato;
    }

    public enum Shape {
        LINE,
        CIRCLE,
        SQUARE
    }

    private float calculateRadius(Path path) {
        RectF bounds = new RectF();
        path.computeBounds(bounds, true);
        float centerX = bounds.centerX();
        float centerY = bounds.centerY();
        float radius = Math.max(bounds.width(), bounds.height()) / 2;
        float maxRadius = Math.max(Math.abs(centerX - bounds.left), Math.abs(centerY - bounds.top));
        return Math.min(radius, maxRadius);
    }

}