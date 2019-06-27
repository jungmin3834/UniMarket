package com.skkuseteam2.unimarket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {
    String data;
    ImageView ganpan;
    ImageView backButton;
    int size = MainActivity.items.size();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        backButton = (ImageView)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
            }
        });

        ganpan = (ImageView)findViewById(R.id.ganpan);
        Intent intent = getIntent();
        data = intent.getStringExtra("id");

        class MarketAdapter extends BaseAdapter {
            ArrayList<MarketItem> lists = new ArrayList<MarketItem>();

            @Override
            public int getCount() {
                return lists.size();
            }

            @Override
            public Object getItem(int position) {
                return lists.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            public void addItem(MarketItem item){
                lists.add(item);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                MarketItemView view = null;
                if(convertView == null){
                    view =  new MarketItemView(getApplicationContext());
                }
                else{
                    view = (MarketItemView) convertView;
                }

                MarketItem item = lists.get(position);
                view.setIcon(item.getIcon());
                view.setIcon2(item.getIcon2());
                view.setAddress(item.getAddress());
                view.setImg(item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4());
                view.setMoney(item.getMoney());
                return view;
            }
        }

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setBackgroundColor(Color.WHITE);
        MarketAdapter adapter = new MarketAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
            }
        });

        if(data.equals("move")){
            ganpan.setImageResource(R.drawable.tagbutton_move);
            for(int i=0;i<size;i++){
                MarketItem item = MainActivity.items.get(i);
                if(item.getIcon()==R.drawable.move || item.getIcon()==R.drawable.move_y){
                    adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                }
            }
        }
        else if(data.equals("car")){
            ganpan.setImageResource(R.drawable.tagbutton_car);
            for(int i=0;i<size;i++){
                MarketItem item = MainActivity.items.get(i);
                if(item.getIcon()==R.drawable.car || item.getIcon() == R.drawable.car_y){
                    adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                }
            }
        }
        else if(data.equals("animal")){
            ganpan.setImageResource(R.drawable.tagbutton_pet);
            for(int i=0;i<size;i++){
                MarketItem item = MainActivity.items.get(i);
                if(item.getIcon()==R.drawable.pet_y || item.getIcon()==R.drawable.pet){
                    adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                }
            }
        }
        else if(data.equals("deliever")){
            ganpan.setImageResource(R.drawable.tagbutton_pack);
            for(int i=0;i<size;i++){
                MarketItem item = MainActivity.items.get(i);
                if(item.getIcon()==R.drawable.pack || item.getIcon()==R.drawable.pack_y){
                   adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                }
            }
        }
        else if(data.equals("gita")){
            ganpan.setImageResource(R.drawable.tagbutton_etc);
            for(int i=0;i<size;i++){
                MarketItem item = MainActivity.items.get(i);
                if(item.getIcon()==R.drawable.etc || item.getIcon()==R.drawable.etc_y){
                    adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                }
            }
        }
        listView.setAdapter(adapter);
    }

}
