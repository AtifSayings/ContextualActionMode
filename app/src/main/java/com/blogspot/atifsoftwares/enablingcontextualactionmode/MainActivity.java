package com.blogspot.atifsoftwares.enablingcontextualactionmode;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button mShowBtn;
    RelativeLayout mRelLayout; //for snackbar
    ActionMode mActionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowBtn = findViewById(R.id.show_btn);
        mRelLayout = findViewById(R.id.root_layout);

        //button click to show contextual action mode
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionMode = startActionMode(mActionModeCallBack);
            }
        });
    }

    private ActionMode.Callback mActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            /*When you start action mode by calling start action mode method,
            * system will call this method*/
            //inflate menu item here
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            /*this method will be called after onCreateActionMode method*/
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            /*This method is called when menu item is clicked*/

            switch (item.getItemId()){
                case R.id.action_copy:
                    showMessage("Copy Option Selected");
                    mode.finish(); //hide on item click
                    return true;
                case R.id.action_share:
                    showMessage("Share Option Selected");
                    mode.finish(); //hide on item click
                    return true;
                default:
                        return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            /*when user leave contextual action mode, system call this method*/
            //when user leave contextual action mode, reset variable
            mActionMode = null;

        }
    };

    private void showMessage(String copy_option_selected) {
        Snackbar.make(mRelLayout, copy_option_selected, Snackbar.LENGTH_SHORT).show();
    }

}
/*In this tutorial we will Enabling Contextual Action Mode
    We will create menu.xml, and add items in it.
*   We will create a button in our activity, When that button is clicked
* the actionbar with menu items will be displayed. When one of the item
* is clicked the required action will be performed. I'm gonna display
* Snackbar on item click.*/
