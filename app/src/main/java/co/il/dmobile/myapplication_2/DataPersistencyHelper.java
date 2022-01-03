package co.il.dmobile.myapplication_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars);
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.car1,"Mazda","Mazda-6","2019","$55K"));
            cars.add(new Car(R.drawable.car2,"Hyundai","i-20","2020","$60K"));
            cars.add(new Car(R.drawable.car3,"Jeep","Grand-Cherokee","2020","$200K"));
            cars.add(new Car(R.drawable.car4,"Jeep","Gladiator","2019","$180K"));
            cars.add(new Car(R.drawable.car5,"Audi","SUV7","2020","$250K"));
            cars.add(new Car(R.drawable.car6,"Tesla","Model S","2021","$150K"));
            cars.add(new Car(R.drawable.car7,"Hyundai","Tucson","2019","$30K"));
            cars.add(new Car(R.drawable.car8,"Mercedes-Benz","G-Wagon","2020","$300K"));
            return cars;
        }
    }

}
