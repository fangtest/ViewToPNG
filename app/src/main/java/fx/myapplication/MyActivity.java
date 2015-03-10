package fx.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.io.FileOutputStream;

public class MyActivity extends ActionBarActivity {
    TextView vHello;   // 一个写着hello的textview,背景为红色
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        vHello = (TextView) findViewById(R.id.hello);

    }

    @Override
    protected void onResume() {
        super.onResume();
        bitmap = convertViewToBitmap(vHello);
        storePNGFile(bitmap, "/storage/sdcard0/tmp/aaa.png");
    }

    public Bitmap convertViewToBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(200, 100,
                Bitmap.Config.ARGB_8888);
        //利用bitmap生成画布
        Canvas canvas = new Canvas(bitmap);
        //把view中的内容绘制在画布上
        view.draw(canvas);
        return bitmap;
    }


    public void storePNGFile(Bitmap bmp, String filename) {
        try {
            FileOutputStream out = new FileOutputStream(filename);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
