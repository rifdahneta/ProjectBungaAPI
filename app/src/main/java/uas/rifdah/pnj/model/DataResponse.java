package uas.rifdah.pnj.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")
    @Expose
    private List<Bunga> data = null;

    public List<Bunga> getData() {
        return data;
    }

    public void setData(List<Bunga> data) {
        this.data = data;
    }

}
