package uas.rifdah.pnj;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.rifdah.pnj.model.Bunga;
import uas.rifdah.pnj.model.DataResponse;
import uas.rifdah.pnj.network.ApiInterface;
import uas.rifdah.pnj.network.ApiService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ApiInterface apiInterface;
    private List<Bunga> dataList = new ArrayList<>();
    private RvAdapter recycleViewAdapter = new RvAdapter();
    FloatingActionButton btnfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rv_list_bunga);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleViewAdapter);
        apiInterface = ApiService.getClient().create(ApiInterface.class);

        getItem();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        recycleViewAdapter.setOnClickListener(new RvAdapter.onViewClick() {
            @Override
            public void onViewClick(int position) {
            Bunga bunga = dataList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateData.class);
                intent.putExtra("nama", bunga.getNama());
                intent.putExtra("nama_latin", bunga.getNama_latin());
                intent.putExtra("asal", bunga.getAsal());
                Log.d(TAG, "onCreate: "+ bunga.getId());
                startActivity(intent);
            }
        });

    }


    public void getItem(){
        Call<DataResponse> dataCall = apiInterface.getData();
        dataCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                List<Bunga> bunga = response.body().getData();
                recycleViewAdapter.setDataList(bunga);
                dataList.addAll(bunga);
                Log.d(TAG, "onResponse: gg " + dataList);
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recycleViewAdapter.clearDataList(dataList);
        getItem();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialog(){
        LayoutInflater factory = LayoutInflater.from(this);
        View tambahBungaDialogView = factory.inflate(R.layout.tambah_data_popup,null);
        AlertDialog tambahBungaDialog = new AlertDialog.Builder(this).create();

        tambahBungaDialog.setView(tambahBungaDialogView);
        tambahBungaDialog.show();
    }


}
