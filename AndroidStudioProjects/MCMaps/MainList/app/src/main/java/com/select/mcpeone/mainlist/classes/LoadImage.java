package com.select.mcpeone.mainlist.classes;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoadImage {
    private  static final Map<String, Drawable> cache = new HashMap<String, Drawable>();


    public static void loadImage(final ImageView imageView, final String urlString) {
        loadImage(imageView, urlString, true);
    }

    public static void loadImage(final ImageView imageView, final String urlString, boolean useCache) {
        if (useCache && cache.containsKey(urlString)) {
            imageView.setImageDrawable(cache.get(urlString));
        }

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                imageView.setImageDrawable((Drawable) message.obj);
            }
        };

        Runnable runnable = new Runnable() {
            public void run() {
                Drawable drawable = null;
                try {
                    InputStream is = download(urlString);

                    drawable = Drawable.createFromStream(is, "src");

                    if (drawable != null) {
                        cache.put(urlString, drawable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Message msg = handler.obtainMessage(1, drawable);
                handler.sendMessage(msg);
            }
        };
        new Thread(runnable).start();

    }

    private static InputStream download(String urlString) throws MalformedURLException, IOException {
        InputStream inputStream = (InputStream) new URL(urlString).getContent();
        return inputStream;
    }
}
