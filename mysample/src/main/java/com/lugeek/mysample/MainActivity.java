package com.lugeek.mysample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentTree;
import com.facebook.litho.widget.Text;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Component;
import com.facebook.litho.LithoView;
import com.facebook.yoga.YogaAlign;

import static com.facebook.yoga.YogaEdge.ALL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = findViewById(R.id.ll);

        LithoView lithoView = findViewById(R.id.lithoView);
        final ComponentContext c = new ComponentContext(this);
        final Component component = Column.create(c)
                .alignItems(YogaAlign.CENTER)
                .backgroundColor(Color.WHITE)
                .child(
                        Text.create(c)
                                .text("Hello world")
                                .textSizeSp(40))
                .child(
                        Text.create(c)
                                .text("Litho tutorial")
                                .textSizeSp(20))
                .build();
        final ComponentTree componentTree = ComponentTree.create(c, component).build();
        lithoView.setComponentTree(componentTree);
    }
}
