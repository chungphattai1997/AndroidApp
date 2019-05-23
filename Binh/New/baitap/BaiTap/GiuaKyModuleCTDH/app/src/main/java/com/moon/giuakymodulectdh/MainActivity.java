package com.moon.giuakymodulectdh;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButtonCloseCTDonDH;
    private Button btnInsertCT, buttonClearTextCT, btnEditCT;
    private EditText editTextSLDatCT;
    private ListView listViewCTDonDH;
    private ArrayList<CT_DonHang> data;
    private CTDHAdapter adapter;
    public static CT_DonHang ctDonDH;
    private int checkEditInsert = 0;
    private Spinner spinnerSoDDHCT, spinnerMaMatHang;

    private ArrayList<String> arrDonDH = new ArrayList<>();
    private ArrayList<String> arrMatHang = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        insertDB();
        setContentView(R.layout.activity_main);
        setControl();
    }

    private void setControl() {
        imageButtonCloseCTDonDH = findViewById(R.id.imageButtonCloseCTDonDH);
        btnInsertCT = findViewById(R.id.btnInsertCT);
        buttonClearTextCT = findViewById(R.id.buttonClearTextCT);
        btnEditCT = findViewById(R.id.btnEditCT);
        editTextSLDatCT = findViewById(R.id.editTextSLDatCT);

        listViewCTDonDH = findViewById(R.id.listViewCTDonDH);

        data = new ArrayList<>();
        adapter = new CTDHAdapter(this, data);
        listViewCTDonDH.setAdapter(adapter);
        loadDB();
        imageButtonCloseCTDonDH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);
        databaseHandler.getListSoDDH(arrDonDH);
        spinnerSoDDHCT = findViewById(R.id.spinnerSoDDHCT);
        ArrayAdapter<String> adapterDDH = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrDonDH);
        adapterDDH.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerSoDDHCT.setAdapter(adapterDDH);

        databaseHandler.getListMaMH(arrMatHang);
        spinnerMaMatHang = findViewById(R.id.spinnerMaMatHang);
        ArrayAdapter<String> adapterMH = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrMatHang);
        adapterMH.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerMaMatHang.setAdapter(adapterMH);
    }

    private  void insertDB(){
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
//        String sql = "Insert into KHACHHANG values('3', 'Anh')";
////        db.execSQL(sql);
////        String sql1 = "Insert into MATHANG values('3', 'Tu lanh', 'mat', 'cai','10000')";
////        db.execSQL(sql1);
////        String sql2 = "Insert into DONDH values('2', '2','04-04-2019 16:30:12:121','3','chua giao')";
////        db.execSQL(sql2);
//        String sql3 = "Insert into CTDONDH values('1', '3','10')";
//        db.execSQL(sql3);
    }
    private void loadDB() {
        DatabaseHandler db = new DatabaseHandler(this);
        data.clear();
        db.getCTDonDHs(data);
        adapter.notifyDataSetChanged();
    }

}
