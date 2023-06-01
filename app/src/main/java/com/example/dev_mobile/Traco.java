package com.example.dev_mobile;

        import android.graphics.Paint;
        import android.graphics.Path;

public class Traco {
    private Paint mPaint;
    private Path mPath;

    public Traco(Path path, Paint paint) {
        mPath = path;
        mPaint = new Paint(paint);
    }

    public Paint getPaint() {
        return mPaint;
    }

    public Path getPath() {
        return mPath;
    }
}
