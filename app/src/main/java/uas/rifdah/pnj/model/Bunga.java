package uas.rifdah.pnj.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bunga {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nama_latin")
    @Expose
    private String nama_latin;
    @SerializedName("kingdom")
    @Expose
    private String kingdom;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("asal")
    @Expose
    private String asal;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Bunga(Integer id, String nama, String nama_latin, String kingdom, String kelas, String jenis, String asal, String createdAt, String updatedAt) {
        this.id = id;
        this.nama = nama;
        this.nama_latin = nama_latin;
        this.kingdom = kingdom;
        this.kelas = kelas;
        this.jenis = jenis;
        this.asal = asal;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_latin() {
        return nama_latin;
    }

    public void setNama_latin(String nama_latin) {
        this.nama_latin = nama_latin;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
