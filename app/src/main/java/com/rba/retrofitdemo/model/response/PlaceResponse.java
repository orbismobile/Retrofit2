package com.rba.retrofitdemo.model.response;

import java.util.List;

/**
 * Created by Ricardo Bravo on 2/05/16.
 */

public class PlaceResponse {

    private int success;
    /**
     * idplace : 1
     * description : DIAZ VIZCARRA JORGE WASHINGTON
     * address : AV. DEL EJERCITO
     * number : 1241
     * letter :
     * inside :
     * type : HOSTAL
     * tradename :
     * latitud : -12.1108978974
     * longitud : -77.0510816063
     */

    private List<DataBean> data;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String idplace;
        private String description;
        private String address;
        private String number;
        private String letter;
        private String inside;
        private String type;
        private String tradename;
        private String latitud;
        private String longitud;

        public String getIdplace() {
            return idplace;
        }

        public void setIdplace(String idplace) {
            this.idplace = idplace;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getLetter() {
            return letter;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public String getInside() {
            return inside;
        }

        public void setInside(String inside) {
            this.inside = inside;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTradename() {
            return tradename;
        }

        public void setTradename(String tradename) {
            this.tradename = tradename;
        }

        public String getLatitud() {
            return latitud;
        }

        public void setLatitud(String latitud) {
            this.latitud = latitud;
        }

        public String getLongitud() {
            return longitud;
        }

        public void setLongitud(String longitud) {
            this.longitud = longitud;
        }
    }
}
