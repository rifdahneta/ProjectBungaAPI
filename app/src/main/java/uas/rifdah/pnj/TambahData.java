package uas.rifdah.pnj;

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

public class TambahData extends AppCompatActivity {

    private static final String TAG = "TambahData";
    private ApiInterface apiInterface;
    EditText editNama, editNamaLatin, editKingdom, editKelas, editJenis, editAsal;
    Button btnTambah, btnHapus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data_popup);

        initData();
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ErrorMessage> dataCall = apiInterface.tambahBunga(editNama.getText().toString(), editNamaLatin.getText().toString(), editKingdom.getText().toString(),
                      editKelas.getText().toString(), editJenis.getText().toString(), editAsal.getText().toString());
                dataCall.enqueue(new Callback<ErrorMessage>() {
                    @Override
                    public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
                        Toast.makeText(TambahData.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onResponse: " + response.raw());
                        onBackPressed();
                    }

                    @Override
                    public void onFailure(Call<ErrorMessage> call, Throwable t) {
                        Toast.makeText(TambahData.this, "Data tidak berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                       Log.e(TAG,"onFailure: ",t);
                    }
                });
//                addData(editNama.getText().toString(), editNamaLatin.getText().toString(), editKingdom.getText().toString(),
//                        editKelas.getText().toString(), editJenis.getText().toString(), editAsal.getText().toString());
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
        apiInterface = ApiService.getClient().create(ApiInterface.class);
    }

//    public void addData(String nama, String namaLatin, String kingdom, String kelas,
//                        String jenis, String asal){
//        Call<ErrorMessage> dataCall = apiInterface.tambahBunga(nama, namaLatin, kingdom, kelas, jenis, asal);
//        dataCall.enqueue(new Callback<ErrorMessage>() {
//            @Override
//            public void onResponse(Call<ErrorMessage> call, Response<ErrorMessage> response) {
//                Toast.makeText(TambahData.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onResponse: " + response.raw());
//                onBackPressed();
//            }
//
//            @Override
//            public void onFailure(Call<ErrorMessage> call, Throwable t) {
//                Toast.makeText(TambahData.this, "Data tidak berhasil ditambahkan", Toast.LENGTH_SHORT).show();
//                Log.e(TAG,"onFailure: ",t);
//            }
//        });
//
//    }



}
