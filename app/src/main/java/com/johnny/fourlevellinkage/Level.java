package com.johnny.fourlevellinkage;

/**
 * Success is the sum of small efforts, repeated day in and day out.
 * 成功就是日复一日那一点点小小努力的积累。
 *
 * AndroidGroup：158423375
 * Author：Johnny
 * AuthorQQ：956595454
 * AuthorWX：Qiang_it
 * AuthorPhone：nothing
 * Created by 2016/12/1.
 */
public class Level {
    private String placeid;
    private String placename;
    private String placetoid;
    private String placetoname;
    public String getPlaceid() {
        return placeid;
    }
    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }
    public String getPlacename() {
        return placename;
    }
    public void setPlacename(String placename) {
        this.placename = placename;
    }
    public String getPlacetoname() {
        return placetoname;
    }
    public void setPlacetoname(String placetoname) {
        this.placetoname = placetoname;
    }
    public String getPlacetoid() {
        return placetoid;
    }
    public void setPlacetoid(String placetoid) {
        this.placetoid = placetoid;
    }
    @Override
    public String toString() {
        return "Level [placeid=" + placeid + ", placename=" + placename
                + ", placetoid=" + placetoid + "]";
    }
}
