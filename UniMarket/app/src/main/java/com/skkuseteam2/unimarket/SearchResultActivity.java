package com.skkuseteam2.unimarket;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {
    String data;
    ImageView ganpan;
    ImageView backButton;
    int size = MainActivity.items.size();
    ImageButton guhaeBtn;
    ImageButton findBtn;

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

            private void clear() {
                lists.clear();
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

        final ListView listView = (ListView)findViewById(R.id.listView);
        listView.setBackgroundColor(Color.WHITE);
        final MarketAdapter adapter = new MarketAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailFindActivity.class);
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

        guhaeBtn = (ImageButton)findViewById(R.id.guhaeButton);
        findBtn = (ImageButton)findViewById(R.id.findButton);

        guhaeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guhaeBtn.setImageResource(R.drawable.guhae_on);
                findBtn.setImageResource(R.drawable.find);
                adapter.clear();

                MarketItem item = MainActivity.items.get(2);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                item = MainActivity.items.get(8);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                item = MainActivity.items.get(13);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                item = MainActivity.items.get(15);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));

                listView.setAdapter(adapter);
            }
        });

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guhaeBtn.setImageResource(R.drawable.guhae);
                findBtn.setImageResource(R.drawable.find_on);
                adapter.clear();

                MarketItem item = MainActivity.items.get(4);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                item = MainActivity.items.get(6);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                item = MainActivity.items.get(9);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));
                item = MainActivity.items.get(14);
                adapter.addItem(new MarketItem(item.getIcon(),item.getIcon2(),item.getAddress(),item.getImg1(),item.getImg2(),item.getImg3(),item.getImg4(),item.getMoney()));

                listView.setAdapter(adapter);            }
        });
    }

}
