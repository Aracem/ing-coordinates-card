
package com.acdroid.ingdirect;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Codes extends Activity {

    private ListView list;
    private final int[] codes = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codes);

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new CodesAdapter(this));
    }

    public class CodesAdapter extends BaseAdapter {
        private final LayoutInflater inflater;

        public CodesAdapter(Context context) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return codes.length / 2;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {

            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            ViewHolder holder;

            if (view == null)
                view = inflater.inflate(R.layout.list_item_codes, null);

            holder = (ViewHolder) view.getTag();

            if (holder == null) {
                holder = new ViewHolder(view);
                view.setTag(holder);
            }

            holder.num1.setText("" + (position * 2 + 1));
            holder.pass1.setText("" + codes[position * 2]);
            holder.num2.setText("" + (position * 2 + 2));
            holder.pass2.setText("" + codes[position * 2 + 1]);

            return view;
        }

        public class ViewHolder {
            TextView num1;
            TextView pass1;
            TextView num2;
            TextView pass2;

            public ViewHolder(View v) {
                num1 = (TextView) v.findViewById(R.id.num_one);
                pass1 = (TextView) v.findViewById(R.id.pass_one);
                num2 = (TextView) v.findViewById(R.id.num_two);
                pass2 = (TextView) v.findViewById(R.id.pass_two);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_codes, menu);
        return true;
    }

    /**************************************** BACK KEY CONTROL *********************************************/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            android.os.Process.killProcess(android.os.Process.myPid());
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
