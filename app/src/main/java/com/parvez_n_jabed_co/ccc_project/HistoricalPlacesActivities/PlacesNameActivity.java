package com.parvez_n_jabed_co.ccc_project.HistoricalPlacesActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormListActivity;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.FormTypes;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.OtherVariousFormsActivity;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.TaxRelatedFormsActivity;
import com.parvez_n_jabed_co.ccc_project.FormRelatedActivities.TenderRelatedFormsActivity;
import com.parvez_n_jabed_co.ccc_project.OnlyClasses.CustomList;
import com.parvez_n_jabed_co.ccc_project.R;

public class PlacesNameActivity extends AppCompatActivity {


    ListView list;
    String[] web = {
            "ফয়েজ লেক",
            "জাতিতাত্ত্বিক যাদুঘর(চট্রগ্রাম)",
            "চট্টগ্রাম চিড়িয়াখানা",
            "পতেঙ্গা সমুদ্র সৈকত",
            "চট্টগ্রাম ওয়ার সিমেট্রি",
            "বাটালী হিল",
            "কোর্ট বিল্ডিং",
            "বায়েজিদ বোস্তামী",
            "ভাটিয়ারী",
            "লালদীঘি"
    } ;
    int imageId = R.mipmap.ic_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_name);

        CustomList adapter = new
                CustomList(PlacesNameActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(position== FormTypes.FOYS_LAKE)
                {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeFoyzLake);
                    extras.putInt("info", R.string.placeFoyzLakeInfo);
                    extras.putInt("go", R.string.placeFoyzLakeGo);
                    extras.putInt("location", R.string.placeFoyzLakeLocation);
                    extras.putInt("image", R.drawable.foys_lake);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.JATI_MEUSEUM)
                {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeJatiMesume);
                    extras.putInt("info", R.string.placeJatiMesumeInfo);
                    extras.putInt("go", R.string.placeJatiMesumeGo);
                    extras.putInt("location", R.string.placeJatiMesumeLocation);
                    extras.putInt("image", R.drawable.jatitattik_jadughor);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.CTG_ZOO) {

                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeCtgZoo);
                    extras.putInt("info", R.string.placeCtgZooInfo);
                    extras.putInt("go", R.string.placeCtgZooGo);
                    extras.putInt("location", R.string.placeCtgZooLocation);
                    extras.putInt("image", R.drawable.chittagongzoo);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.POTENGA_SEA_BEACH) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placePotenga);
                    extras.putInt("info", R.string.placePotengaInfo);
                    extras.putInt("go", R.string.placePotengaGo);
                    extras.putInt("location", R.string.placePotengaLocation);
                    extras.putInt("image", R.drawable.potengaseabeach);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.CTG_WAR_CEMETRY) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeWarCemetry);
                    extras.putInt("info", R.string.placeWarCemetryInfo);
                    extras.putInt("go", R.string.placeWarCemetryGo);
                    extras.putInt("location", R.string.placeWarCemetryLocation);
                    extras.putInt("image", R.drawable.ctgwarcemetry);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.BATALI_HILL) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeBataliHill);
                    extras.putInt("info", R.string.placeBataliHillInfo);
                    extras.putInt("go", R.string.placeBataliHillGo);
                    extras.putInt("location", R.string.placeBataliHillLocation);
                    extras.putInt("image", R.drawable.batalihill);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.COURT_BUILDING) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeCourtBuilding);
                    extras.putInt("info", R.string.placeCourtBuildingInfo);
                    extras.putInt("go", R.string.placeCourtBuildingGo);
                    extras.putInt("location", R.string.placeCourtBuildingLocation);
                    extras.putInt("image", R.drawable.courtbuilding);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.BAYZID_BOSTAMI) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeBaizidBostami);
                    extras.putInt("info", R.string.placeBaizidBostamiInfo);
                    extras.putInt("go", R.string.placeBaizidBostamiGo);
                    extras.putInt("location", R.string.placeBaizidBostamiLocation);
                    extras.putInt("image", R.drawable.baizidbostami);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.VATIYARI) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeVatiyari);
                    extras.putInt("info", R.string.placeVatiyariInfo);
                    extras.putInt("go", R.string.placeVatiyariGo);
                    extras.putInt("location", R.string.placeVatiyariLocation);
                    extras.putInt("image", R.drawable.vatiyari);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
                else if(position==FormTypes.LALDIGHI) {
                    Bundle extras = new Bundle();
                    extras.putInt("title", R.string.placeLaldighi);
                    extras.putInt("info", R.string.placeLaldighiInfo);
                    extras.putInt("go", R.string.placeLaldighiGo);
                    extras.putInt("location", R.string.placeLaldighiLocation);
                    extras.putInt("image", R.drawable.laldighi);

                    Intent intent = new Intent(PlacesNameActivity.this,PlacesViewActivity.class);
                    intent.putExtras(extras);

                    startActivity(intent);
                }
            }
        });
    }
}
