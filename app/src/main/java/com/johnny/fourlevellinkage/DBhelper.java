package com.johnny.fourlevellinkage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Success is the sum of small efforts, repeated day in and day out.
 * 成功就是日复一日那一点点小小努力的积累。
 * AndroidGroup：158423375
 * Author：Johnny
 * AuthorQQ：956595454
 * AuthorWX：Qiang_it
 * AuthorPhone：nothing
 * Created by 2016/12/1.
 */
public class DBhelper {
    private SQLiteDatabase db;
    private Context context;
    private DBManager dbm;

    public DBhelper(Context context) {
        super();
        this.context = context;
        dbm = new DBManager(context);
    }

    /**
     * 获取洲
     * @return
     */
    public ArrayList<Level> getContinent() {
        dbm.openDatabase();
        db = dbm.getDatabase();
        ArrayList<Level> list = new ArrayList<Level>();
        try {
            String sql = "select * from Continent";
            Cursor cursor = db.rawQuery(sql,null);
            cursor.moveToFirst();
            while (!cursor.isLast()){
                String placeid=cursor.getString(cursor.getColumnIndex("ContinentId"));
                byte bytes[]=cursor.getBlob(2);
                String placename=new String(bytes,"utf-8");
                Level level=new Level();
                level.setPlacename(placename);
                level.setPlaceid(placeid);
                list.add(level);
                cursor.moveToNext();
            }
            String placeid=cursor.getString(cursor.getColumnIndex("ContinentId"));
            byte bytes[]=cursor.getBlob(2);
            String placename=new String(bytes,"utf-8");
            Level level=new Level();
            level.setPlacename(placename);
            level.setPlaceid(placeid);
            list.add(level);
            cursor.close();
        } catch (Exception e) {
            return null;
        }
        dbm.closeDatabase();
        db.close();
        return list;
    }

    /**
     * 获取国
     * @param placetoid
     * @return
     */
    public ArrayList<Level> getCountry(String placetoid) {
        dbm.openDatabase();
        db = dbm.getDatabase();
        ArrayList<Level> list = new ArrayList<Level>();
        try {
            String sql = "select * from Country where ContinentId='"+placetoid+"'";
            Cursor cursor = db.rawQuery(sql,null);
            cursor.moveToFirst();
            while (!cursor.isLast()){
                String placeid=cursor.getString(cursor.getColumnIndex("CountryId"));
                byte bytes[]=cursor.getBlob(2);
                String placename=new String(bytes,"utf-8");
                Level level=new Level();
                level.setPlacename(placename);
                level.setPlaceid(placeid);
                level.setPlacetoid(placetoid);
                list.add(level);
                cursor.moveToNext();
            }
            String placeid=cursor.getString(cursor.getColumnIndex("CountryId"));
            byte bytes[]=cursor.getBlob(2);
            String placename=new String(bytes,"utf-8");
            Level level=new Level();
            level.setPlacename(placename);
            level.setPlaceid(placeid);
            level.setPlacetoid(placetoid);
            list.add(level);
            cursor.close();
        } catch (Exception e) {
            return null;
        }
        dbm.closeDatabase();
        db.close();
        return list;
    }

    /**
     * 获取省
     * @param placetoid
     * @return
     */
    public ArrayList<Level> getProvince(String placetoid) {
        dbm.openDatabase();
        db = dbm.getDatabase();
        ArrayList<Level> list = new ArrayList<Level>();
        try {
            String sql = "select * from Province where CountryId='"+placetoid+"'";
            Cursor cursor = db.rawQuery(sql,null);
            if (cursor.moveToFirst()) {
                while (!cursor.isLast()) {
                    String placeid = cursor.getString(cursor.getColumnIndex("ProvinceId"));
                    byte bytes[] = cursor.getBlob(2);
                    String placename = new String(bytes, "utf-8");
                    Level level = new Level();
                    level.setPlacename(placename);
                    level.setPlaceid(placeid);
                    list.add(level);
                    cursor.moveToNext();
                }
                String placeid = cursor.getString(cursor.getColumnIndex("ProvinceId"));
                byte bytes[] = cursor.getBlob(2);
                String placename = new String(bytes, "utf-8");
                Level level = new Level();
                level.setPlacename(placename);
                level.setPlaceid(placeid);
                list.add(level);
            }
            cursor.close();
        } catch (Exception e) {
            return null;
        }
        dbm.closeDatabase();
        db.close();
        return list;
    }

    /**
     * 获取市
     * @param placetoid
     * @return
     */
    public ArrayList<Level> getCity(String placetoid) {
        dbm.openDatabase();
        db = dbm.getDatabase();
        ArrayList<Level> list = new ArrayList<Level>();
        try {
            String sql = "select * from City where ProvinceId='"+placetoid+"'";
            Cursor cursor = db.rawQuery(sql,null);
            if (cursor.moveToFirst()) {
                while (!cursor.isLast()) {
                    String placeid = cursor.getString(cursor.getColumnIndex("CityId"));
                    byte bytes[] = cursor.getBlob(2);
                    String placename = new String(bytes, "utf-8");
                    Level level = new Level();
                    level.setPlacename(placename);
                    level.setPlaceid(placeid);
                    list.add(level);
                    cursor.moveToNext();
                }
                String placeid = cursor.getString(cursor.getColumnIndex("CityId"));
                byte bytes[] = cursor.getBlob(2);
                String placename = new String(bytes, "utf-8");
                Level level = new Level();
                level.setPlacename(placename);
                level.setPlaceid(placeid);
                list.add(level);
            }
            cursor.close();
        } catch (Exception e) {
            return null;
        }
        dbm.closeDatabase();
        db.close();
        return list;
    }

    /**
     * 关键字获取
     * @param keyword
     * @param table
     * @param field
     * @param fieldId
     * @param fieldtoId
     * @return
     */
    public ArrayList<Level> getKeyWord(String keyword, String table, String field, String fieldId, String fieldtoId) {
        dbm.openDatabase();
        db = dbm.getDatabase();
        ArrayList<Level> list = new ArrayList<Level>();
        try{
            String Continetsql = "select * from "+table+" where "+field+" like '%"+keyword+"%'";
            Cursor continentCursor = db.rawQuery(Continetsql,null);
            if (continentCursor.moveToFirst()) {
                while (!continentCursor.isLast()) {
                    String placeid = continentCursor.getString(continentCursor.getColumnIndex(fieldId));
                    String placetoid = continentCursor.getString(continentCursor.getColumnIndex(fieldtoId));
                    byte bytes[] = continentCursor.getBlob(2);
                    String placename = new String(bytes, "utf-8");
                    Level level = new Level();
                    level.setPlacename(placename);
                    level.setPlaceid(placeid);
                    level.setPlacetoid(placetoid);
                    list.add(level);
                    continentCursor.moveToNext();
                }
                String placeid = continentCursor.getString(continentCursor.getColumnIndex(fieldId));
                String placetoid = continentCursor.getString(continentCursor.getColumnIndex(fieldtoId));
                byte bytes[] = continentCursor.getBlob(2);
                String placename = new String(bytes, "utf-8");
                Level level = new Level();
                level.setPlacename(placename);
                level.setPlaceid(placeid);
                level.setPlacetoid(placetoid);
                list.add(level);
            }
            continentCursor.close();
        }catch(Exception e){
            return null;
        }finally{
            dbm.closeDatabase();
            db.close();
        }
        return list;
    }

    /**
     * 根据toId获取所属省
     * @param placetoid
     * @param table
     * @param fieldId
     * @return
     */
    public String getTheir(String placetoid, String table, String fieldId) {
        dbm.openDatabase();
        db = dbm.getDatabase();
        String theirName=null;
        try {
            String sql = "select * from "+table+" where "+fieldId+"='"+placetoid+"'";
            Cursor cursor = db.rawQuery(sql,null);
            if (cursor.moveToFirst()) {
                String placeid = cursor.getString(cursor.getColumnIndex(fieldId));
                byte bytes[] = cursor.getBlob(2);
                theirName = new String(bytes, "utf-8");
            }
            cursor.close();
        } catch (Exception e) {
            return null;
        }
        dbm.closeDatabase();
        db.close();
        return theirName;
    }
}
