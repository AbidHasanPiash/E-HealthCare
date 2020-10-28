package com.abidhasan.e_healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;

public class HealthTips extends AppCompatActivity {
    private ExpandingList mExpandingList;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);
        mExpandingList = findViewById(R.id.expanding_list_main);
        createItems();
        SmoothFade();
    }

    private void SmoothFade() {
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
    }

    private void createItems() {
        addItem("সাধারণ সমস্যা", new String[]{"বমি", "সর্দি", "মাথা ঘোরা"}, R.color.pink, R.drawable.ic_read);
        addItem("জ্বর", new String[]{"সাধারণ জ্বর", "বাত জ্বর", "ডেঙ্গু জ্বর"}, R.color.blue, R.drawable.ic_read);
        addItem("ব্যথা সম্পর্কিত", new String[]{"মাথা ব্যথা","কোমড় ব্যথা","পেট ব্যথা","বাত ব্যথা"}, R.color.purple, R.drawable.ic_read);
        addItem("চর্মরোগ", new String[]{"এলার্জি", "ফোঁড়া "}, R.color.yellow, R.drawable.ic_read);
        addItem("দুর্ঘটনা", new String[]{"গলায় খাবার বাঁধলে", "কাটাছেড়া","কামড়নো", "পানিতে ডুবেগেলে", "বৈদ্যুতিক শক লাগলে", "আগুনে পুড়েগেলে","হাড় ভাঙ্গা বা মচকানো"}, R.color.orange, R.drawable.ic_read);
        addItem("খাদ্য ও পুষ্টি", new String[]{"ফল", "সবজি"}, R.color.green, R.drawable.ic_read);
    }

    private void addItem(String title, String[] subItems, int colorRes, int iconRes) {
        //Let's create an item with R.layout.expanding_layout
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);

        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            ((TextView) item.findViewById(R.id.title)).setText(title);
            //We can create items in batch.
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                //Let's get the created sub item by its index
                final View view = item.getSubItemView(i);
                //Let's set some values in
                configureSubItem(item, view, subItems[i]);
            }
        }
    }

    private void configureSubItem(final ExpandingItem item, final View view, final String subTitle) {
        ((TextView) view.findViewById(R.id.sub_title)).setText(subTitle);
        view.findViewById(R.id.sub_title_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (subTitle) {
                    case "বমি": {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.bomi);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                    case "সর্দি": {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.shordi);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                    case "মাথা ঘোরা": {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.matha_ghura);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                    case "সাধারণ জ্বর": {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.shadharon_jor);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                    case "বাত জ্বর": {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.bat_jor);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                    case "ডেঙ্গু জ্বর": {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.dengu_jor);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                    default: {
                        Intent intent = new Intent(HealthTips.this, SolutionViewer.class);
                        string = getString(R.string.Health_tips);
                        intent.putExtra("value", string);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    }
                }
            }
        });
    }
}
