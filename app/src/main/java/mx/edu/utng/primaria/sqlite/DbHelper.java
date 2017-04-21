package mx.edu.utng.primaria.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "learningEnglish.db";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_NOMBRE_USUARIO="nombre_usuario";
    public static final String COLUMN_APELLIDOS_USUARIO="apellidos_usuario";
    public static final String ACTIVITY_TABLE="activities";
    public static final String COLUMN_ACTIVITY_ID = "activity_id";
    public static final String COLUMN_NAME_ACTIVITY = "name_activity";
    public static final  String SCORE_TABLE="scores";
    public static final String COLUMN_SCORE_SCORE="score_score";



    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT UNIQUE,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_NOMBRE_USUARIO + " TEXT,"
            + COLUMN_APELLIDOS_USUARIO + " TEXT);"

            ;
    public static final String CREATE_TABLE_ACTIVITIES = " CREATE TABLE " + ACTIVITY_TABLE + "("
            + COLUMN_ACTIVITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME_ACTIVITY + " TEXT);";

   // public static final  String CREATE_TABLE_SCORES = " CREATE TABLE " + SCORE_TABLE + "("
            //+ COLUMN_ID + " INTEGER,"
            //+ COLUMN_ACTIVITY_ID + " INTEGER,"
            //+ COLUMN_SCORE_SCORE + " TEXT,CONSTRAINT FOREIGN KEY " + COLUMN_ID + " REFERENCES " + USER_TABLE + " (" + COLUMN_ID + ")"
            //+" ,CONSTRAINT FOREIGN KEY " + COLUMN_ACTIVITY_ID + " REFERENCES " + ACTIVITY_TABLE + " (" + COLUMN_ACTIVITY_ID + ")"
            //+" ,CONSTRAINT " + COLUMN_ID+"_"+COLUMN_ACTIVITY_ID+"_PK" + " PRIMARY KEY (" + USER_TABLE + "," + COLUMN_ID + ");";



    ////////////////////////////////////////
    private static final String CREATE_TABLE_SCORES = "CREATE TABLE "
            + SCORE_TABLE + " (" + COLUMN_SCORE_SCORE
            + "  text not null," + COLUMN_ID + " text,"
            + COLUMN_ACTIVITY_ID + " text," +
            " FOREIGN KEY ("+COLUMN_ACTIVITY_ID+") REFERENCES "+ACTIVITY_TABLE+" ("+COLUMN_ACTIVITY_ID+")," +
            " FOREIGN KEY ("+COLUMN_ID+") REFERENCES "+USER_TABLE+" ("+COLUMN_ID+")," +
            " CONSTRAINT score_pk PRIMARY KEY  ("+COLUMN_ID +", "+ COLUMN_ACTIVITY_ID+"));";




    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){
            if(!db.isReadOnly()){
                db.execSQL("PRAGMA foreign_keys=ON;");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_ACTIVITIES);
        db.execSQL(CREATE_TABLE_SCORES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SCORE_TABLE);
        onCreate(db);
    }


    public void addUser(String nombre_usuario,String apellidos_usuario, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE_USUARIO, nombre_usuario);
        values.put(COLUMN_APELLIDOS_USUARIO, apellidos_usuario);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        long id = db.insert(USER_TABLE, null, values);
        db.close();
        Log.d(TAG, "user inserted: " + id);
    }

    public boolean getUser(String email, String pass){
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_EMAIL + " = " + "'"+email+"'" + " and " + COLUMN_PASSWORD + " = " + "'"+pass+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public boolean getEmails(String email){
        String selectQuery="select "+COLUMN_EMAIL+" from "+ USER_TABLE +" where "+COLUMN_EMAIL+ " = "+"'"+email+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public String getIdUser(String idEmail){
        String selectQuery="select "+COLUMN_ID+" from "+ USER_TABLE +" where "+COLUMN_EMAIL+ " = "+"'"+idEmail+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            //do {
                String codigo= cursor.getString(0);
            //} while(cursor.moveToNext());
        //}
        cursor.close();
        db.close();
        return codigo;
    }

    // este metodo retorna el score asociado al usuario y actividad especifica
    public String getScore(String idUser, int idActivity){
        String data = null;
        String selectQuery="select "+COLUMN_SCORE_SCORE+" from "+ SCORE_TABLE +" where "+COLUMN_ID+ " = "+"'"+idUser+"' and "+COLUMN_ACTIVITY_ID+" = "+idActivity+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                cursor.moveToFirst();
                String score= cursor.getString(0);
                data = score;
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    //este metodo agrega a el score idusuario y idactividad a la tabla escore
    public void addScore(String score,String idUser,int idActivity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE_SCORE, score);
        values.put(COLUMN_ID, idUser);
        values.put(COLUMN_ACTIVITY_ID, idActivity);
        long id = db.insert(SCORE_TABLE, null, values);
        db.close();
        Log.d(TAG, "score inserted: " + id);
    }

    public void updateScore(String idUser, int idActivity,String score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE_SCORE, score);
        long id =  db.update(SCORE_TABLE,values,COLUMN_ID + " = " + idUser + " and " +
                COLUMN_ACTIVITY_ID + " = " + idActivity,null);
        db.close();
        Log.d(TAG, "score updated: " + id);
    }

    public String getActivities(){
        String data=null;
        String selectQuery="select "+ COLUMN_ACTIVITY_ID +" from "+ ACTIVITY_TABLE + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //cursor.moveToFirst();
        if(cursor.moveToFirst()){
            do{
                String activityId = cursor.getString(0);
                 data = activityId;
            }while(cursor.moveToNext());
        }
        cursor.close();
        return data;
    }


    public void addActivities (){
        int idActivity = 0;
        SQLiteDatabase db = getWritableDatabase();
        if (getActivities()==null) {
           db.execSQL("INSERT INTO activities (name_activity) " +
                    "VALUES ('Alphabet and Numbers'), " +
                    " ('Animals and Colors')," +
                    " ('Family and Clothes')," +
                    " ('Geometric Figures and Sports')," +
                    " ('Objects')," +
                    " ('Days of the Week')," +
                    " ('Mounths and Seasons of Year')," +
                    " ('Final Test');");
            Log.d(TAG, "activity table: "+idActivity);
        }
        db.close();
        //return idActivity;
    }

}
