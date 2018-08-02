package avinash.digitalplantationmanagement.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabasesHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "journals.db";
    public static final String TABLE_NAME = "tabledata";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "JOURNALS";
    public static final String COL_3 = "YEAR";
    public static final String COL_4 = "RANGE";

    public DatabasesHelper(Context context)
    {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="create table "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,JOURNALS TEXT,YEAR TEXT,RANGE TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }

    public boolean addData(String journal,String year,String range){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(COL_2,journal);
        contentValues.put(COL_3,year);
        contentValues.put(COL_4,range);
        long result=db.insert(TABLE_NAME,null ,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getListContent(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }
}
