package com.example.administrator.hourwork2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class progressActivity extends AppCompatActivity {
    private Button btnCircle , btnProgress;
    private ProgressDialog progressDialog ,progressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_progress );
        //btnCircle=findViewById( R.id.btnCircle );
        btnProgress=findViewById( R.id.btnProgress );
        btnProgress.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog( progressActivity.this );
                progressDialog.setMax( 100 );
                progressDialog.setMessage("Loading...");
                progressDialog.setTitle( "生命線" );
                progressDialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );
                progressDialog.show();
                new Thread( new Runnable() {
                    @Override
                    public void run() {
                        try{
                            while (progressDialog.getProgress() <= progressDialog.getMax()){
                                Thread.sleep( 20 );
                                handler.sendMessage( handler.obtainMessage() );
                                if (progressDialog.getProgress() == progressDialog.getMax()) {
                                    progressDialog.dismiss();
                                }
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                } ).start();
            }
            Handler handler =new Handler(  ){
                public void handleMessage(Message msg){
                    super.handleMessage( msg );
                    progressDialog.incrementProgressBy( 1 );
                }
            };
        } );
//    btnCircle.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            progressDialog2 = new ProgressDialog( progressActivity.this );
//            progressDialog2.setMax( 100 );
//            progressDialog2.setMessage("Loading...");
//            progressDialog2.setTitle( "生命線" );
//            progressDialog2.setProgressStyle( ProgressDialog.STYLE_SPINNER );
//            progressDialog2.show();
//            new Thread( new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        while (progressDialog2.getProgress() <= progressDialog2.getMax()){
//                            Thread.sleep( 20 );
//                            handler2.sendMessage( handler2.obtainMessage() );
//                            if (progressDialog2.getProgress() == progressDialog2.getMax()) {
//                                progressDialog2.dismiss();
//                            }
//                        }
//
//                    }catch(Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            } ).start();
//
//        }
//        Handler handler2 =new Handler(  ){
//            public void handleMessage2(Message msg){
//                super.handleMessage( msg );
//                progressDialog2.incrementProgressBy( 1 );
//            }
//        };
//    });
    }
}

