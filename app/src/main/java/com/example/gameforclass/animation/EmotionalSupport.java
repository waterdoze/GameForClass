package com.example.gameforclass.animation;

import android.content.Context;
import android.widget.Toast;

public class EmotionalSupport {

    private int counter = 0;
    private Context context;
    private String[] messages = new String[] {
            "It's all going to be okay in the end. If it's not okay, it's not the end.",
            "Your smile is my sunrise :)",
            "Soon, when all is well, you're going to look back on this period in your life and be so glad you never gave up.",
            "Someone out there loves you.",
            "You are braver than you believe, stronger than you seem, and smarter than you think!",
            "If you hear a voice within you saying \"YOU CANNOT PAINT,\" then by all means paint, and that voice will be silenced.",
            "People might forget what you said and forget what you did, but they will never forget how you made them feel",
            "God doesn't give the hardest battles to his toughest soldiers. He creates the toughest soldiers out of life's hardest battles.",
            "If they say it's impossible, it's impossible for them, not for you.",
    };

    public EmotionalSupport(Context context) {
        this.context = context;
    }

    public void displayMessage() {
        Toast message = Toast.makeText(context, messages[counter], Toast.LENGTH_LONG);
        message.show();
        counter++;
        if (counter == messages.length) {
            counter = 0;
        }
    }
}
