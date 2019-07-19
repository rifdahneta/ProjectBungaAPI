package uas.rifdah.pnj.network;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import uas.rifdah.pnj.model.DataResponse;
import uas.rifdah.pnj.model.ErrorMessage;

public interface ApiInterface {
    @GET("bunga")
    Call<DataResponse> getData();
    @FormUrlEncoded
    @POST("bunga")
    Call<ErrorMessage> tambahBunga(@Field("nama") String nama,
                                   @Field("nama_latin") String nama_latin,
                                   @Field("kingdom") String kingdom,
                                   @Field("kelas") String kelas,
                                   @Field("jenis") String jenis,
                                   @Field("asal") String asal
    );
    @FormUrlEncoded
    @PUT("bunga/{id}")
    Call<ErrorMessage> ubahBunga(@Path("id") Integer id,
                                 @Field("nama") String nama,
                                 @Field("nama_latin") String nama_latin,
                                 @Field("kingdom") String kingdom,
                                 @Field("kelas") String kelas,
                                 @Field("jenis") String jenis,
                                 @Field("asal") String asal
    );

    @DELETE("bunga/{id}")
    Call<ErrorMessage> hapusBunga(@Path("id") Integer id);
}
