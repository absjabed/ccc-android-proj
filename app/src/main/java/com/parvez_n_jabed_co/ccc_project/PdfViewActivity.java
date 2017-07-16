package com.parvez_n_jabed_co.ccc_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
        import android.app.Activity;
        import android.os.Bundle;
        import android.util.Log;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
        import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
        import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
        import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
        import com.shockwave.pdfium.PdfDocument;

        import java.util.List;

public class PdfViewActivity extends AppCompatActivity implements OnPageChangeListener,OnLoadCompleteListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    public static String SAMPLE_FILE;
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    TextView activity_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        SAMPLE_FILE = getIntent().getStringExtra("pdfName");

        String activityname = getIntent().getStringExtra("ACTIVITYNAME");
        activity_title = (TextView) findViewById(R.id.activityTitle);
        if(activityname!=null) {
            activity_title.setText(activityname);
        }
        pdfView= (PDFView)findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);

    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }

}