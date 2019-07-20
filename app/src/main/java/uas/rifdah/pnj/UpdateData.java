package uas.rifdah.pnj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.rifdah.pnj.model.ErrorMessage;
import uas.rifdah.pnj.network.ApiInterface;
import uas.rifdah.pnj.network.ApiService;

public class UpdateData extends AppCompatActivity {
    private static final String TAG = "UpdateData";
    private ApiInterface apiInterface;
    EditText editNama, editNamaLatin, editKingdom, editKelas, editJenis, editAsal;
    Button btnTambah, btnHapus;
    Intent intent = getIntent();
    int id = intent.getIntExtra("id",0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);

        initData();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData.this.ubahData(id, editNama.getText().toString(), editNamaLatin.getText().toString(), editKingdom.getText().toString(),
                        editKelas.getText().toString(), editJenis.getText().toString(), editAsal.getText().toString());
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData.this.hapusData(id);
            }
        });

    }

    public void initData(){

        editNama = findViewById(R.id.tambah_nama_bunga);
        editNamaLatin = findViewById(R.id.tambah_nama_latin);
        editKingdom = findViewById(R.id.tambah_kingdom);
        editKelas = findViewById(R.id.tambah_kelas);
        editJenis = findViewById(R.id.tambah_jenis);
        editAsal = findViewById(R.id.tambah_asal);
        btnTambah = findViewById(R.id.btnTambah);
        btnHapus = findViewById(R.id.btnHapus);

        String nama = intent.getStringExtra("nama");
        String namaLatin = intent.getStringExtra("nama_latin");
        String kingdom = intent.getStringExtra("kingdom");
        String kelas = intent.getStringExtra("kelas");
        String jenis = intent.getStringExtra("jenis");
        String asal = intent.getStringExtra("asal");

        Log.d(TAG,"onCreate: gg " + intent.getStringExtra("nama"));
        Log.d(TAG,"onCreate: "+id);
        editNama.setText(nama);
        editNamaLatin.setText(namaLatin);
        editKingdom.setText(kingdom);
        editKelas.setText(kelas);
        editJenis.setText(jenis);
        editAsal.setText(asal);
        apiInterface = ApiService.getClient().create(ApiInterface.class);




    }

    private void ubahData(Integer id, String nama, String namaLatin, String kingdom, String kelas,
                 String jenis, String asal ){
        Call<ErrorMessage> dataCall = apiInterface.ubahBunga(id, nama, namaLatin, kingdom, kelas, jenis, asal);
        dataCall.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(UpdateData.this, "Data berhasil di update", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(UpdateData.this, "Data gagal di update", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t);
            }
        });
    }

    private void hapusData(int id){
        Call<ErrorMessage> data = apiInterface.hapusBunga(id);
        data.enqueue(new Callback<ErrorMessage>() {
            @Override
            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                Toast.makeText(UpdateData.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse : jj " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<ErrorMessage> call, Throwable t) {
                Toast.makeText(UpdateData.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"onFailure: ",t);
            }
        });
    }


}
