package com.isn;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
 
public class ProductDataBaseAdapter 
{
        static final String DATABASE_NAME = "project.db";
        static final int DATABASE_VERSION = 1;
        public static final int NAME_COLUMN = 1;
        // TODO: Create public field for each column in your table.
        // SQL Statement to create a new database.
        static final String DATABASE_CREATE = "create table "+"MENPRODUCT"+
                                     "( " +"ID"+" integer primary key autoincrement,"+ "PRICE  integer"+"IMAGE text"+"DESCRIPTION text"+"NAME text"+"QUANTITY int); ";
        // Variable to hold the database instance
        public static  SQLiteDatabase db;
        // Context of the application using the database.
        private final Context context;
        // Database open/upgrade helper
        private DataBaseHelper dbHelper;
        public  ProductDataBaseAdapter(Context _context) 
        {
            context = _context;
            dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public  ProductDataBaseAdapter open() throws SQLException 
        {
            db = dbHelper.getWritableDatabase();
            return this;
        }
        public void close() 
        {
            db.close();
        }
 
        public  SQLiteDatabase getDatabaseInstance()
        {
            return db;
        }
 
        public static void insertEntry(int price,String image,String description,String name,int quantity )
        {
           ContentValues newValues = new ContentValues();
            // Assign values for each row.
            newValues.put("NAME", name);
            newValues.put("QUANTITY", quantity);
           	newValues.put("PRICE", price);
            newValues.put("DESCRIPTION",description);
            newValues.put("IMAGE",image);
            // Insert the row into your table
            db.insert("LOGIN", null, newValues);
            ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
        }
        public Cursor deleteEntry(String Name)
        {
            //String id=String.valueOf(ID);
           // String where="NAME=?";
            //int numberOFEntriesUpdate= 
            Cursor number =  db.rawQuery( "UPDATE  MENPRODUCT SET QUANTITY=(QUANTITY -1) where NAME="+Name+",QUANTIY >0", null );
           // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
            return number;
        }    
       /* public String getSinlgeEntry(String name,String image,String description,int price,int quantity)
        {
            Cursor cursor=db.rawQuery("INSERT INTO MENPRDUCT (PRICE,IMAGE,DESCRIPTION,NAME,QUANTITY) VALUES ("+price+image+description+name+quantity+"", null);
            if(cursor.getCount()<1) // UserName Not Exist
            {
                cursor.close();
                return "NOT EXIST";
            }
            cursor.moveToFirst();
            cursor.close();
            return password;                
        }
        public void  updateEntry(String userName,String password)
        {
            // Define the updated row content.
            ContentValues updatedValues = new ContentValues();
            // Assign values for each row.
            updatedValues.put("USERNAME", userName);
            updatedValues.put("PASSWORD",password);
 
            String where="USERNAME = ?";
            db.update("LOGIN",updatedValues, where, new String[]{userName});               
        }*/        
}