package com.pickwick.ppapers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.pickwick.ppapers.DTOs.ExcerptDTO;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "exerptify.db";

    public static final String TABLE_NAME_BOOK = "books";
    public static final String COL_1_BOOK = "book_id";
    public static final String COL_2_BOOK = "book_name";
    public static final String COL_3_BOOK = "cover_image";

    public static final String TABLE_NAME_EXCERPT = "excerpts";
    public static final String COL_1_EXCERPT = "excerpt_id";
    public static final String COL_2_EXCERPT = "book_id";
    public static final String COL_3_EXCERPT = "excerpt_text";

    private Context context;

    String excerpt_content = "The more users invest time and effort into a product or service, the more they value it. In fact, there is ample evidence to suggest that our labor leads to love. We Irrationally Value Our Efforts In a 2011 study, Dan Ariely, Michael Norton, and Daniel Mochon measured the effect of labor on how people value things.4 U. S. college students in America were given instructions to assemble an origami crane or frog. After the exercise students were asked to purchase their creation, bidding up to $1. Assemblers were informed that a random number between zero and one hundred was to be drawn. If it exceeded their reservation price in cents, the assemblers would return empty-handed—but if it was equal to or less than their bid, they would pay their bid and keep the origami. Meanwhile, a separate group of students located in another room, unaware of the identity of the assemblers, were asked to bid on their origami using the same procedure. Similarly, a third independent group was asked to bid on expert-made origami under the same criteria. The results showed that those who made their own origami animals valued their creation five times higher than the second group’s valuation, and nearly as high as the expert-made origami values. In other words, those who invested labor associated greater value with their paper creations simply because they had worked on them. Ariely calls this the IKEA effect. IKEA, the world’s largest furniture retailer, sells affordable, ready-to-assemble household furnishings. The Swedish company’s key innovation is its packaging process, which allows the company to decrease labor costs, increase distribution efficiency, and better utilize the real estate in its stores." + "\n" +
            " Unlike its competitors who sell preassembled merchandise, IKEA puts its customers to work. It turns out there’s a hidden benefit to making users invest physical effort in assembling the product—by asking customers to assemble their own furniture, Ariely believes they adopt an irrational love of the furniture they built, just like the test subjects did in the origami experiments. Businesses that leverage user effort confer higher value to their products simply because their users have put work into them. The users have invested in the products through their labor.";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context.getApplicationContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME_BOOK + "(" + COL_1_BOOK + " integer primary key autoincrement, "
                + COL_2_BOOK + " varchar(200), " + COL_3_BOOK + " blob )");

        /*db.execSQL("INSERT INTO books(book_id,book_name,cover_image) VALUES(1,\"The IKEA Effect\")");
        db.execSQL("INSERT INTO books(book_id,book_name)\n" +
                "  VALUES(2,\"Three Click Rule\")");
        db.execSQL("INSERT INTO books(book_id,book_name)\n" +
                "  VALUES(3,\"What You See Is All There Is\")");*/

        insertIntoBooksTable(db,"The IKEA Effect", convertImageToByte(R.drawable.book1));
        insertIntoBooksTable(db, "Three Click Rule", convertImageToByte(R.drawable.book2));
        insertIntoBooksTable( db,"What You See Is All There Is", convertImageToByte(R.drawable.book3));

        db.execSQL("create table " + TABLE_NAME_EXCERPT + "(" + COL_1_EXCERPT + " integer primary key autoincrement, "
                + COL_2_EXCERPT + " integer, " + COL_3_EXCERPT + " varchar(1000), " +
                " foreign key (" + COL_2_EXCERPT + ")" + " references " + TABLE_NAME_BOOK + "(" + COL_1_BOOK + ")" +
                " )");


        db.execSQL("insert into excerpts (book_id, excerpt_text) values (1, \"The more users invest time and effort into a product or service, the more they value it. In fact, there is ample evidence to suggest that our labor leads to love. We Irrationally Value Our Efforts In a 2011 study, Dan Ariely, Michael Norton, and Daniel Mochon measured the effect of labor on how people value things.4 U. S. college students in America were given instructions to assemble an origami crane or frog. After the exercise students were asked to purchase their creation, bidding up to $1. Assemblers were informed that a random number between zero and one hundred was to be drawn. If it exceeded their reservation price in cents, the assemblers would return empty-handed—but if it was equal to or less than their bid, they would pay their bid and keep the origami. Meanwhile, a separate group of students located in another room, unaware of the identity of the assemblers, were asked to bid on their origami using the same procedure. Similarly, a third independent group was asked to bid on expert-made origami under the same criteria. The results showed that those who made their own origami animals valued their creation five times higher than the second group’s valuation, and nearly as high as the expert-made origami values. In other words, those who invested labor associated greater value with their paper creations simply because they had worked on them. Ariely calls this the IKEA effect. IKEA, the world’s largest furniture retailer, sells affordable, ready-to-assemble household furnishings. The Swedish company’s key innovation is its packaging process, which allows the company to decrease labor costs, increase distribution efficiency, and better utilize the real estate in its stores. Unlike its competitors who sell preassembled merchandise, IKEA puts its customers to work. It turns out there’s a hidden benefit to making users invest physical effort in assembling the product—by asking customers to assemble their own furniture, Ariely believes they adopt an irrational love of the furniture they built, just like the test subjects did in the origami experiments. Businesses that leverage user effort confer higher value to their products simply because their users have put work into them. The users have invested in the products through their labor.\")");
        db.execSQL("insert into excerpts (book_id, excerpt_text) values (2, \"The very first Airbnb product was simply the oddball idea and a WordPress website, but when it came time to get ready for the third launch, at the DNC in Denver, the founders had expanded their vision, going from a simple platform for housing supply for sold-out conferences to a website where you could book a room in someone’s home as easily as you could book a hotel room. But from the start, Chesky and Gebbia were emphatic about certain things regarding the website and the experience: specifically, it had to be frictionless, it had to be easy. The listings had to look beautiful. And, based on the famous three-click rule from Steve Jobs, a design hero of Chesky and Gebbia’s — when Jobs conceived the iPod, he wanted it to never be more than just three clicks away from a song — the founders wanted their users to never be more than three clicks away from a booking. In fact, what so many investors had seen as a red flag during those early pitch meetings — that Chesky and Gebbia were designers from RISD who lacked technical background — turned out to be one of their biggest assets. To them, design was not just about an object, or in their case a website; it was about how something worked — from the product to the interface to the experience. Later, this approach would infiltrate every aspect of their business, including the way they built the culture, conceived the offices, structured the company, and ran board meetings.\")");
        db.execSQL("insert into excerpts (book_id, excerpt_text) values (3, \"On September 3, plaintiff David Thornton, a forty-three-year-old union field representative, was present in Thrifty Drug Store #168, performing a routine union visit. Within ten minutes of his arrival, a store manager confronted him and told him he could no longer speak with the union employees on the floor of the store. Instead, he would have to see them in a back room while they were on break. Such a request is allowed by the union contract with Thrifty Drug but had never before been enforced. When Mr. Thornton objected, he was told that he had the choice of conforming to these requirements, leaving the store, or being arrested. At this point, Mr. Thornton indicated to the manager that he had always been allowed to speak to employees on the floor for as much as ten minutes, as long as no business was disrupted, and that he would rather be arrested than change the procedure of his routine visit. The manager then called the police and had Mr. Thornton handcuffed in the store for trespassing. After he was booked and put into a holding cell for a brief time, all charges were dropped. Mr. Thornton is suing Thrifty Drug for false arrest. In addition to this background material, which all participants read, different groups were exposed to presentations by the lawyers for the two parties. Naturally, the lawyer for the union organizer described the arrest as an intimidation attempt, while the lawyer for the store argued that having the talk in the store was disruptive and that the manager was acting properly. Some participants, like a jury, heard both sides. The lawyers added no useful information that you could not infer from the background story. The participants were fully aware of the setup, and those who heard only one side could easily have generated the argument for the other side. Nevertheless, the presentation of one-sided evidence had a very pronounced effect on judgments. Furthermore, participants who saw one-sided evidence were more confident of their judgments than those who saw both sides. This is just what you would expect if the confidence that people experience is determined by the coherence of the story they manage to construct from available information. It is the consistency of the information that matters for a good story, not its completeness. Indeed, you will often find that knowing little makes it easier to fit everything you know into a coherent pattern.\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME_BOOK);
        db.execSQL("drop table if exists " + TABLE_NAME_EXCERPT);
        onCreate(db);
    }

    public List<ExcerptDTO> getExcerptsList() {

        String sql = "select e." + COL_1_BOOK + ", e." + COL_1_EXCERPT + ", b." + COL_2_BOOK + ", e." + COL_3_EXCERPT + ", b." + COL_3_BOOK
                + " from " + TABLE_NAME_BOOK + " b join " + TABLE_NAME_EXCERPT + " e on e.book_id = b.book_id";

        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);

        ArrayList<ExcerptDTO> excerptList = new ArrayList<>();
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    int bookId = Integer.parseInt(cursor.getString(0));
                    int excerptId = Integer.parseInt(cursor.getString(1));
                    String bookName = cursor.getString(2);
                    String excerptText = cursor.getString(3);
                    byte[] imageBlob = cursor.getBlob(4);
                    ExcerptDTO dto = new ExcerptDTO(bookId, excerptId, bookName, excerptText, imageBlob);
                    excerptList.add(dto);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return excerptList;
    }
    public byte[] convertImageToByte(int drawable){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = ((BitmapDrawable) ContextCompat.getDrawable(context, drawable)).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return baos.toByteArray();
    }

    public void insertIntoBooksTable(SQLiteDatabase db,  String bookName, byte[] imageBlob){
        ContentValues values = new ContentValues();
        //values.put(COL_1_BOOK, bookId);
        values.put(COL_2_BOOK, bookName);
        values.put(COL_3_BOOK, imageBlob);
        db.insert(TABLE_NAME_BOOK, null, values);
    }
}
