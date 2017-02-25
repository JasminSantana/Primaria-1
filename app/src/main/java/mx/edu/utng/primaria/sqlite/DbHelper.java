package mx.edu.utng.primaria.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
    public static final String COLUMN_NAME_ACTVITY = "nombre_activity";
    public static final  String SCORE_TABLE="scores";
    public static final String COLUMN_SCORE_SCORE="score_score";



    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT UNIQUE,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_NOMBRE_USUARIO + " TEXT,"
            + COLUMN_APELLIDOS_USUARIO + " TEXT);"

            ;
    public static final String CREATE_TABLE_ACTIVITIES ="CREATE TABLE"+ACTIVITY_TABLE+"("
            + COLUMN_ACTIVITY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME_ACTVITY+ "TEXT);";

    public static final  String CREATE_TABLE_SCORES="CREATE TABLE"+SCORE_TABLE+"("
            + COLUMN_ID+"INTEGER,"
            + COLUMN_ACTIVITY_ID+"INTEGER,"
            + COLUMN_SCORE_SCORE+"TEXT,FOREIGN KEY ("+COLUMN_ID+")REFERENCES "+USER_TABLE+"("+COLUMN_ID+")"
            +",FOREIGN KEY ("+COLUMN_ACTIVITY_ID+")REFERENCES "+ACTIVITY_TABLE+"("+COLUMN_ACTIVITY_ID+")"
            +",CONSTRAINT ("+COLUMN_ID+"_"+COLUMN_ACTIVITY_ID+"_PK"+")PRIMARY KEY ("+USER_TABLE+","+COLUMN_ID+");";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE+","+ACTIVITY_TABLE+","+SCORE_TABLE);
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

        Log.d(TAG, "user inserted" + id);

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

}
