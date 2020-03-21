package ng.dat.ar;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static ng.dat.ar.ARActivity.bunnyAlt;
import static ng.dat.ar.ARActivity.bunnyLat;
import static ng.dat.ar.ARActivity.bunnylng;

public class Report_drone extends AppCompatActivity {

    private StorageReference Folder;
    private static final int ImageBack=1;


    public Location location;
@Override
    protected void onCreate(Bundle savedInstanceState){

    super.onCreate(savedInstanceState);
    setContentView(R.layout.report_ar);

    Folder = FirebaseStorage.getInstance().getReference().child("Imagefolder");
        FirebaseDatabase database = FirebaseDatabase.getInstance();

                DatabaseReference myRef = database.getReference("Report/DeviceName");
                myRef.setValue("drone1");
                DatabaseReference myRef1 = database.getReference("Report/DeviceLat");
                myRef1.setValue(bunnyLat);
                DatabaseReference myRef2= database.getReference("Report/DeviceLon");
                myRef2.setValue(bunnylng);
                DatabaseReference myRef3 = database.getReference("Report/DeviceAlt");
                myRef3.setValue(bunnyAlt);

}

    public void UploadData(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,ImageBack);
}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ImageBack){
            if(resultCode==RESULT_OK){
                Toast.makeText(Report_drone.this,"uploading in Process",Toast.LENGTH_LONG).show();
                Uri ImageData = data.getData();
                StorageReference Imagename=Folder.child("image"+ImageData.getLastPathSegment());
                Imagename.putFile(ImageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){

                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Report_drone.this,"uploaded",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}



//
//
//
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("Report/DeviceName");
//        myRef.setValue("Drone");
//                DatabaseReference myRef1 = database.getReference("Report/DeviceLat");
//                myRef1.setValue(location.getLatitude());
//                DatabaseReference myRef2= database.getReference("Report/DeviceLon");
//                myRef2.setValue(location.getLongitude());
//                DatabaseReference myRef3 = database.getReference("Report/DeviceAlt");
//                myRef3.setValue(location.getAltitude());








