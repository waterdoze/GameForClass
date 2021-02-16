package com.example.gameforclass.animation;

import android.content.Context;
import android.widget.Toast;

public class EmotionalSupport {

    private int counter = 0;
    private Context context;

    private String[] messages = new String[] {
            "It's all going to be okay in the end. If it's not okay, it's not the end.",
            "Your smile is my sunrise.",
            "Soon, when all is well, you're going to look back on this period in your life and be so glad you never gave up",
            "Someone out there loves you."
    };

    public EmotionalSupport(Context context) {
        this.context = context;
    }

    public void displayMessage() {
        Toast message = Toast.makeText(context, messages[counter], Toast.LENGTH_SHORT);
        message.show();
        counter++;
        if (counter == messages.length) {
            counter = 0;
        }
    }
}
