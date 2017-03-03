package com.zimu21.zimu.bean;

import android.os.Parcelable;

/**
 * Created by Administrator on 2017/3/3.
 */

public class CityLocation  {


    /**
     * status : OK
     * result : {"location":{"lng":100.491146,"lat":40.983228},"formatted_address":"内蒙古自治区阿拉善盟额济纳旗","business":"","addressComponent":{"city":"阿拉善盟","direction":"","distance":"","district":"额济纳旗","province":"内蒙古自治区","street":"","street_number":""},"cityCode":230}
     */

    private String status;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * location : {"lng":100.491146,"lat":40.983228}
         * formatted_address : 内蒙古自治区阿拉善盟额济纳旗
         * business :
         * addressComponent : {"city":"阿拉善盟","direction":"","distance":"","district":"额济纳旗","province":"内蒙古自治区","street":"","street_number":""}
         * cityCode : 230
         */

        private LocationBean location;
        private String formatted_address;
        private String business;
        private AddressComponentBean addressComponent;
        private String cityCode;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponentBean getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentBean addressComponent) {
            this.addressComponent = addressComponent;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public static class LocationBean {
            /**
             * lng : 100.491146
             * lat : 40.983228
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class AddressComponentBean {
            /**
             * city : 阿拉善盟
             * direction :
             * distance :
             * district : 额济纳旗
             * province : 内蒙古自治区
             * street :
             * street_number :
             */

            private String city;
            private String direction;
            private String distance;
            private String district;
            private String province;
            private String street;
            private String street_number;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }
        }
    }
}
